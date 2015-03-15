package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.protection.Jail;

public class WorldSpawn extends MenuItem {

	public WorldSpawn(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public WorldSpawn(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
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
