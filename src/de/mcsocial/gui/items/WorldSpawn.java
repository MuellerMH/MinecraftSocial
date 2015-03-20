package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.protection.Jail;

public class WorldSpawn extends MenuItem {

		
	public WorldSpawn(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub

		if(Jail.isInJail(p)){
			return;
	    }
		p.teleport(p.getServer().getWorld("world").getSpawnLocation());	
	}

}
