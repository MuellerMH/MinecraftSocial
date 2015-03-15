package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.JobMenu;
import de.mcsocial.gui.Menus.PlayerMenu;

public class JobItem  extends MenuItem {

	public JobItem(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public JobItem(String text, Material icon) {
		super(text, new MaterialData(icon));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub
		switch(this.getText()){
			case "Spieler Menu":
				// TODO Auto-generated method stub
				Gui.switchMenu(player, JobMenu.menu, PlayerMenu.menu);
				break;
			default:
			   
			   break;
		}
	}

}
