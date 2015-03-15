package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.CityManagerItem;

public class CityManagerMenu {
	public static Menu menu;
	private static Player p;
	
	public static void loadMenu(Menu menuAccount,Player p) {
		CityManagerMenu.setP(p);
		CityManagerMenu.menu = menuAccount;
		
		CityManagerMenu.closeMenu();
	}
	
	private static void closeMenu()	{
			
		CityManagerItem item = new CityManagerItem("Hauptmenu",Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);


		CityManagerMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		CityManagerMenu.p = p;
	}
}
