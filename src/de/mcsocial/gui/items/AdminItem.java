package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AdminMenu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.JailMenu;

public class AdminItem extends MenuItem {
	
	public AdminItem(String text) {
		super(text);
	}
	
	public AdminItem(String text, Material materialData) {
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player p) {
		
		switch(this.getText()){
			case "Hauptmenu":
				
				Gui.switchMenu(p, AdminMenu.menu, Hauptmenu.menu);
				break;		

			case "JailMenu":
				Menu menuJail = new Menu("Gefängnis Menu",3);
				JailMenu.loadMenu(menuJail,p);
				Gui.switchMenu(p, AdminMenu.menu, menuJail);
				break;			
		}
		
	}
}