package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.CityManagerMenu;
import de.mcsocial.gui.Menus.Hauptmenu;

public class CityManagerItem extends MenuItem {
	
	public CityManagerItem(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public CityManagerItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub
		
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
		}
		
	}
}
