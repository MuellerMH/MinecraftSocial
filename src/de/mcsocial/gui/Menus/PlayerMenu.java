package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.PlayerItem;

public class PlayerMenu {

	public static Menu menu;
	private static Player p;

	public static void loadMenu(Menu menu, Player p) {
		PlayerMenu.p = p;
		PlayerMenu.menu = menu;
		PlayerMenu.closeMenu();
		PlayerMenu.money();
		PlayerMenu.minerInfo();
		PlayerMenu.stats();
		PlayerMenu.playerstats();
		PlayerMenu.alljobs();
		PlayerMenu.myjobs();
		PlayerMenu.leavejobs();
		PlayerMenu.joinjob();
	}

	private static void money() {

		PlayerItem itemmoney = new PlayerItem("Konto", Material.GOLD_INGOT);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt das Konto Menu.");
		itemmoney.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(itemmoney, 0);
	}

	private static void stats() {

		PlayerItem itemstats = new PlayerItem("Level Status", Material.PAINTING);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt deine aktuellen Skills und Level");
		itemstats.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(itemstats, 1);
	}

	private static void myjobs() {
		if (!PlayerMenu.p.hasMetadata("job")) {
			return;
		}
		if (PlayerMenu.p.getMetadata("job").get(0).asString().isEmpty()) {
			return;
		}
		PlayerItem item = new PlayerItem("Mein Beruf", Material.DIAMOND_PICKAXE);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu deinem Beruf");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 9);
	}

	private static void leavejobs() {
		if (!PlayerMenu.p.hasMetadata("job")) {
			return;
		}
		if (PlayerMenu.p.getMetadata("job").get(0).asString().isEmpty()) {
			return;
		}
		PlayerItem item = new PlayerItem("Beruf aufgeben", Material.WOODEN_PICKAXE);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu deinem Beruf");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 10);
	}

	private static void joinjob() {
		if (PlayerMenu.p.hasMetadata("job")) {
			return;
		}

		PlayerItem item = new PlayerItem("Beruf annehmen", Material.GOLDEN_PICKAXE);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu deinem Beruf");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 11);
	}

	private static void alljobs() {

		PlayerItem item = new PlayerItem("Berufe Uebersicht", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt alle verfï¿½gbaren Berufe");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 8);
	}

	@SuppressWarnings("deprecation")
	private static void playerstats() {
		if (!p.isOp())
			return;
		PlayerItem item = new PlayerItem("PlayerStats", Material.LEGACY_FIREBALL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt PlayerStats an.");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 24);
	}

	private static void minerInfo() {
		if (!p.isOp())
			return;

		PlayerItem item = new PlayerItem("MinerInfo", Material.OBSIDIAN);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt MinerInfo an.");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 25);
	}

	private static void closeMenu() {

		PlayerItem item = new PlayerItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

		PlayerMenu.menu.addMenuItem(item, 26);
	}
}
