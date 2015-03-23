package de.mcsocial.gui.Menus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.city.City;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.CityManagerItem;
import de.mcsocial.gui.items.JailItem;

public class CityManagerMenu {
	public static Menu menu;
	private static Player p;
	public static String nextAction="";
	
	public static void loadMenu(Menu menuAccount,Player p) {
		CityManagerMenu.setP(p);
		CityManagerMenu.menu = menuAccount;

		CityManagerMenu.addPlayer();
		CityManagerMenu.removePlayer();
		CityManagerMenu.closeMenu();
	}
	
	private static void removePlayer() {
		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Spieler entfernen",Material.BARRIER);
		List<String> lines = new LinkedList<String>();
		lines.add("Spieler entfernen");
		item.setDescriptions(lines);


		CityManagerMenu.menu.addMenuItem(item, 1);
	}

	private static void addPlayer() {
		CityManagerItem item = new CityManagerItem("Spieler hinzufuegen",Material.BANNER);
		List<String> lines = new LinkedList<String>();
		lines.add("Spieler hinzufuegen");
		item.setDescriptions(lines);


		CityManagerMenu.menu.addMenuItem(item, 0);
		
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

	public static void createPlayerMenu(Menu playerSelect,
			HashMap<UUID, City> residentList) {
		int i=0;
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while(allResidents.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allResidents.next();
			Player pl = (Player) (Bukkit.getPlayer((UUID) pair.getKey()));
			if(pl == null) {
				System.out.println("Spieler existiert nicht");
				continue;
			}
			if(!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId()))
			{
				System.out.println("Stadt existiert nicht");
				continue;
			}
			if(!pl.hasMetadata("city")){
				System.out.println("Spieler gehört keiner Stadt an");
				continue;
			}
			if(!CityManagerMenu.getP().getUniqueId().equals(UUID.fromString(pl.getMetadata("city").get(0).asString()))){
				System.out.println("Spieler gehört nicht dieser Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(),Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler entfernen?");
			lines.add("Zum entfernen klicken.");
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			item.setCity((City) pair.getValue());
			playerSelect.addMenuItem(item, i++);
		}	
		
	}

	public static void createPlayerMenu(Menu playerSelect,
			List<Player> allPlayer) {
		int i=0;
		for(Player pl: allPlayer){		
			if(pl == null) {
				System.out.println("Spieler existiert nicht");
				continue;
			}
			if(!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId()))
			{
				System.out.println("Stadt existiert nicht");
				continue;
			}
			if(pl.hasMetadata("city")){
				System.out.println("Spieler gehört einer Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(),Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler hinzufügen?");
			lines.add("Zum hinzufügen klicken.");
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			item.setCity((City) City.cityList.get(CityManagerMenu.getP().getUniqueId()));
			playerSelect.addMenuItem(item, i++);
		}	
		
	}
}
