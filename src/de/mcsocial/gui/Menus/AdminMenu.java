package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.AdminItem;
import de.mcsocial.permissions.PlayerPermissions;

public class AdminMenu {
	public static Menu menu;
	private static Player p;

	public static void loadMenu(Menu menu, Player p) {
		AdminMenu.setP(p);
		AdminMenu.menu = menu;

		closeMenu();
		addJail();
	}

	private static void addJail() {
		if (!PlayerPermissions.hasAccess(p, "moderator"))
			return;
		AdminItem item = new AdminItem("JailMenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zum Gefängnis Menu");
		item.setDescriptions(lines);

		AdminMenu.menu.addMenuItem(item, 0);
	}

	private static void closeMenu() {

		AdminItem item = new AdminItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);

		AdminMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		AdminMenu.p = p;
	}
}
