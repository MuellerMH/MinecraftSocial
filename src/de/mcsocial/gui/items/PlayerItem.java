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
<<<<<<< HEAD
	
	public PlayerItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
=======

	public PlayerItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon, 1));
>>>>>>> b4ade11... add new directory
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		switch(this.getText()){
			case "Spieler Menu":
				// TODO Auto-generated method stub
				Menu menuPlayer = new Menu("Spieler",3);
				Gui.switchMenu(p, Hauptmenu.menu, menuPlayer);
				PlayerMenu.loadMenu(menuPlayer,p);
			break;
			case "Admin Menu":
				// TODO Auto-generated method stub
				Menu menuAdmin = new Menu("Admin Menu",3);
				Gui.switchMenu(p, Hauptmenu.menu, menuAdmin);
				AdminMenu.loadMenu(menuAdmin,p);
			break;
			case "Konto":
				// TODO Auto-generated method stub
				Menu menuAccount = new Menu("Konto",3);
				Gui.switchMenu(p, PlayerMenu.menu, menuAccount);
				AccountMenu.loadMenu(menuAccount,p);
			break;
			case "Berufe Uebersicht":
				// TODO Auto-generated method stub
				Menu jobMenu = new Menu("Berufe",3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenu);
				JobMenu.loadMenu(jobMenu,p);
=======
		switch (this.getText()) {
			case "Spieler Menu":
				// TODO Auto-generated method stub
				Menu menuPlayer = new Menu("Spieler", 3);
				Gui.switchMenu(p, Hauptmenu.menu, menuPlayer);
				PlayerMenu.loadMenu(menuPlayer, p);
				break;
			case "Admin Menu":
				// TODO Auto-generated method stub
				Menu menuAdmin = new Menu("Admin Menu", 3);
				Gui.switchMenu(p, Hauptmenu.menu, menuAdmin);
				AdminMenu.loadMenu(menuAdmin, p);
				break;
			case "Konto":
				// TODO Auto-generated method stub
				Menu menuAccount = new Menu("Konto", 3);
				Gui.switchMenu(p, PlayerMenu.menu, menuAccount);
				AccountMenu.loadMenu(menuAccount, p);
				break;
			case "Berufe Uebersicht":
				// TODO Auto-generated method stub
				Menu jobMenu = new Menu("Berufe", 3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenu);
				JobMenu.loadMenu(jobMenu, p);
>>>>>>> b4ade11... add new directory
				break;
			case "Hauptmenu":
				// TODO Auto-generated method stub
				Gui.switchMenu(p, PlayerMenu.menu, Hauptmenu.menu);
				break;
			case "Beruf annehmen":
<<<<<<< HEAD
				if(p.hasMetadata("lastJobChange"))
				{
					if((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1*20*60*24*7)){
=======
				if (p.hasMetadata("lastJobChange")) {
					if ((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1 * 20 * 60 * 24 * 7)) {
>>>>>>> b4ade11... add new directory
						p.sendMessage("Du kannst dein Beruf nur alle sieben Tage wechseln");
						return;
					}
				}
				// TODO Auto-generated method stub
<<<<<<< HEAD
				Menu jobMenuSelect = new Menu("Berufe",3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenuSelect);
				JobSelectMenu.loadMenu(jobMenuSelect,p);
				break;
			case "Beruf aufgeben":
				if(p.hasMetadata("lastJobChange"))
				{
					if((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1*20*60*24*7)){
=======
				Menu jobMenuSelect = new Menu("Berufe", 3);
				Gui.switchMenu(p, PlayerMenu.menu, jobMenuSelect);
				JobSelectMenu.loadMenu(jobMenuSelect, p);
				break;
			case "Beruf aufgeben":
				if (p.hasMetadata("lastJobChange")) {
					if ((System.currentTimeMillis() - p.getMetadata("lastJobChange").get(0).asLong()) < (1 * 20 * 60 * 24 * 7)) {
>>>>>>> b4ade11... add new directory
						p.sendMessage("Du kannst dein Beruf nur alle sieben Tage wechseln");
						return;
					}
				}
				// TODO Auto-generated method stub
				Resident.removeJob(p);
<<<<<<< HEAD
				  Gui.switchMenu(p, PlayerMenu.menu, Hauptmenu.menu);
=======
				Gui.switchMenu(p, PlayerMenu.menu, Hauptmenu.menu);
>>>>>>> b4ade11... add new directory
				break;
			case "Mein Beruf":
				// TODO Auto-generated method stub
				p.sendMessage("--------------------------------");
				p.sendMessage("Berufinformationen");
				p.sendMessage("--------------------------------");
<<<<<<< HEAD
				
				if(!p.hasMetadata("job")){
=======

				if (!p.hasMetadata("job")) {
>>>>>>> b4ade11... add new directory
					p.sendMessage("Du gehst keiner Ehrbaren Arbeit nach.");
					p.sendMessage("--------------------------------");
					break;
				}
				Job job = Jobs.JobList.get(p.getMetadata("job").get(0).asString());
<<<<<<< HEAD
				if(job == null){
=======
				if (job == null) {
>>>>>>> b4ade11... add new directory
					p.sendMessage("Du gehst keiner Ehrbaren Arbeit nach.");
					p.sendMessage("--------------------------------");
					break;
				}
				p.sendMessage(job.getName());
				p.sendMessage(job.getDescription().replace("##", " "));
				p.sendMessage("--------------------------------");
<<<<<<< HEAD
				
				break;
			case "MinerInfo":
				if(!PlayerPermissions.hasAccess(p, "supporter"))
=======

				break;
			case "MinerInfo":
				if (!PlayerPermissions.hasAccess(p, "supporter"))
>>>>>>> b4ade11... add new directory
					break;
				// TODO Auto-generated method stub
				p.sendMessage("--------------------------------");
				p.sendMessage("Dein aktuelles Mining verhalten:");
				p.sendMessage("--------------------------------");
<<<<<<< HEAD
					
				if(!Miner.counterAll.containsKey(p.getUniqueId())){
					p.sendMessage("Keine abgebauten Bl�cke vorhanden");
					p.sendMessage("--------------------------------");
					return;
				}
				
				if(Miner.counterDias.containsKey(p.getUniqueId()))
					p.sendMessage("Diamanten: " + Miner.counterDias.get(p.getUniqueId()));
				if(Miner.counterGold.containsKey(p.getUniqueId()))
					p.sendMessage("Gold: " + Miner.counterGold.get(p.getUniqueId()));
				if(Miner.counterIron.containsKey(p.getUniqueId()))
					p.sendMessage("Eisen: " + Miner.counterIron.get(p.getUniqueId()));
				if(Miner.counterRedstone.containsKey(p.getUniqueId()))
					p.sendMessage("Redstone: " + Miner.counterRedstone.get(p.getUniqueId()));
				if(Miner.counterCoal.containsKey(p.getUniqueId()))
					p.sendMessage("Kohle: " + Miner.counterCoal.get(p.getUniqueId()));
				if(Miner.counterLapis.containsKey(p.getUniqueId()))
					p.sendMessage("Lapis: " + Miner.counterLapis.get(p.getUniqueId()));
				p.sendMessage("Gesamt abgebaute Bl�cke: " + Miner.counterAll.get(p.getUniqueId()));
				p.sendMessage("--------------------------------");
				break;
				
			default:
			   break;
		}
		
=======

				if (!Miner.counterAll.containsKey(p.getUniqueId())) {
					p.sendMessage("Keine abgebauten Bl�cke vorhanden");
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
				p.sendMessage("Gesamt abgebaute Bl�cke: " + Miner.counterAll.get(p.getUniqueId()));
				p.sendMessage("--------------------------------");
				break;

			default:
				break;
		}

>>>>>>> b4ade11... add new directory
	}

}
