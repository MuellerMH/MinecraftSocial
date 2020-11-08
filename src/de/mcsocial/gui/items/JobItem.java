package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.JobMenu;
import de.mcsocial.gui.Menus.PlayerMenu;

public class JobItem  extends MenuItem {


	public JobItem(String text, Material icon) {

		super(text, new ItemStack(icon,1));
	}

	@Override
	public void onClick(Player player) {

		switch(this.getText()){
			case "Spieler Menu":

				Gui.switchMenu(player, JobMenu.menu, PlayerMenu.menu);
				break;
			default:

			   break;
		}
	}

}
