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
<<<<<<< HEAD
	
=======
>>>>>>> b4ade11... add new directory

	public static void loadMenu(Menu menu, Player p) {
		ChunkMenu.setP(p);
		ChunkMenu.menu = menu;
		ChunkMenu.addForSellButton();
		ChunkMenu.addRemoveButton();
<<<<<<< HEAD
		ChunkMenu.closeMenu();		
		ChunkMenu.addSetOwnerButton();	
		ChunkMenu.addButton();				
	}	
=======
		ChunkMenu.closeMenu();
		ChunkMenu.addSetOwnerButton();
		ChunkMenu.addButton();
	}
>>>>>>> b4ade11... add new directory

	private static void addForSellButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck verkaufen", Material.GOLD_BLOCK);
		List<String> lines = new LinkedList<String>();
<<<<<<< HEAD
		lines.add("Aktuelles Grundstück verkaufen?");
		lines.add("Kann nur von Stadt Bewohnern gekauft werden.");
		lines.add("Klicken um das Grundstück zu verkaufen.");	
=======
		lines.add("Aktuelles Grundstï¿½ck verkaufen?");
		lines.add("Kann nur von Stadt Bewohnern gekauft werden.");
		lines.add("Klicken um das Grundstï¿½ck zu verkaufen.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 0);
	}
<<<<<<< HEAD
	private static void addSetOwnerButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck vergeben", Material.BOOK_AND_QUILL);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstück vergeben?");
		lines.add("Grundstück einem Bewohner zuweisen.");
		lines.add("Klicken und das Grundstück zuweisen.");	
=======

	private static void addSetOwnerButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck vergeben", Material.WRITABLE_BOOK);
		List<String> lines = new LinkedList<String>();
		lines.add("Aktuelles Grundstï¿½ck vergeben?");
		lines.add("Grundstï¿½ck einem Bewohner zuweisen.");
		lines.add("Klicken und das Grundstï¿½ck zuweisen.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 1);
	}

	private static void addRemoveButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck aufgeben", Material.DIRT);
		List<String> lines = new LinkedList<String>();
<<<<<<< HEAD
		lines.add("Aktuelles Grundstück aufgeben?");
		lines.add("Grundstück gehört dann nicht mehr der Stadt.");
		lines.add("Klicken um das Grundstück aufzugeben.");	
=======
		lines.add("Aktuelles Grundstï¿½ck aufgeben?");
		lines.add("Grundstï¿½ck gehï¿½rt dann nicht mehr der Stadt.");
		lines.add("Klicken um das Grundstï¿½ck aufzugeben.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 9);
	}

	private static void addButton() {
		// TODO Auto-generated method stub
		ChunkItem item = new ChunkItem("Grundstueck einnehmen", Material.GRASS);
		List<String> lines = new LinkedList<String>();
<<<<<<< HEAD
		lines.add("Aktuelles Grundstück einnehmen?");
		lines.add("Grundstück gehört dann der Stadt.");
		lines.add("Klicken um das Grundstück einzunehmen.");	
=======
		lines.add("Aktuelles Grundstï¿½ck einnehmen?");
		lines.add("Grundstï¿½ck gehï¿½rt dann der Stadt.");
		lines.add("Klicken um das Grundstï¿½ck einzunehmen.");
>>>>>>> b4ade11... add new directory
		item.setDescriptions(lines);

		ChunkMenu.menu.addMenuItem(item, 10);
	}
<<<<<<< HEAD
	
	private static void closeMenu()	{
		
		ChunkItem item = new ChunkItem("Hauptmenu",Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurück zum Hauptmenu.");
		item.setDescriptions(lines);


=======

	private static void closeMenu() {

		ChunkItem item = new ChunkItem("Hauptmenu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum Hauptmenu.");
		item.setDescriptions(lines);

>>>>>>> b4ade11... add new directory
		ChunkMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		ChunkMenu.p = p;
	}
}
