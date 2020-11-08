package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.cheatprotection.Miner;
import de.mcsocial.city.Resident;
import de.mcsocial.economy.Job;
import de.mcsocial.economy.Jobs;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AccountMenu;
import de.mcsocial.gui.Menus.AdminMenu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.JobMenu;
import de.mcsocial.gui.Menus.JobSelectMenu;
import de.mcsocial.gui.Menus.PlayerMenu;
import de.mcsocial.permissions.PlayerPermissions;

public class PlayerItem extends MenuItem {

	public PlayerItem(String text, Material icon) {

		super(text, new ItemStack(icon, 1));
	}

	@Override
	public void onClick(Player p) {

		switch (this.getText()) {
			case "Spieler Menu":

				Menu menuPlayer = new Menu("Spieler", 3);
				Gui.switchMenu(p, Hauptmenu.menu, menuPlayer);
				PlayerMenu.loadMenu(menuPlayer, p);
				break;
			case "Admin Menu":

				Menu menuAdmin = new Menu("Admin Menu", 3);
				Gui.switchMenu(p, Hauptmenu.menu, menuAdmin);
				AdminMenu.loadMenu(menuAdmin, p);
				break;
			case "Konto":

				Menu menuAccount = new Menu("Konto", 3);
				Gui.switchMenu(p, PlayerMenu.menu, menuAccount);
				AccountMenu.loadMenu(menuAccount, p);
				break;
			case "Berufe Uebersicht":

				Menu jobMenu = new Menu("Berufe", 3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenu);
				JobMenu.loadMenu(jobMenu, p);
				break;
			case "Hauptmenu":

				Gui.switchMenu(p, PlayerMenu.menu, Hauptmenu.menu);
				break;
			case "Beruf annehmen":
				if (p.hasMetadata("lastJobChange")) {
					if ((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1 * 20 * 60 * 24 * 7)) {
						p.sendMessage("Du kannst dein Beruf nur alle sieben Tage wechseln");
						return;
					}
				}

				Menu jobMenuSelect = new Menu("Berufe", 3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenuSelect);
				JobSelectMenu.loadMenu(jobMenuSelect, p);
				break;
			case "Beruf aufgeben":
				if (p.hasMetadata("lastJobChange")) {
					if ((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1 * 20 * 60 * 24 * 7)) {
						p.sendMessage("Du kannst dein Beruf nur alle sieben Tage wechseln");
						return;
					}
				}

				Resident.removeJob(p);
				Gui.switchMenu(p, PlayerMenu.menu, Hauptmenu.menu);
				break;
			case "Mein Beruf":

				p.sendMessage("--------------------------------");
				p.sendMessage("Berufinformationen");
				p.sendMessage("--------------------------------");

				if (!p.hasMetadata("job")) {
					p.sendMessage("Du gehst keiner Ehrbaren Arbeit nach.");
					p.sendMessage("--------------------------------");
					break;
				}
				Job job = Jobs.JobList.get(p.getMetadata("job").get(0).asString());
				if (job == null) {
					p.sendMessage("Du gehst keiner Ehrbaren Arbeit nach.");
					p.sendMessage("--------------------------------");
					break;
				}
				p.sendMessage(job.getName());
				p.sendMessage(job.getDescription().replace("##", " "));
				p.sendMessage("--------------------------------");

				break;
			case "MinerInfo":
				if (!PlayerPermissions.hasAccess(p, "supporter"))
					break;

				p.sendMessage("--------------------------------");
				p.sendMessage("Dein aktuelles Mining verhalten:");
				p.sendMessage("--------------------------------");

				if (!Miner.counterAll.containsKey(p.getUniqueId())) {
					p.sendMessage("Keine abgebauten Blöcke vorhanden");
					p.sendMessage("--------------------------------");
					return;
				}

				if (Miner.counterDias.containsKey(p.getUniqueId()))
					p.sendMessage("Diamanten: " + Miner.counterDias.get(p.getUniqueId()));
				if (Miner.counterGold.containsKey(p.getUniqueId()))
					p.sendMessage("Gold: " + Miner.counterGold.get(p.getUniqueId()));
				if (Miner.counterIron.containsKey(p.getUniqueId()))
					p.sendMessage("Eisen: " + Miner.counterIron.get(p.getUniqueId()));
				if (Miner.counterRedstone.containsKey(p.getUniqueId()))
					p.sendMessage("Redstone: " + Miner.counterRedstone.get(p.getUniqueId()));
				if (Miner.counterCoal.containsKey(p.getUniqueId()))
					p.sendMessage("Kohle: " + Miner.counterCoal.get(p.getUniqueId()));
				if (Miner.counterLapis.containsKey(p.getUniqueId()))
					p.sendMessage("Lapis: " + Miner.counterLapis.get(p.getUniqueId()));
				p.sendMessage("Gesamt abgebaute Blöcke: " + Miner.counterAll.get(p.getUniqueId()));
				p.sendMessage("--------------------------------");
				break;

			default:
				break;
		}

	}

}
