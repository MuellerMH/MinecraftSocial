package de.mcsocial.gui.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
import de.mcsocial.gui.Menus.CityManagerMenu;
import de.mcsocial.protection.Jail;

public class CityManagerItem extends MenuItem {

	private UUID uuid;
	private City city;

	public CityManagerItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub

		Menu playerSelect;
		int needetRows = 3;
		
		switch(this.getText()){
			case "Hauptmenu":
				// TODO Auto-generated method stub
				Gui.switchMenu(p, CityManagerMenu.menu, Hauptmenu.menu);
				break;
			case "Stadt verwalten":
				Menu chunkMenu = new Menu("Stadt verwalten",3);
				Gui.switchMenu(p, Hauptmenu.menu, chunkMenu);
				CityManagerMenu.loadMenu(chunkMenu,p);	
				break;
			case "Spieler entfernen":
				needetRows = Math.max(1,(int)Math.ceil(City.residentList.size()/9));
				playerSelect = new Menu("Spieler wählen",(int)Math.ceil(needetRows));
				CityManagerMenu.createPlayerMenu(playerSelect,City.residentList,"remove");
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				break;
			case "Spieler hinzufuegen":
				List<Player> allPlayer = Arrays.asList(Bukkit.getServer().getOnlinePlayers());
				needetRows = Math.max(1,(int)Math.ceil(allPlayer.size()/9));
				playerSelect = new Menu("Spieler wählen",needetRows);
				CityManagerMenu.createPlayerMenu(playerSelect,allPlayer,"add");
				Gui.switchMenu(p, CityManagerMenu.menu, playerSelect);
				break;
			default:
				switch(CityManagerMenu.nextAction){				
				case"remove":
					City.residentList.remove(this.uuid);
					break;			
				case"add":
					City.residentList.put(this.uuid,this.city);					  
					break;
				default:
					break;
				}
				CityManagerMenu.menu.closeMenu(p);
				break;
		}
		
	}

	public void setUUID(UUID uniqueId) {
		// TODO Auto-generated method stub
		this.uuid = uniqueId;
		
	}

	
	public UUID getUUID() {
		return this.uuid;
		
	}

	public void setCity(City value) {
		// TODO Auto-generated method stub
		this.city = value;
		
	}
}
