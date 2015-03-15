package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.city.Resident;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.JobSelectMenu;
import de.mcsocial.gui.Menus.PlayerMenu;

public class JobSelectItem  extends MenuItem {

	public JobSelectItem(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public JobSelectItem(String text, Material icon) {
		super(text, new MaterialData(icon));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub
		switch(this.getText()){
			case "Spieler Menu":
				// TODO Auto-generated method stub
				Gui.switchMenu(player, JobSelectMenu.menu, PlayerMenu.menu);
				break;
			default:
			   if(player.hasMetadata("job")){
				   if(!player.getMetadata("job").get(0).asString().isEmpty())
				   {
					   player.sendMessage("Du hast bereits einen Beruf.");
					   return;
				   }
			   }
			   Resident.addJob(player,this.getText());
			   Gui.switchMenu(player, JobSelectMenu.menu, Hauptmenu.menu);
			   break;
		}
	}

}
