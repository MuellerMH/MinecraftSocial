package de.mcsocial.gui.items;

<<<<<<< HEAD
import java.util.Arrays;
=======
import java.util.ArrayList;
>>>>>>> b4ade11... add new directory
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
		// TODO Auto-generated constructor stub
<<<<<<< HEAD
		super(text, new ItemStack(icon,1));
=======
		super(text, new ItemStack(icon, 1));
>>>>>>> b4ade11... add new directory
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub

		Menu playerSelect;
		int needetRows = 3;
<<<<<<< HEAD
		
		switch(this.getText()){
		
=======

		switch (this.getText()) {

>>>>>>> b4ade11... add new directory
			case "Stadt aufloesen":
				// TODO Auto-generated method stub
				City.removeCity(p);
				ChunkHandler.removeCity(p);
<<<<<<< HEAD
				p.sendMessage("Grundtückt wurde aus der Stadt entfernt.");
	
=======
				p.sendMessage("Grundtï¿½ckt wurde aus der Stadt entfernt.");

>>>>>>> b4ade11... add new directory
				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Grundstueck entfernen":
				// TODO Auto-generated method stub
				CustomChunk chunk = ChunkHandler.getChunk(p.getLocation().getChunk());
				chunk.setCity(null);
				ChunkHandler.save(chunk);
				ChunkHandler.ownedChunks.put(p.getLocation().getChunk().toString(), chunk);
<<<<<<< HEAD
				p.sendMessage("Grundtückt wurde aus der Stadt entfernt.");
	
=======
				p.sendMessage("Grundtï¿½ckt wurde aus der Stadt entfernt.");

>>>>>>> b4ade11... add new directory
				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Grundstueck hinzufuegen":
				// TODO Auto-generated method stub
				CustomChunk addChunk = ChunkHandler.getChunk(p.getLocation().getChunk());
				addChunk.setCity(p);
				ChunkHandler.save(addChunk);
				ChunkHandler.ownedChunks.put(p.getLocation().getChunk().toString(), addChunk);
<<<<<<< HEAD
				p.sendMessage("Grundtückt wurde der Stadt hinzugefügt.");
=======
				p.sendMessage("Grundtï¿½ckt wurde der Stadt hinzugefï¿½gt.");
>>>>>>> b4ade11... add new directory

				CityManagerMenu.menu.closeMenu(p);
				return;
			case "Hauptmenu":
				// TODO Auto-generated method stub
				Gui.switchMenu(p, CityManagerMenu.menu, Hauptmenu.menu);
				return;
			case "Stadt verwalten":
<<<<<<< HEAD
				Menu chunkMenu = new Menu("Stadt verwalten",3);
				Gui.switchMenu(p, Hauptmenu.menu, chunkMenu);
				CityManagerMenu.loadMenu(chunkMenu,p);	
				return;
			case "Spieler entfernen":
				needetRows = Math.max(1,(int)Math.ceil(City.residentList.size()/9));
				playerSelect = new Menu("Spieler wählen",(int)Math.ceil(needetRows));
				CityManagerMenu.nextAction = "remove";
				CityManagerMenu.createPlayerMenu(playerSelect,City.residentList);
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				return;
			case "Spieler hinzufuegen":
				@SuppressWarnings("deprecation")
				List<Player> allPlayer = Arrays.asList(Bukkit.getServer().getOnlinePlayers());
				needetRows = Math.max(1,(int)Math.ceil(allPlayer.size()/9));
				playerSelect = new Menu("Spieler wählen",needetRows);
				CityManagerMenu.nextAction = "add";
				CityManagerMenu.createPlayerMenu(playerSelect,allPlayer);
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				return;
			default:
				switch(CityManagerMenu.nextAction){				
					case"remove":
						City.remove(Bukkit.getPlayer(this.uuid),this.cityObject);
						CityManagerMenu.getP().sendMessage("Spieler wurde entfernt.");
						CityManagerMenu.menu.closeMenu(p);
						return;
					case"add":
						City.add(Bukkit.getPlayer(this.uuid),this.cityObject);	
						CityManagerMenu.getP().sendMessage("Spieler wurde hinzugefügt: " + Bukkit.getPlayer(this.uuid).getName());
						CityManagerMenu.menu.closeMenu(p);	
=======
				Menu chunkMenu = new Menu("Stadt verwalten", 3);
				Gui.switchMenu(p, Hauptmenu.menu, chunkMenu);
				CityManagerMenu.loadMenu(chunkMenu, p);
				return;
			case "Spieler entfernen":
				needetRows = Math.max(1, (int) Math.ceil(City.residentList.size() / 9));
				playerSelect = new Menu("Spieler wï¿½hlen", (int) Math.ceil(needetRows));
				CityManagerMenu.nextAction = "remove";
				CityManagerMenu.createPlayerMenu(playerSelect, City.residentList);
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				return;
			case "Spieler hinzufuegen":
				List<Player> allPlayer = new ArrayList<Player>(Bukkit.getServer().getOnlinePlayers());
				needetRows = Math.max(1, (int) Math.ceil(allPlayer.size() / 9));
				playerSelect = new Menu("Spieler wï¿½hlen", needetRows);
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
						CityManagerMenu.getP().sendMessage("Spieler wurde hinzugefï¿½gt: " + Bukkit.getPlayer(this.uuid).getName());
						CityManagerMenu.menu.closeMenu(p);
>>>>>>> b4ade11... add new directory
						return;
					default:
						CityManagerMenu.menu.closeMenu(p);
						return;
				}
		}
<<<<<<< HEAD
		
=======

>>>>>>> b4ade11... add new directory
	}

	public void setUUID(UUID uniqueId) {
		// TODO Auto-generated method stub
		this.uuid = uniqueId;
<<<<<<< HEAD
		
	}

	
	public UUID getUUID() {
		return this.uuid;
		
=======

	}

	public UUID getUUID() {
		return this.uuid;

>>>>>>> b4ade11... add new directory
	}

	public void setCity(City value) {
		// TODO Auto-generated method stub
		this.cityObject = value;
<<<<<<< HEAD
		
=======

>>>>>>> b4ade11... add new directory
	}
}
