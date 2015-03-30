package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;
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
		 if(Account.getBalance(p) < 100.00){
			p.sendMessage("Schnellreise nicht möglich. Du hast nicht genügend Geld. Du benötigst 100 SD");
			return;
		}
		p.teleport(p.getServer().getWorld("world").getSpawnLocation());	
	}

}
