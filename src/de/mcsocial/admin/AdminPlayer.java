package de.mcsocial.admin;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;

public class AdminPlayer {
	
	private static HashMap<UUID,Long>bannedPlayer;

	public void kick (Player admin, Player player, String argument) {
		if(!admin.hasPermission("de.mcsocial.admin.kick")) return;

		player.kickPlayer(argument);
		AdminLogger.writeLog(admin, player, "kick", argument);
	}
	
	public void ban (Player admin, Player player) {
		if(!admin.hasPermission("de.mcsocial.admin.ban")) return;

		player.setBanned(true);
		AdminLogger.writeLog(admin, player, "ban", null);
	}
	
	public void timeban (Player admin, Player player, int minutes) {
		if(!admin.hasPermission("de.mcsocial.admin.timeban")) return;
		
		player.setBanned(true);
		bannedPlayer.put(player.getUniqueId(), (long) (minutes*(20*1*60)));
		AdminLogger.writeLog(admin, player, "timeban", null);
		
	}
	
	public void give (Player admin, Player player, String itemName) {
		if(!admin.hasPermission("de.mcsocial.admin.give")) return;
		ItemStack item = new ItemStack(Material.getMaterial(itemName));
		player.getInventory().addItem(item);
		AdminLogger.writeLog(admin, player, "give", itemName);
	}
	
	public void give (Player admin, Player player, int itemID, int count) {
		if(!admin.hasPermission("de.mcsocial.admin.give")) return;
		ItemStack item = new ItemStack(Material.getMaterial(itemID));
		player.getInventory().addItem(item);
		AdminLogger.writeLog(admin, player, "give", Material.getMaterial(itemID).toString());
	}
	
	public void money (Player admin, Player player, int money) {
		if(!admin.hasPermission("de.mcsocial.admin.money")) return;
		double amount = money;
		Account.add(player, amount);
		AdminLogger.writeLog(admin, player, "money", ""+money);
	}
	
	public void tp (Player admin, Player player) {
		if(!admin.hasPermission("de.mcsocial.admin.tp")) return;
		
		admin.teleport(player);
		AdminLogger.writeLog(admin, player, "tp", null);
		
	}
	
	public void gm (Player admin) {
		if(!admin.hasPermission("de.mcsocial.admin.gm")) return;
		
		GameMode gm = admin.getGameMode();
		 
		if (gm == GameMode.CREATIVE){
			admin.setGameMode(GameMode.SURVIVAL);		 
		} else if (gm == GameMode.SURVIVAL){
			admin.setGameMode(GameMode.CREATIVE);
		}

		AdminLogger.writeLog(admin, null, "gm", null);
	}
	
	public void fly (Player admin) {
		if(!admin.hasPermission("de.mcsocial.admin.fly")) return;
		
		if(admin.getAllowFlight()){
			admin.setAllowFlight(false);
			return;
		}
		admin.setAllowFlight(true);
		AdminLogger.writeLog(admin, null, "fly", null);
		return;
		
	}
}
