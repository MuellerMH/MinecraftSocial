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
		ChunkItem item = new ChunkItem("Grundstueck verkaufen", Material.GOLD_BLOCK);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstück verkaufen?");
		lines.add("Kann nur von Stadt Bewohnern gekauft werden.");
		lines.add("Klicken um das Grundstück zu verkaufen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 0);
	}

	private static void addSetOwnerButton() {
		ChunkItem item = new ChunkItem("Grundstueck vergeben", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstück vergeben?");
		lines.add("Grundstück einem Bewohner zuweisen.");
		lines.add("Klicken und das Grundstück zuweisen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 1);
	}

	private static void addRemoveButton() {
		ChunkItem item = new ChunkItem("Grundstueck aufgeben", Material.DIRT);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstück aufgeben?");
		lines.add("Grundstück gehört dann nicht mehr der Stadt.");
		lines.add("Klicken um das Grundstück aufzugeben.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 9);
	}

	private static void addButton() {
		ChunkItem item = new ChunkItem("Grundstueck einnehmen", Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstück einnehmen?");
		lines.add("Grundstück gehört dann der Stadt.");
		lines.add("Klicken um das Grundstück einzunehmen.");
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 10);
	}

	private static void closeMenu() {

		ChunkItem item = new ChunkItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
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
