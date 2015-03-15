package de.mcsocial.gui.items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.protection.Jail;

public class HomeItem extends MenuItem {

	public HomeItem(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	public HomeItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub
		if(Jail.isInJail(p)){
			return;
	    }
		Location goHome = p.getBedSpawnLocation();
		if(goHome == null) {
			p.sendMessage("Stelle zuerst ein Bett in deiner Home Location auf um diesen Befehl nutzen zu können.");
		} else {
			p.teleport(goHome);
		}
		
	}

}
