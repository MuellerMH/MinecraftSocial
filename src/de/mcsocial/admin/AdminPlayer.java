package de.mcsocial.admin;

import java.util.HashMap;
import java.util.UUID;

<<<<<<< HEAD
=======
import org.bukkit.BanList.Type;
>>>>>>> b4ade11... add new directory
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.city.City;
import de.mcsocial.economy.Account;
import de.mcsocial.permissions.PlayerPermissions;

public class AdminPlayer implements CommandExecutor {
<<<<<<< HEAD
	
	public static HashMap<UUID,Long>bannedPlayer;
	public static Boolean debug;

	public void kick (Player admin, Player player, String argument) {
		if(!admin.hasPermission("MCSocial.kicken")) return;
=======

	public static HashMap<UUID, Long> bannedPlayer;
	public static Boolean debug;

	public void kick(Player admin, Player player, String argument) {
		if (!admin.hasPermission("MCSocial.kicken"))
			return;
>>>>>>> b4ade11... add new directory

		player.kickPlayer(argument);
		AdminLogger.writeLog(admin, player, "kick", argument);
	}
<<<<<<< HEAD
	
	@SuppressWarnings("deprecation")
	public void ban (Player admin, Player player) {
		if(!admin.hasPermission("MCSocial.bannen")) return;

		player.setBanned(true);
		player.kickPlayer("Du wurdest gebannt");
		AdminLogger.writeLog(admin, player, "ban", null);
	}
	
	public void timeban (Player admin, Player player, int minutes) {
		if(!admin.hasPermission("MCSocial.timeban")) return;
	
		int banTime = ((1000*60)*minutes);
		AdminPlayer.bannedPlayer.put(player.getUniqueId(), System.currentTimeMillis() + banTime);
		AdminLogger.writeLog(admin, player, "timeban", null);

		player.kickPlayer("Du wurdest für " +minutes+ " Minuten gebannt");
		
	}
	
	public void give (Player admin, Player player, String itemName) {
		if(!admin.hasPermission("MCSocial.geben")) return;
=======

	public void ban(Player admin, Player player) {
		if (!admin.hasPermission("MCSocial.bannen"))
			return;

		Bukkit.getBanList(Type.NAME).addBan(player.getDisplayName(), null, null, null);
		player.kickPlayer("Du wurdest gebannt");
		AdminLogger.writeLog(admin, player, "ban", null);
	}

	public void timeban(Player admin, Player player, int minutes) {
		if (!admin.hasPermission("MCSocial.timeban"))
			return;

		int banTime = ((1000 * 60) * minutes);
		AdminPlayer.bannedPlayer.put(player.getUniqueId(), System.currentTimeMillis() + banTime);
		AdminLogger.writeLog(admin, player, "timeban", null);

		player.kickPlayer("Du wurdest fï¿½r " + minutes + " Minuten gebannt");

	}

	public void give(Player admin, Player player, String itemName) {
		if (!admin.hasPermission("MCSocial.geben"))
			return;
>>>>>>> b4ade11... add new directory
		ItemStack item = new ItemStack(Material.getMaterial(itemName));
		player.getInventory().addItem(item);
		AdminLogger.writeLog(admin, player, "give", itemName);
	}
<<<<<<< HEAD
	
	@SuppressWarnings("deprecation")
	public void give (Player admin, Player player, int itemID, int count) {
		if(!admin.hasPermission("MCSocial.geben")) return;
=======

	public void give(Player admin, Player player, String itemID, int count) {
		if (!admin.hasPermission("MCSocial.geben"))
			return;
>>>>>>> b4ade11... add new directory
		ItemStack item = new ItemStack(Material.getMaterial(itemID));
		player.getInventory().addItem(item);
		AdminLogger.writeLog(admin, player, "give", Material.getMaterial(itemID).toString());
	}
<<<<<<< HEAD
	
	public void money (Player admin, Player player, int money) {
		if(!admin.hasPermission("MCSocial.money")) return;
		double amount = money;
		Account.add(player, amount);
		AdminLogger.writeLog(admin, player, "money", ""+money);
	}
	
	public void tp (Player admin, Player player) {
		if(!admin.hasPermission("MCSocial.teleport")) return;
		
		admin.teleport(player);
		AdminLogger.writeLog(admin, player, "tp", null);
		
	}
	
	public void gm (Player admin) {
		if(!admin.hasPermission("MCSocial.gm")) return;
		
		GameMode gm = admin.getGameMode();
		if(PlayerPermissions.hasAccess(admin, "admin")){
			if (gm == GameMode.CREATIVE){
				admin.setGameMode(GameMode.SURVIVAL);		 
			} else if (gm == GameMode.SURVIVAL){
				admin.setGameMode(GameMode.CREATIVE);
			}
		} else {
			if (gm == GameMode.SPECTATOR){
				admin.setGameMode(GameMode.SURVIVAL);		 
			} else if (gm == GameMode.SURVIVAL){
=======

	public void money(Player admin, Player player, int money) {
		if (!admin.hasPermission("MCSocial.money"))
			return;
		double amount = money;
		Account.add(player, amount);
		AdminLogger.writeLog(admin, player, "money", "" + money);
	}

	public void tp(Player admin, Player player) {
		if (!admin.hasPermission("MCSocial.teleport"))
			return;

		admin.teleport(player);
		AdminLogger.writeLog(admin, player, "tp", null);

	}

	public void gm(Player admin) {
		if (!admin.hasPermission("MCSocial.gm"))
			return;

		GameMode gm = admin.getGameMode();
		if (PlayerPermissions.hasAccess(admin, "admin")) {
			if (gm == GameMode.CREATIVE) {
				admin.setGameMode(GameMode.SURVIVAL);
			} else if (gm == GameMode.SURVIVAL) {
				admin.setGameMode(GameMode.CREATIVE);
			}
		} else {
			if (gm == GameMode.SPECTATOR) {
				admin.setGameMode(GameMode.SURVIVAL);
			} else if (gm == GameMode.SURVIVAL) {
>>>>>>> b4ade11... add new directory
				admin.setGameMode(GameMode.SPECTATOR);
			}
		}
		AdminLogger.writeLog(admin, null, "gm", null);
	}
<<<<<<< HEAD
	
	public void fly (Player admin) {
		if(!admin.hasPermission("MCSocial.fly")) return;
		
		if(admin.getAllowFlight()){
=======

	public void fly(Player admin) {
		if (!admin.hasPermission("MCSocial.fly"))
			return;

		if (admin.getAllowFlight()) {
>>>>>>> b4ade11... add new directory
			admin.setAllowFlight(false);
			return;
		}
		admin.setAllowFlight(true);
		AdminLogger.writeLog(admin, null, "fly", null);
		return;
<<<<<<< HEAD
		
	}
	
	public static boolean isDebug(Player admin){
		if(!admin.isOp()) return false;
		if(AdminPlayer.debug == null) return false;
		if(AdminPlayer.debug) return true; 	
=======

	}

	public static boolean isDebug(Player admin) {
		if (!admin.isOp())
			return false;
		if (AdminPlayer.debug == null)
			return false;
		if (AdminPlayer.debug)
			return true;
>>>>>>> b4ade11... add new directory
		City.debug();
		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player admin = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("bannen")) {
			if(args.length == 1){
				try{
					ban(admin, Bukkit.getPlayer(args[0]));
					return true;
				} catch( NullPointerException e ){
=======
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}

		Player admin = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("bannen")) {
			if (args.length == 1) {
				try {
					ban(admin, Bukkit.getPlayer(args[0]));
					return true;
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		
		if(cmd.getName().equalsIgnoreCase("timeban")) {
			if(args.length == 2){
				try{
					timeban(admin, Bukkit.getPlayer(args[0]), Integer.parseInt(args[1]));
					return true;
				} catch( NumberFormatException e ){
					admin.sendMessage("Zeitangabe ist falsch.");
				}catch( NullPointerException e ){
=======

		if (cmd.getName().equalsIgnoreCase("timeban")) {
			if (args.length == 2) {
				try {
					timeban(admin, Bukkit.getPlayer(args[0]), Integer.parseInt(args[1]));
					return true;
				} catch (NumberFormatException e) {
					admin.sendMessage("Zeitangabe ist falsch.");
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		
		if(cmd.getName().equalsIgnoreCase("kicken")) {
			if(args.length == 2){
				try{
					kick(admin, Bukkit.getPlayer(args[0]),args[1]);
					return true;
				} catch( NullPointerException e ){
=======

		if (cmd.getName().equalsIgnoreCase("kicken")) {
			if (args.length == 2) {
				try {
					kick(admin, Bukkit.getPlayer(args[0]), args[1]);
					return true;
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Befehl falsch eingegeben");
					return false;
				}
			}
			return false;
		}
<<<<<<< HEAD
		
		if(cmd.getName().equalsIgnoreCase("geben")) {
			if(args.length == 2){
				try{
					give(admin, Bukkit.getPlayer(args[0]), args[1]);
					return true;
				} catch( NullPointerException e ){
=======

		if (cmd.getName().equalsIgnoreCase("geben")) {
			if (args.length == 2) {
				try {
					give(admin, Bukkit.getPlayer(args[0]), args[1]);
					return true;
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		
		if(cmd.getName().equalsIgnoreCase("teleport")) {
			if(args.length == 3){
				try{
					Location target = new Location(admin.getLocation().getWorld(), Integer.parseInt(args[0]),Integer.parseInt( args[1]), Integer.parseInt(args[2]));
					tp(admin, target);
					return true;
				} catch( NumberFormatException e ){
					admin.sendMessage("Zieleingabe ist falsch.");
				}catch( NullPointerException e ){
=======

		if (cmd.getName().equalsIgnoreCase("teleport")) {
			if (args.length == 3) {
				try {
					Location target = new Location(admin.getLocation().getWorld(), Integer.parseInt(args[0]),
							Integer.parseInt(args[1]), Integer.parseInt(args[2]));
					tp(admin, target);
					return true;
				} catch (NumberFormatException e) {
					admin.sendMessage("Zieleingabe ist falsch.");
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
<<<<<<< HEAD
			if(args.length == 2){
				try{
					tp(Bukkit.getPlayer(args[0]), Bukkit.getPlayer(args[1]));
					return true;
				} catch( NullPointerException e ){
=======
			if (args.length == 2) {
				try {
					tp(Bukkit.getPlayer(args[0]), Bukkit.getPlayer(args[1]));
					return true;
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
<<<<<<< HEAD
			if(args.length == 1){
				try{
					tp(admin, Bukkit.getPlayer(args[0]));
					return true;
				} catch( NullPointerException e ){
=======
			if (args.length == 1) {
				try {
					tp(admin, Bukkit.getPlayer(args[0]));
					return true;
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		
		if(cmd.getName().equalsIgnoreCase("money")) {
			if(args.length == 2){
				try{
					money(admin, Bukkit.getPlayer(args[0]), Integer.parseInt(args[1]));
					return true;
				} catch( NumberFormatException e ){
					admin.sendMessage("Geldmenge ist falsch.");
				}catch( NullPointerException e ){
=======

		if (cmd.getName().equalsIgnoreCase("money")) {
			if (args.length == 2) {
				try {
					money(admin, Bukkit.getPlayer(args[0]), Integer.parseInt(args[1]));
					return true;
				} catch (NumberFormatException e) {
					admin.sendMessage("Geldmenge ist falsch.");
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler existiert nicht.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		if(cmd.getName().equalsIgnoreCase("balance")) {
			if(args.length == 1){
				try{
					Player p = (Player) Bukkit.getPlayer(args[0]);
					admin.sendMessage(p.getName() + " KontoStand: " + Account.getBalance(p));
					return true;
				} catch( NumberFormatException e ){
					admin.sendMessage("Geldmenge ist falsch.");
				}catch( NullPointerException e ){
=======
		if (cmd.getName().equalsIgnoreCase("balance")) {
			if (args.length == 1) {
				try {
					Player p = (Player) Bukkit.getPlayer(args[0]);
					admin.sendMessage(p.getName() + " KontoStand: " + Account.getBalance(p));
					return true;
				} catch (NumberFormatException e) {
					admin.sendMessage("Geldmenge ist falsch.");
				} catch (NullPointerException e) {
>>>>>>> b4ade11... add new directory
					admin.sendMessage("Spieler ist nicht online.");
				}
				return false;
			}
			return false;
		}
<<<<<<< HEAD
		if(cmd.getName().equalsIgnoreCase("fly")) {
			fly(admin);
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("gm")) {
			gm(admin);
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("debug")) {
			if(AdminPlayer.debug == null){
				AdminPlayer.debug = true;				
			}else if(AdminPlayer.debug == false){
				AdminPlayer.debug = true;
			}else{
				AdminPlayer.debug = false;
			}
						
=======
		if (cmd.getName().equalsIgnoreCase("fly")) {
			fly(admin);
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("gm")) {
			gm(admin);
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("debug")) {
			if (AdminPlayer.debug == null) {
				AdminPlayer.debug = true;
			} else if (AdminPlayer.debug == false) {
				AdminPlayer.debug = true;
			} else {
				AdminPlayer.debug = false;
			}

>>>>>>> b4ade11... add new directory
			return true;
		}
		return false;
	}

	private void tp(Player admin, Location target) {
<<<<<<< HEAD
		if(!admin.hasPermission("MCSocial.teleport")) return;
		
		admin.teleport(target);
		AdminLogger.writeLog(admin, null, "tp", null);
		
=======
		if (!admin.hasPermission("MCSocial.teleport"))
			return;

		admin.teleport(target);
		AdminLogger.writeLog(admin, null, "tp", null);

>>>>>>> b4ade11... add new directory
	}
}
