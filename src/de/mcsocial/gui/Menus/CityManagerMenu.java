package de.mcsocial.gui.Menus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.city.City;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.CityManagerItem;
import de.mcsocial.protection.ChunkHandler;

public class CityManagerMenu {
	public static Menu menu;
	private static Player p;
<<<<<<< HEAD
	public static String nextAction="";
	
	public static void loadMenu(Menu menuAccount,Player p) {
=======
	public static String nextAction = "";

	public static void loadMenu(Menu menuAccount, Player p) {
>>>>>>> b4ade11... add new directory
		CityManagerMenu.setP(p);
		CityManagerMenu.menu = menuAccount;

		CityManagerMenu.addPlayer();
		CityManagerMenu.removePlayer();
		CityManagerMenu.closeMenu();
		CityManagerMenu.addCityGS();
		CityManagerMenu.removeCityGS();
		deleteCity();
	}
<<<<<<< HEAD
	
	private static void removeCityGS() {
		if(ChunkHandler.isClaimAble(CityManagerMenu.p))
			return;
		if(ChunkHandler.getOwner(CityManagerMenu.p) == null)
			return;
		if(!ChunkHandler.getOwner(CityManagerMenu.p).equals(CityManagerMenu.p.getUniqueId()))
			return;
		
		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Grundstueck entfernen",Material.DIRT);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundst�ck aus der Stadt entfernen.");
=======

	private static void removeCityGS() {
		if (ChunkHandler.isClaimAble(CityManagerMenu.p))
			return;
		if (ChunkHandler.getOwner(CityManagerMenu.p) == null)
			return;
		if (!ChunkHandler.getOwner(CityManagerMenu.p).equals(CityManagerMenu.p.getUniqueId()))
			return;

		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Grundstueck entfernen", Material.DIRT);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundst�ck aus der Stadt entfernen.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		CityManagerMenu.menu.addMenuItem(item, 10);
	}
<<<<<<< HEAD
	
	private static void addCityGS() {
		if(ChunkHandler.isClaimAble(CityManagerMenu.p))
			return;
		if(ChunkHandler.getOwner(CityManagerMenu.p) == null)
			return;
		if(!ChunkHandler.getOwner(CityManagerMenu.p).equals(CityManagerMenu.p.getUniqueId()))
			return;
		
		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Grundstueck hinzufuegen",Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundst�ck der Stadt hinzuf�gen.");
=======

	private static void addCityGS() {
		if (ChunkHandler.isClaimAble(CityManagerMenu.p))
			return;
		if (ChunkHandler.getOwner(CityManagerMenu.p) == null)
			return;
		if (!ChunkHandler.getOwner(CityManagerMenu.p).equals(CityManagerMenu.p.getUniqueId()))
			return;

		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Grundstueck hinzufuegen", Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundst�ck der Stadt hinzuf�gen.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		CityManagerMenu.menu.addMenuItem(item, 9);
	}
<<<<<<< HEAD
	


	private static void deleteCity() {
		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Stadt aufloesen",Material.BARRIER);
		List<String> lines = new LinkedList<String>();
		lines.add("Diese Stadt wirklich aufl�esen und l�schen?");
		item.setDescriptions(lines);


=======

	private static void deleteCity() {
		// TODO Auto-generated method stub
		CityManagerItem item = new CityManagerItem("Stadt aufloesen", Material.BARRIER);
		List<String> lines = new LinkedList<String>();
		lines.add("Diese Stadt wirklich aufl�esen und l�schen?");
		item.setDescriptions(lines);

>>>>>>> b4ade11... add new directory
		CityManagerMenu.menu.addMenuItem(item, 22);
	}

	private static void removePlayer() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		CityManagerItem item = new CityManagerItem("Spieler entfernen",Material.BARRIER);
=======
		CityManagerItem item = new CityManagerItem("Spieler entfernen", Material.BARRIER);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Spieler entfernen");
		item.setDescriptions(lines);

<<<<<<< HEAD

=======
>>>>>>> b4ade11... add new directory
		CityManagerMenu.menu.addMenuItem(item, 1);
	}

	private static void addPlayer() {
<<<<<<< HEAD
		CityManagerItem item = new CityManagerItem("Spieler hinzufuegen",Material.BANNER);
=======
		@SuppressWarnings("deprecation")
		CityManagerItem item = new CityManagerItem("Spieler hinzufuegen", Material.LEGACY_BANNER);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Spieler hinzufuegen");
		item.setDescriptions(lines);

<<<<<<< HEAD

		CityManagerMenu.menu.addMenuItem(item, 0);
		
	}

	private static void closeMenu()	{
			
		CityManagerItem item = new CityManagerItem("Hauptmenu",Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zur�ck zum Hauptmenu.");
		item.setDescriptions(lines);


=======
		CityManagerMenu.menu.addMenuItem(item, 0);

	}

	private static void closeMenu() {

		CityManagerItem item = new CityManagerItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zur�ck zum Hauptmenu.");
		item.setDescriptions(lines);

>>>>>>> b4ade11... add new directory
		CityManagerMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		CityManagerMenu.p = p;
	}

<<<<<<< HEAD
	public static void createPlayerMenu(Menu playerSelect,
			HashMap<UUID, City> residentList) {
		int i=0;
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while(allResidents.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allResidents.next();
			Player pl = (Player) (Bukkit.getPlayer((UUID) pair.getKey()));
			if(pl == null) {
				//System.out.println("Spieler existiert nicht");
				continue;
			}
			if(!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId()))
			{
				//System.out.println("Stadt existiert nicht");
				continue;
			}
			if(!pl.hasMetadata("city")){
				//System.out.println("Spieler geh�rt keiner Stadt an");
				continue;
			}
			if(!CityManagerMenu.getP().getUniqueId().equals(UUID.fromString(pl.getMetadata("city").get(0).asString()))){
				//System.out.println("Spieler geh�rt nicht dieser Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(),Material.BARRIER);
=======
	public static void createPlayerMenu(Menu playerSelect, HashMap<UUID, City> residentList) {
		int i = 0;
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while (allResidents.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) allResidents.next();
			Player pl = (Player) (Bukkit.getPlayer((UUID) pair.getKey()));
			if (pl == null) {
				// System.out.println("Spieler existiert nicht");
				continue;
			}
			if (!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId())) {
				// System.out.println("Stadt existiert nicht");
				continue;
			}
			if (!pl.hasMetadata("city")) {
				// System.out.println("Spieler geh�rt keiner Stadt an");
				continue;
			}
			if (!CityManagerMenu.getP().getUniqueId().equals(UUID.fromString(pl.getMetadata("city").get(0).asString()))) {
				// System.out.println("Spieler geh�rt nicht dieser Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(), Material.BARRIER);
>>>>>>> b4ade11... add new directory
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler entfernen?");
			lines.add("Zum entfernen klicken.");
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			item.setCity((City) pair.getValue());
			playerSelect.addMenuItem(item, i++);
<<<<<<< HEAD
		}	
		
	}

	public static void createPlayerMenu(Menu playerSelect,
			List<Player> allPlayer) {
		int i=0;
		for(Player pl: allPlayer){		
			if(pl == null) {
				//System.out.println("Spieler existiert nicht");
				continue;
			}
			if(!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId()))
			{
				//System.out.println("Stadt existiert nicht");
				continue;
			}
			if(pl.hasMetadata("city")){
				//System.out.println("Spieler geh�rt einer Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(),Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler hinzuf�gen?");
			lines.add("Zum hinzuf�gen klicken.");
=======
		}

	}

	public static void createPlayerMenu(Menu playerSelect, List<Player> allPlayer) {
		int i = 0;
		for (Player pl : allPlayer) {
			if (pl == null) {
				// System.out.println("Spieler existiert nicht");
				continue;
			}
			if (!City.cityList.containsKey(CityManagerMenu.getP().getUniqueId())) {
				// System.out.println("Stadt existiert nicht");
				continue;
			}
			if (pl.hasMetadata("city")) {
				// System.out.println("Spieler geh�rt einer Stadt an");
				continue;
			}
			CityManagerItem item = new CityManagerItem(pl.getName(), Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Diesen Spieler hinzuf�gen?");
			lines.add("Zum hinzuf�gen klicken.");
>>>>>>> b4ade11... add new directory
			item.setDescriptions(lines);
			item.setUUID(pl.getUniqueId());
			item.setCity((City) City.cityList.get(CityManagerMenu.getP().getUniqueId()));
			playerSelect.addMenuItem(item, i++);
<<<<<<< HEAD
		}	
		
=======
		}

>>>>>>> b4ade11... add new directory
	}
}
