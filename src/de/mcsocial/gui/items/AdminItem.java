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

	public AdminItem(String text, Material icon) {

		super(text, new ItemStack(icon, 1));
	}

	@Override
	public void onClick(Player p) {

		switch (this.getText()) {
			case "Hauptmenu":

				Gui.switchMenu(p, AdminMenu.menu, Hauptmenu.menu);
				break;

			case "JailMenu":
				Menu menuJail = new Menu("Gefängnis Menu", 3);
				JailMenu.loadMenu(menuJail, p);
				Gui.switchMenu(p, AdminMenu.menu, menuJail);
				break;
		}

	}
}