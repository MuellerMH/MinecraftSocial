package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.FirstTimeItem;

public class FirstTimeMenu {
	public static Menu menu;

	private static Player p;
	
	public static void loadMenu(Menu menu, Player p) {
		FirstTimeMenu.setP(p);
		FirstTimeMenu.menu = menu;
		FirstTimeMenu.addZwerg();
		FirstTimeMenu.addElf();
		FirstTimeMenu.addMensch();
		FirstTimeMenu.addOrc();
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		FirstTimeMenu.p = p;
	}	
	
	private static void addZwerg()	{
		
		FirstTimeItem item = new FirstTimeItem("Zwerg",Material.DIAMOND_PICKAXE);
		List<String> lines = new LinkedList<String>();
		lines.add("Wähle das Volk der Zwerge");
		item.setDescriptions(lines);
		
		//-8000,8000

		FirstTimeMenu.menu.addMenuItem(item, 1);
	}
	private static void addElf()	{
		//8000,-8000
		FirstTimeItem item = new FirstTimeItem("Elf",Material.BOW);
		List<String> lines = new LinkedList<String>();
		lines.add("Wähle das Volk der Elfen");
		item.setDescriptions(lines);

		FirstTimeMenu.menu.addMenuItem(item, 2);
	}
	private static void addMensch()	{
		//8000,8000
		FirstTimeItem item = new FirstTimeItem("Mensch",Material.DIAMOND_SWORD);
		List<String> lines = new LinkedList<String>();
		lines.add("Wähle das Volk der Menschen");
		item.setDescriptions(lines);
	
		FirstTimeMenu.menu.addMenuItem(item, 0);
	}
	private static void addOrc()	{
		//-8000,-8000
		FirstTimeItem item = new FirstTimeItem("Orc",Material.DIRT);
		List<String> lines = new LinkedList<String>();
		lines.add("Wähle das Volk der Orcs");
		item.setDescriptions(lines);
	
		FirstTimeMenu.menu.addMenuItem(item, 3);
	}
}
