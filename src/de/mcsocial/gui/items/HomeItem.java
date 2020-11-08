package de.mcsocial.gui.items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.protection.Jail;

public class HomeItem extends MenuItem {

<<<<<<< HEAD
		
	public HomeItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
=======
	public HomeItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon, 1));
>>>>>>> b4ade11... add new directory
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(Jail.isInJail(p)){
			return;
	    }
		Location goHome = p.getBedSpawnLocation();
		if(goHome == null) {
			p.sendMessage("Stelle zuerst ein Bett in deiner Home Location auf um diesen Befehl nutzen zu können.");
		} else {
			p.teleport(goHome);
		}
		
=======
		if (Jail.isInJail(p)) {
			return;
		}
		Location goHome = p.getBedSpawnLocation();
		if (goHome == null) {
			p.sendMessage("Stelle zuerst ein Bett in deiner Home Location auf um diesen Befehl nutzen zu kï¿½nnen.");
		} else {
			p.teleport(goHome);
		}

>>>>>>> b4ade11... add new directory
	}

}
