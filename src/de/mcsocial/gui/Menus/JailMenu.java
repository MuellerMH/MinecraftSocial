package de.mcsocial.gui.Menus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.JailItem;
import de.mcsocial.protection.Jail;

public class JailMenu {
	public static Menu menu;
	private static Player p;

	public static String nextAction = "";

	public static void loadMenu(Menu menu, Player player) {
		JailMenu.setP(player);
		JailMenu.menu = menu;
		int i = 0;

		addToJail(i++);
		removeFromJail(i++);
		createNewCell(i++);
		i++;

		for (Location cell : Jail.getCellList()) {
			JailMenu.createJailCellSpawn(cell, i++);
		}
	}

	private static void createJailCellSpawn(Location cell, int pos) {
		JailItem item = new JailItem("Zelle " + pos, Material.ENDER_PEARL);
		item.setIsCellSpawn(true);
		item.setLocation(cell);
		List<String> lines = new LinkedList<String>();
		lines.add("Telport zur Zelle.");
		item.setDescriptions(lines);
		JailMenu.nextAction = "teleport";
		JailMenu.menu.addMenuItem(item, pos);
	}

	private static void addToJail(int pos) {
		JailItem item = new JailItem("einsperren", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Sperrt einen Spieler ins GefÃ¤ngniss.");
		item.setDescriptions(lines);
		JailMenu.menu.addMenuItem(item, pos);
	}

	private static void removeFromJail(int pos) {
		JailItem item = new JailItem("frei lassen", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("lÃ¤sst einen Spieler aus dem GefÃ¤ngniss.");
		item.setDescriptions(lines);
		JailMenu.menu.addMenuItem(item, pos);
	}

	public static void createPlayerMenu(Menu playerSelect, List<Player> allPlayer, String action) {

		int i = 0;
		for (Player pl : allPlayer) {
			JailItem item = new JailItem(pl.getName(), Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler einsperren?");
			lines.add("Zum einsperren klicken.");
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			JailMenu.nextAction = action;
			playerSelect.addMenuItem(item, i++);
		}

	}

	public static void createPlayerMenu(Menu playerSelect, HashMap<Player, Integer> prisonerAll, String action) {

		int i = 0;
		Iterator<Entry<Player, Integer>> allCell = prisonerAll.entrySet().iterator();
		while (allCell.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) allCell.next();
			Player pl = (Player) pair.getKey();
			JailItem item = new JailItem(pl.getName(), Material.ENDER_PEARL);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler frei lassen?");
			lines.add("Zum frei lassen klicken.");
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			JailMenu.nextAction = action;
			playerSelect.addMenuItem(item, i++);
		}

	}

	public static void createNewCell(int pos) {

		JailItem item = new JailItem("Neue Zelle", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Hier eine neue Zelle erstellen?");
		lines.add("Zum erstellen klicken.");
		item.setDescriptions(lines);
		JailMenu.menu.addMenuItem(item, pos);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		JailMenu.p = p;
	}
}
