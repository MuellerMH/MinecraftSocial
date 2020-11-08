package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.ChunkItem;

public class ChunkMenu {
	public static Menu menu;

	private static Player p;

	public static void loadMenu(Menu menu, Player p) {
		ChunkMenu.setP(p);
		ChunkMenu.menu = menu;
		ChunkMenu.addForSellButton();
		ChunkMenu.addRemoveButton();
		ChunkMenu.closeMenu();
		ChunkMenu.addSetOwnerButton();
		ChunkMenu.addButton();
	}

	private static void addForSellButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck verkaufen", Material.GOLD_BLOCK);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundst�ck verkaufen?");
		lines.add("Kann nur von Stadt Bewohnern gekauft werden.");
		lines.add("Klicken um das Grundst�ck zu verkaufen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 0);
	}

	private static void addSetOwnerButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck vergeben", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundst�ck vergeben?");
		lines.add("Grundst�ck einem Bewohner zuweisen.");
		lines.add("Klicken und das Grundst�ck zuweisen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 1);
	}

	private static void addRemoveButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck aufgeben", Material.DIRT);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundst�ck aufgeben?");
		lines.add("Grundst�ck geh�rt dann nicht mehr der Stadt.");
		lines.add("Klicken um das Grundst�ck aufzugeben.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 9);
	}

	private static void addButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck einnehmen", Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundst�ck einnehmen?");
		lines.add("Grundst�ck geh�rt dann der Stadt.");
		lines.add("Klicken um das Grundst�ck einzunehmen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 10);
	}

	private static void closeMenu() {

		ChunkItem item = new ChunkItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zur�ck zum Hauptmenu.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		ChunkMenu.p = p;
	}
}
