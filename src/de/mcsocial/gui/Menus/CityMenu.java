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

public class CityMenu {
	public static Menu menu;

	private static Player p;
	
	@SuppressWarnings("rawtypes")
	public static void loadMenu(Menu menu, Player p) {
		CityMenu.p = p;
		CityMenu.menu = menu;
		
		int row = 1;
		int col = 0;
		
		Iterator it = City.cityList.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			CityMenu.addCityButton((String)((City)pair.getValue()).getName(),(City)pair.getValue(),row*col++);
			if(col == 8){
				row ++;
				col = 0;
			}
		}				
				
		CityMenu.closeMenu();
		CityMenu.createCity();
		CityMenu.manageCity();
		
		
	}			
	
	private static void addCityButton(String key, City city,int pos) {
		// TODO Auto-generated method stub
		CityItem item = new CityItem(key);
		List<String> lines = new LinkedList<String>();
		lines.add("Stadthalter:  " + Bukkit.getOfflinePlayer(city.getOwner()).getName());
		lines.add("StadtKapital:  " + 0);
		lines.add("Bewohner:  " + Bukkit.getOfflinePlayer(city.getOwner()).getName());
		lines.add("Klicken um zur Stadt zu gelangen.");
		item.setLocation(city.getLoc());
		

		item.setDescriptions(lines);

		CityMenu.menu.addMenuItem(item, pos);
	}
	
	private static void createCity() {
		if(!CityMenu.p.isOp()){
			if(CityMenu.p.hasMetadata("cityowner")){
				return;
			}
			
			if(City.isVillager(CityMenu.p.getUniqueId())){
				return;
			}
		}
		CityItem item = new CityItem("Stadt gründen",Material.BOOK_AND_QUILL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);


		CityMenu.menu.addMenuItem(item, 19);
	}
	

	
	private static void manageCity()	{
		
		if(!CityMenu.p.hasMetadata("cityowner")){
			return;
		}
		
		CityItem item = new CityItem("Stadt verwalten",Material.BOOK_AND_QUILL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);


		CityMenu.menu.addMenuItem(item, 20);
	}
	
	private static void closeMenu()	{
		
		CityItem item = new CityItem("Hauptmenu",Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);


		CityMenu.menu.addMenuItem(item, 26);
	}
}
