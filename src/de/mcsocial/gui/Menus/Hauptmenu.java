package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.CityItem;
import de.mcsocial.gui.items.CityManagerItem;
import de.mcsocial.gui.items.HomeItem;
import de.mcsocial.gui.items.PlayerItem;
import de.mcsocial.gui.items.WorldSpawn;
import de.mcsocial.permissions.PlayerPermissions;
import de.mcsocial.protection.ChunkHandler;

public class Hauptmenu {
	public static Menu menu;

	private static Player p;
<<<<<<< HEAD
	
	public static void loadMenu(Menu menu, Player p) {
		if(!p.hasMetadata("folk")){
			menu.setExitOnClickOutside(false);			
			FirstTimeMenu.loadMenu(menu,p);
			p.sendMessage("Bevor du das Menu nutzen kannst wähle ein Volk!");
=======

	public static void loadMenu(Menu menu, Player p) {
		if (!p.hasMetadata("folk")) {
			menu.setExitOnClickOutside(false);
			FirstTimeMenu.loadMenu(menu, p);
			p.sendMessage("Bevor du das Menu nutzen kannst wï¿½hle ein Volk!");
>>>>>>> b4ade11... add new directory
			return;
		}
		Hauptmenu.setP(p);
		Hauptmenu.menu = menu;
		Hauptmenu.addHome();
		Hauptmenu.addSpawn();
		Hauptmenu.addCity();
		Hauptmenu.addPlayer();
		Hauptmenu.displayChunk();
		Hauptmenu.claimChunk();
		Hauptmenu.adminMenu();
		Hauptmenu.loadLeaveCity();
<<<<<<< HEAD
	}	
	
	private static void loadLeaveCity(){		
		if(!Hauptmenu.p.hasMetadata("city")){
			return;
		}
		CityItem itemLeave = new CityItem("Stadt verlassen",Material.BARRIER);
		List<String> linesLeave = new LinkedList<String>();
		linesLeave.add("Ja, ich möchte meine Stadt verlassen.");
		itemLeave.setDescriptions(linesLeave);
		Hauptmenu.menu.addMenuItem(itemLeave, 21);
	}
	
	private static void adminMenu() {
		if(!PlayerPermissions.hasAccess(p, "supporter"))
		return;
		// TODO Auto-generated method stub
		PlayerItem item = new PlayerItem("Admin Menu",Material.ENCHANTED_BOOK);
=======
	}

	private static void loadLeaveCity() {
		if (!Hauptmenu.p.hasMetadata("city")) {
			return;
		}
		CityItem itemLeave = new CityItem("Stadt verlassen", Material.BARRIER);
		List<String> linesLeave = new LinkedList<String>();
		linesLeave.add("Ja, ich mï¿½chte meine Stadt verlassen.");
		itemLeave.setDescriptions(linesLeave);
		Hauptmenu.menu.addMenuItem(itemLeave, 21);
	}

	private static void adminMenu() {
		if (!PlayerPermissions.hasAccess(p, "supporter"))
			return;
		// TODO Auto-generated method stub
		PlayerItem item = new PlayerItem("Admin Menu", Material.ENCHANTED_BOOK);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Admin Funktionen.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 11);
	}

<<<<<<< HEAD
	private static void claimChunk() {		
		if(ChunkHandler.getOwner(Hauptmenu.p) != null){
			if(!ChunkHandler.getChunk(Hauptmenu.p.getLocation().getChunk()).isCity()){
				if(ChunkHandler.getOwner(Hauptmenu.p).equals(Hauptmenu.p.getUniqueId())){		
					CityItem itemBarrier = new CityItem("Grundstueck verkaufen",Material.DIRT);
					List<String> lines = new LinkedList<String>();
					lines.add("Dieses Grundstück gehört dir.");
=======
	private static void claimChunk() {
		if (ChunkHandler.getOwner(Hauptmenu.p) != null) {
			if (!ChunkHandler.getChunk(Hauptmenu.p.getLocation().getChunk()).isCity()) {
				if (ChunkHandler.getOwner(Hauptmenu.p).equals(Hauptmenu.p.getUniqueId())) {
					CityItem itemBarrier = new CityItem("Grundstueck verkaufen", Material.DIRT);
					List<String> lines = new LinkedList<String>();
					lines.add("Dieses Grundstï¿½ck gehï¿½rt dir.");
>>>>>>> b4ade11... add new directory
					lines.add("Zum verkaufen klicken.");
					lines.add("Verkaufspreis 2000.00");
					itemBarrier.setDescriptions(lines);
					Hauptmenu.menu.addMenuItem(itemBarrier, 19);
					return;
				}
<<<<<<< HEAD
			}else{
				if(!Hauptmenu.p.hasMetadata("cityowner")){
					return;
				}
				
				CityManagerItem item = new CityManagerItem("Stadt verwalten",Material.BOOK_AND_QUILL);
				List<String> lines = new LinkedList<String>();
				lines.add("Öffnet das Stadtverwaltungs Menu.");
=======
			} else {
				if (!Hauptmenu.p.hasMetadata("cityowner")) {
					return;
				}

				CityManagerItem item = new CityManagerItem("Stadt verwalten", Material.WRITABLE_BOOK);
				List<String> lines = new LinkedList<String>();
				lines.add("ï¿½ffnet das Stadtverwaltungs Menu.");
>>>>>>> b4ade11... add new directory
				item.setDescriptions(lines);
				Hauptmenu.menu.addMenuItem(item, 20);
			}
		}
<<<<<<< HEAD
				
		if(!ChunkHandler.isClaimAble(Hauptmenu.p)){		
			CityItem itemBarrier = new CityItem("Grundstueck belegt",Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Dieses Grundstück steht nicht zum verkauf.");
=======

		if (!ChunkHandler.isClaimAble(Hauptmenu.p)) {
			CityItem itemBarrier = new CityItem("Grundstueck belegt", Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Dieses Grundstï¿½ck steht nicht zum verkauf.");
>>>>>>> b4ade11... add new directory
			itemBarrier.setDescriptions(lines);
			Hauptmenu.menu.addMenuItem(itemBarrier, 19);
			return;
		}
<<<<<<< HEAD
		
		CityItem item = new CityItem("Grundstueck kaufen",Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundstück kannst du kaufen.");
		lines.add("Klicken um das Grundstück jetzt zu kaufen.");
		lines.add("Preis eines Wilden Grundstückes: 4000.00 Social Dollar");
=======

		CityItem item = new CityItem("Grundstueck kaufen", Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundstï¿½ck kannst du kaufen.");
		lines.add("Klicken um das Grundstï¿½ck jetzt zu kaufen.");
		lines.add("Preis eines Wilden Grundstï¿½ckes: 4000.00 Social Dollar");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);
		Hauptmenu.menu.addMenuItem(item, 19);
	}

<<<<<<< HEAD
	private static void addHome()	{
		
		HomeItem home = new HomeItem("Home",Material.COMPASS);
=======
	private static void addHome() {

		HomeItem home = new HomeItem("Home", Material.COMPASS);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Teleportiert dich zu deinem Bett.");
		home.setDescriptions(lines);
		Hauptmenu.menu.addMenuItem(home, 0);
	}
<<<<<<< HEAD
	
	private static void displayChunk()	{
		
		CityItem item = new CityItem("GS Information",Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu dem");
		lines.add("aktuellen Grundstück an ");
=======

	private static void displayChunk() {

		CityItem item = new CityItem("GS Information", Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu dem");
		lines.add("aktuellen Grundstï¿½ck an ");
>>>>>>> b4ade11... add new directory
		lines.add("auf dem du dich befindest.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 18);
	}
<<<<<<< HEAD
	private static void addSpawn()	{
		
		WorldSpawn spawn = new WorldSpawn("World Spawn",Material.COMPASS);
=======

	private static void addSpawn() {

		WorldSpawn spawn = new WorldSpawn("World Spawn", Material.COMPASS);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Teleportiert dich zum WeltSpawn.");
		spawn.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(spawn, 1);
	}
<<<<<<< HEAD
	
	private static void addCity()	{
		
		CityItem item = new CityItem("Städte Menu",Material.MAP);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt eine Liste aller Städte.");
=======

	private static void addCity() {

		CityItem item = new CityItem("Stï¿½dte Menu", Material.MAP);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt eine Liste aller Stï¿½dte.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 9);
	}
<<<<<<< HEAD
	
	private static void addPlayer()	{
		
		PlayerItem item = new PlayerItem("Spieler Menu",Material.ENCHANTED_BOOK);
=======

	private static void addPlayer() {

		PlayerItem item = new PlayerItem("Spieler Menu", Material.ENCHANTED_BOOK);
>>>>>>> b4ade11... add new directory
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt deine Informationen.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 10);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		Hauptmenu.p = p;
	}
}
