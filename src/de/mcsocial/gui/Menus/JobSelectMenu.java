package de.mcsocial.gui.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.mcsocial.economy.Job;
import de.mcsocial.economy.Jobs;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.JobItem;
import de.mcsocial.gui.items.JobSelectItem;

public class JobSelectMenu {
	public static Menu menu;
	private static Player p;

	public static void loadMenu(Menu menuAccount, Player p) {
		JobSelectMenu.setP(p);
		JobSelectMenu.menu = menuAccount;

		displayJobs();
		closeMenu();
	}

	@SuppressWarnings("rawtypes")
	private static void displayJobs() {
		Iterator it = Jobs.JobList.entrySet().iterator();
		Integer i = 0;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Job job = (Job) pair.getValue();
			JobSelectItem item = new JobSelectItem(job.getName(), Material.BEACON);

			List<String> desLines = new ArrayList<String>(Arrays.asList(job.getDescription().split("##")));
			/*
			 * List<String> lines = new LinkedList<String>(); for(String dLine : desLines )
			 * { lines.add(dLine); }
			 */
			item.setDescriptions(desLines);
			JobSelectMenu.menu.addMenuItem(item, i++);
		}
	}

	private static void closeMenu() {

		JobItem item = new JobItem("Spieler Menu", Material.ENDER_PEARL);
		List<String> lines = new LinkedList<String>();
		lines.add("Zurï¿½ck zum SpielerMenu.");
		item.setDescriptions(lines);

		JobSelectMenu.menu.addMenuItem(item, 26);
	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		JobSelectMenu.p = p;
	}

}
