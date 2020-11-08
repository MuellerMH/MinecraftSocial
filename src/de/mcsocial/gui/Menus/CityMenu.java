package de.mcsocial.gui.Menus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.city.City;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.CityItem;
import de.mcsocial.protection.ChunkHandler;

public class CityMenu {
	public static Menu menu;

	private static Player p;
	@SuppressWarnings("rawtypes")
	public static void loadMenu(Menu menu, Player p) {
		CityMenu.p = p;
		CityMenu.menu = menu;

		int i = 0;
		Iterator it = City.cityList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			CityMenu.addCityButton((String) ((City) pair.getValue()).getName(), (City) pair.getValue(), i++);
		}

		CityMenu.closeMenu();
		CityMenu.createCity();
		CityMenu.manageCity();

	}

	private static void addCityButton(String key, City city, int pos) {
		// TODO Auto-generated method stub
		CityItem item = new CityItem(key, Material.MAP);
		List<String> lines = new LinkedList<String>();
		lines.add("Stadthalter:  " + Bukkit.getOfflinePlayer(city.getOwner()).getName());
		lines.add("StadtKapital:  " + 0);
		lines.add("Bewohner:  " + Bukkit.getOfflinePlayer(city.getOwner()).getName());
		lines.add("Klicken um zur Stadt zu gelangen.");
		lines.add("Schnellreise kostet 500 SD.");
		item.setLocation(city.getLoc());

		item.setDescriptions(lines);

		CityMenu.menu.addMenuItem(item, pos);
	}

	private static void createCity() {

		if (!CityMenu.p.isOp()) {
			if (CityMenu.p.hasMetadata("cityowner")) {
				return;
			}

			if (City.isVillager(CityMenu.p.getUniqueId())) {
				return;
			}
			if (!ChunkHandler.isClaimAble(CityMenu.p)) {
				if (!ChunkHandler.getOwner(CityMenu.p.getLocation().getChunk()).equals(CityMenu.p.getUniqueId())) {
					return;
				}
			}
		}

		CityItem item = new CityItem("Stadt grï¿½nden", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

		if (!CityMenu.p.isOp()) {
			CityMenu.menu.addMenuItem(item, 33);
		} else {
			CityMenu.menu.addMenuItem(item, 32);
		}
	}

	private static void manageCity() {

		if (!CityMenu.p.hasMetadata("cityowner")) {
			return;
		}

		CityItem item = new CityItem("Stadt verwalten", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

		CityMenu.menu.addMenuItem(item, 34);
	}

	private static void closeMenu() {

		CityItem item = new CityItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

		CityMenu.menu.addMenuItem(item, 35);
	}
}
