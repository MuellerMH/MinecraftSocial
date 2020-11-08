package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AdminMenu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.JailMenu;

public class AdminItem extends MenuItem {
<<<<<<< HEAD
	
	public AdminItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
=======

	public AdminItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon, 1));
>>>>>>> b4ade11... add new directory
	}

	@Override
	public void onClick(Player p) {
<<<<<<< HEAD
		
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
		
=======

		switch (this.getText()) {
			case "Hauptmenu":

				Gui.switchMenu(p, AdminMenu.menu, Hauptmenu.menu);
				break;

			case "JailMenu":
				Menu menuJail = new Menu("Gefï¿½ngnis Menu", 3);
				JailMenu.loadMenu(menuJail, p);
				Gui.switchMenu(p, AdminMenu.menu, menuJail);
				break;
		}

>>>>>>> b4ade11... add new directory
	}
}