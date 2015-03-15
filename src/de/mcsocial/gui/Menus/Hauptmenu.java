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
import de.mcsocial.protection.ChunkHandler;

public class Hauptmenu {
	public static Menu menu;

	private static Player p;
	
	public static void loadMenu(Menu menu, Player p) {
		if(!p.hasMetadata("folk")){
			menu.setExitOnClickOutside(false);			
			FirstTimeMenu.loadMenu(menu,p);
			p.sendMessage("Bevor du das Menu nutzen kannst wähle ein Volk!");
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
	}	
	
	private static void adminMenu() {
		// TODO Auto-generated method stub
		PlayerItem item = new PlayerItem("Admin Menu",Material.ENCHANTED_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Admin Funktionen.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 11);
	}

	private static void claimChunk() {		
		if(ChunkHandler.getOwner(Hauptmenu.p) != null){
			if(!ChunkHandler.getChunk(Hauptmenu.p.getLocation().getChunk()).isCity()){
				if(ChunkHandler.getOwner(Hauptmenu.p).equals(Hauptmenu.p.getUniqueId())){		
					CityItem itemBarrier = new CityItem("Grundstueck verkaufen",Material.DIRT);
					List<String> lines = new LinkedList<String>();
					lines.add("Dieses Grundstück gehört dir.");
					lines.add("Zum verkaufen klicken.");
					lines.add("Verkaufspreis 2000.00");
					itemBarrier.setDescriptions(lines);
					Hauptmenu.menu.addMenuItem(itemBarrier, 19);
					return;
				}
			}else{
				if(!Hauptmenu.p.hasMetadata("cityowner")){
					return;
				}
				
				CityManagerItem item = new CityManagerItem("Stadt verwalten",Material.BOOK_AND_QUILL);
				List<String> lines = new LinkedList<String>();
				lines.add("Öffnet das Stadtverwaltungs Menu.");
				item.setDescriptions(lines);
				Hauptmenu.menu.addMenuItem(item, 20);
			}
		}
				
		if(!ChunkHandler.isClaimAble(Hauptmenu.p)){		
			CityItem itemBarrier = new CityItem("Grundstueck belegt",Material.BARRIER);
			List<String> lines = new LinkedList<String>();
			lines.add("Dieses Grundstück steht nicht zum verkauf.");
			itemBarrier.setDescriptions(lines);
			Hauptmenu.menu.addMenuItem(itemBarrier, 19);
			return;
		}
		
		CityItem item = new CityItem("Grundstueck kaufen",Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Dieses Grundstück kannst du kaufen.");
		lines.add("Klicken um das Grundstück jetzt zu kaufen.");
		lines.add("Preis eines Wilden Grundstückes: 4000.00 Social Dollar");
		item.setDescriptions(lines);
		Hauptmenu.menu.addMenuItem(item, 19);
	}

	private static void addHome()	{
		
		HomeItem home = new HomeItem("Home",Material.COMPASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Teleportiert dich zu deinem Bett.");
		home.setDescriptions(lines);
		Hauptmenu.menu.addMenuItem(home, 0);
	}
	
	private static void displayChunk()	{
		
		CityItem item = new CityItem("GS Information",Material.GRASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt Informationen zu dem");
		lines.add("aktuellen Grundstück an ");
		lines.add("auf dem du dich befindest.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 18);
	}
	private static void addSpawn()	{
		
		WorldSpawn spawn = new WorldSpawn("World Spawn",Material.COMPASS);
		List<String> lines = new LinkedList<String>();
		lines.add("Teleportiert dich zum WeltSpawn.");
		spawn.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(spawn, 1);
	}
	
	private static void addCity()	{
		
		CityItem item = new CityItem("Städte Menu",Material.MAP);
		List<String> lines = new LinkedList<String>();
		lines.add("Zeigt eine Liste aller Städte.");
		item.setDescriptions(lines);

		Hauptmenu.menu.addMenuItem(item, 9);
	}
	
	private static void addPlayer()	{
		
		PlayerItem item = new PlayerItem("Spieler Menu",Material.ENCHANTED_BOOK);
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
