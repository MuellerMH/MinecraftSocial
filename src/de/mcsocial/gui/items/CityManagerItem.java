package de.mcsocial.gui.items;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.city.City;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.CityManagerMenu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.CustomChunk;

public class CityManagerItem extends MenuItem {

	private UUID uuid;
	private City cityObject;

	public CityManagerItem(String text, Material icon) {

		super(text, new ItemStack(icon, 1));
	}

	@Override
	public void onClick(Player p) {


		Menu playerSelect;
		int needetRows = 3;

		switch (this.getText()) {

			case "Stadt aufloesen":

				City.removeCity(p);
				ChunkHandler.removeCity(p);
				p.sendMessage("Grundtückt wurde aus der Stadt entfernt.");

				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Grundstueck entfernen":

				CustomChunk chunk = ChunkHandler.getChunk(p.getLocation().getChunk());
				chunk.setCity(null);
				ChunkHandler.save(chunk);
				ChunkHandler.ownedChunks.put(p.getLocation().getChunk().toString(), chunk);
				p.sendMessage("Grundtückt wurde aus der Stadt entfernt.");

				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Grundstueck hinzufuegen":

				CustomChunk addChunk = ChunkHandler.getChunk(p.getLocation().getChunk());
				addChunk.setCity(p);
				ChunkHandler.save(addChunk);
				ChunkHandler.ownedChunks.put(p.getLocation().getChunk().toString(), addChunk);
				p.sendMessage("Grundtückt wurde der Stadt hinzugefügt.");

				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Hauptmenu":

				Gui.switchMenu(p, CityManagerMenu.menu, Hauptmenu.menu);
				return;
			case "Stadt verwalten":
				Menu chunkMenu = new Menu("Stadt verwalten", 3);
				Gui.switchMenu(p, Hauptmenu.menu, chunkMenu);
				CityManagerMenu.loadMenu(chunkMenu, p);
				return;
			case "Spieler entfernen":
				needetRows = Math.max(1, (int) Math.ceil(City.residentList.size() / 9));
				playerSelect = new Menu("Spieler wählen", (int) Math.ceil(needetRows));
				CityManagerMenu.nextAction = "remove";
				CityManagerMenu.createPlayerMenu(playerSelect, City.residentList);
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				return;
			case "Spieler hinzufuegen":
				List<Player> allPlayer = new ArrayList<Player>(Bukkit.getServer().getOnlinePlayers());
				needetRows = Math.max(1, (int) Math.ceil(allPlayer.size() / 9));
				playerSelect = new Menu("Spieler wählen", needetRows);
				CityManagerMenu.nextAction = "add";
				CityManagerMenu.createPlayerMenu(playerSelect, allPlayer);
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				return;
			default:
				switch (CityManagerMenu.nextAction) {
					case "remove":
						City.remove(Bukkit.getPlayer(this.uuid), this.cityObject);
						CityManagerMenu.getP().sendMessage("Spieler wurde entfernt.");
						CityManagerMenu.menu.closeMenu(p);
						return;
					case "add":
						City.add(Bukkit.getPlayer(this.uuid), this.cityObject);
						CityManagerMenu.getP().sendMessage("Spieler wurde hinzugefügt: " + Bukkit.getPlayer(this.uuid).getName());
						CityManagerMenu.menu.closeMenu(p);
						return;
					default:
						CityManagerMenu.menu.closeMenu(p);
						return;
				}
		}
	}

	public void setUUID(UUID uniqueId) {

		this.uuid = uniqueId;

	}

	public UUID getUUID() {
		return this.uuid;

	}

	public void setCity(City value) {

		this.cityObject = value;
	}
}
