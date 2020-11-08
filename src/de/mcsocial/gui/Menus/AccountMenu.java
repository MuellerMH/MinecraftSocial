package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.AccountItem;

public class AccountMenu {
	public static Menu menu;
	private static Player p;

	public static void loadMenu(Menu menuAccount, Player p) {
		AccountMenu.setP(p);
		AccountMenu.menu = menuAccount;

		AccountMenu.accountBalance();
		AccountMenu.closeMenu();
		AccountMenu.transMoney();
	}

	private static void accountBalance() {

		AccountItem item = new AccountItem("Kontostand", Material.GOLD_INGOT);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt deinen Aktuellen Kontostand.");
		item.setDescriptions(lines);

		AccountMenu.menu.addMenuItem(item, 0);
	}

	private static void transMoney() {

		AccountItem item = new AccountItem("Spieler Geld geben", Material.GOLD_INGOT);
		List<String> lines = new LinkedList<String>();
		item.setDescriptions(lines);

		AccountMenu.menu.addMenuItem(item, 1);
	}

	private static void closeMenu() {

		AccountItem item = new AccountItem("Spieler Menu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

		AccountMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		AccountMenu.p = p;
	}

}
