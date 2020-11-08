package de.mcsocial.protection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import de.mcsocial.city.City;
import de.mcsocial.economy.Account;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.main.MySQL;
import de.mcsocial.permissions.PlayerPermissions;

<<<<<<< HEAD
public class ChunkHandler implements Listener,CommandExecutor {

	public static Material edgeID = Material.WOOL;
	public static Material edgeIDRemove = Material.AIR;	
	public static HashMap<String,Chunk> lastChunk = new HashMap<String,Chunk>();	
	public static HashMap<String,CustomChunk> ownedChunks;
	public static ResultSet ownedChunksResult=null;
	
	public ChunkHandler(){
		loadOwnedChunks();
	}
	
		
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		Player player = event.getPlayer();
		Chunk chunk = player.getLocation().getChunk();
		
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
		
		if(ChunkHandler.ownedChunks == null)
		{
			ChunkHandler.ownedChunks = new HashMap<String,CustomChunk>();
		}
		
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			if(cChunk == null) return;
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				return;
			}
			
			if(Jail.isJailChunks(chunk)){
				return;
			}
			
			try{
				if(cChunk.getCityName() != null){					
					if(cChunk.getCityName().equalsIgnoreCase("WorldSpawn")){		
						if(event.getRightClicked().isCustomNameVisible()){
							return;
						}
					}					
				}
			}catch(NullPointerException e ){
				player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
				event.setCancelled(true);
				return;
			}
			
			if(cChunk.isCity()){
				//system.out.println("isCity");
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getOwner())){						
					if(City.isVillager(player.getUniqueId(), cChunk.getOwner())){
						//system.out.println("in City");
						return;
					}
				} else {
					//system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
			event.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onLoad(ChunkLoadEvent event) {
			
	}
	
	public static Boolean isClaimAble(Chunk chunk) {
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
=======
public class ChunkHandler implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	public static Material edgeID = Material.LEGACY_WOOL;
	public static Material edgeIDRemove = Material.AIR;
	public static HashMap<String, Chunk> lastChunk = new HashMap<String, Chunk>();
	public static HashMap<String, CustomChunk> ownedChunks;
	public static ResultSet ownedChunksResult = null;

	public ChunkHandler() {
		loadOwnedChunks();
	}

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		Chunk chunk = player.getLocation().getChunk();

		if (player.isOp())
			return;

		if (PlayerPermissions.hasAccess(player, "supporter"))
			return;

		if (ChunkHandler.ownedChunks == null) {
			ChunkHandler.ownedChunks = new HashMap<String, CustomChunk>();
		}

		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			if (cChunk == null)
				return;

			if (cChunk.getOwner().equals(player.getUniqueId())) {
				return;
			}

			if (cChunk.hasAccess(player.getUniqueId())) {
				return;
			}

			if (Jail.isJailChunks(chunk)) {
				return;
			}

			try {
				if (cChunk.getCityName() != null) {
					if (cChunk.getCityName().equalsIgnoreCase("WorldSpawn")) {
						if (event.getRightClicked().isCustomNameVisible()) {
							return;
						}
					}
				}
			} catch (NullPointerException e) {
				player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstï¿½ck.");
				event.setCancelled(true);
				return;
			}

			if (cChunk.isCity()) {
				// system.out.println("isCity");
				// TODO: if player in City?
				if (City.cityList.containsKey(cChunk.getOwner())) {
					if (City.isVillager(player.getUniqueId(), cChunk.getOwner())) {
						// system.out.println("in City");
						return;
					}
				} else {
					// system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstï¿½ck.");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onLoad(ChunkLoadEvent event) {

	}

	public static Boolean isClaimAble(Chunk chunk) {
		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
>>>>>>> b4ade11... add new directory
			return false;
		}
		return true;
	}
<<<<<<< HEAD
	
	public static Boolean isClaimAble(Player p) {
		if(ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())){
=======

	public static Boolean isClaimAble(Player p) {
		if (ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())) {
>>>>>>> b4ade11... add new directory
			return false;
		}
		return true;
	}

	public static void unclaimChunk(Player p, double price) {
		// TODO Auto-generated method stub
		Chunk chunk = p.getLocation().getChunk();
<<<<<<< HEAD
		if(!p.isOp()){
			if(!ChunkHandler.ownedChunks.containsKey(chunk.toString())){
				return;
			}
				
			if(ChunkHandler.getOwner(chunk) != null){
				if(!ChunkHandler.getOwner(chunk).equals(p.getUniqueId())){
=======
		if (!p.isOp()) {
			if (!ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
				return;
			}

			if (ChunkHandler.getOwner(chunk) != null) {
				if (!ChunkHandler.getOwner(chunk).equals(p.getUniqueId())) {
>>>>>>> b4ade11... add new directory
					return;
				}
			}
		}
<<<<<<< HEAD
		
		ChunkHandler.ownedChunks.remove(chunk.toString());		
		ChunkHandler.remove(chunk.toString());
		Account.add(p, price);
	}
	
	private static void remove(String string) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM MCS_chunkowner WHERE chunkid = ?";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, string);	
			MySQL.insertDB(preparedStmt);								
=======

		ChunkHandler.ownedChunks.remove(chunk.toString());
		ChunkHandler.remove(chunk.toString());
		Account.add(p, price);
	}

	private static void remove(String string) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM MCS_chunkowner WHERE chunkid = ?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, string);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CustomChunk getChunk(Chunk chunk) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString()))
=======
		if (ChunkHandler.ownedChunks.containsKey(chunk.toString()))
>>>>>>> b4ade11... add new directory
			return ChunkHandler.ownedChunks.get(chunk.toString());
		return null;
	}

<<<<<<< HEAD
	public static void claimJailChunk(Player p, Double price){
		if(ChunkHandler.ownedChunks == null){
			ChunkHandler.ownedChunks = new HashMap<String,CustomChunk>(); 
		}
		
		Chunk chunk = p.getLocation().getChunk();
		JailChunk cChunk = null;
		if(!p.isOp()){
			if(Account.getBalance(p) < price){
				p.sendMessage(ChatColor.RED + "Dieses Grundstück kannst du dir nicht leisten!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			
			if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
				cChunk = (JailChunk) ChunkHandler.ownedChunks.get(chunk.toString());
				if(!cChunk.isBuyAble()){
					p.sendMessage(ChatColor.RED + "Dieses Grundstück steht nicht zum verkaufen!");
					p.sendMessage(ChatColor.RED + "Wende dich an deinen Lehnsherren!");
					Hauptmenu.menu.closeMenu(p);
					return;
				}			
				p.sendMessage(ChatColor.RED + "Dieses Grundstück ist bereits vergeben!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			if(cChunk == null){
				cChunk = new JailChunk(chunk.toString(), p.getUniqueId(),true,"Gefängnis");
			}
			cChunk.setOwner(p);
		}else{
			cChunk = new JailChunk(chunk.toString(), p.getUniqueId(),true,"Gefängnis");
		}
		cChunk.setIsJail(true);
		ChunkHandler.ownedChunks.put(chunk.toString(),cChunk);		
=======
	public static void claimJailChunk(Player p, Double price) {
		if (ChunkHandler.ownedChunks == null) {
			ChunkHandler.ownedChunks = new HashMap<String, CustomChunk>();
		}

		Chunk chunk = p.getLocation().getChunk();
		JailChunk cChunk = null;
		if (!p.isOp()) {
			if (Account.getBalance(p) < price) {
				p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck kannst du dir nicht leisten!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}

			if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
				cChunk = (JailChunk) ChunkHandler.ownedChunks.get(chunk.toString());
				if (!cChunk.isBuyAble()) {
					p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck steht nicht zum verkaufen!");
					p.sendMessage(ChatColor.RED + "Wende dich an deinen Lehnsherren!");
					Hauptmenu.menu.closeMenu(p);
					return;
				}
				p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck ist bereits vergeben!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			if (cChunk == null) {
				cChunk = new JailChunk(chunk.toString(), p.getUniqueId(), true, "Gefï¿½ngnis");
			}
			cChunk.setOwner(p);
		} else {
			cChunk = new JailChunk(chunk.toString(), p.getUniqueId(), true, "Gefï¿½ngnis");
		}
		cChunk.setIsJail(true);
		ChunkHandler.ownedChunks.put(chunk.toString(), cChunk);
>>>>>>> b4ade11... add new directory
		Jail.setJailChunks(cChunk);
		ChunkHandler.save(cChunk);
		Account.remove(p, price);
	}

<<<<<<< HEAD
	public static void claimChunk(Player p, Double price){
		if(ChunkHandler.ownedChunks == null){
			ChunkHandler.ownedChunks = new HashMap<String,CustomChunk>(); 
		}
		Chunk chunk = p.getLocation().getChunk();
		CustomChunk cChunk = null;
		if(!p.isOp()){
			if(Account.getBalance(p) < price){
				p.sendMessage(ChatColor.RED + "Dieses Grundstück kannst du dir nicht leisten!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			
			if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
				cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
				if(!cChunk.isBuyAble()){
					p.sendMessage(ChatColor.RED + "Dieses Grundstück steht nicht zum verkaufen!");
					p.sendMessage(ChatColor.RED + "Wende dich an deinen Lehnsherren!");
					Hauptmenu.menu.closeMenu(p);
					return;
				}			
				p.sendMessage(ChatColor.RED + "Dieses Grundstück ist bereits vergeben!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			if(cChunk == null){
				cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(),false,null);
			}
			cChunk.setOwner(p);
		}else{
			cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(),false,null);
		}
		
		ChunkHandler.ownedChunks.put(chunk.toString(),cChunk);		
		ChunkHandler.save(cChunk);
		Account.remove(p, price);
	}
	
	public static String getOwnerName(String string){
		CustomChunk chunk = ChunkHandler.ownedChunks.get(string);
		if(chunk.isCity())
=======
	public static void claimChunk(Player p, Double price) {
		if (ChunkHandler.ownedChunks == null) {
			ChunkHandler.ownedChunks = new HashMap<String, CustomChunk>();
		}
		Chunk chunk = p.getLocation().getChunk();
		CustomChunk cChunk = null;
		if (!p.isOp()) {
			if (Account.getBalance(p) < price) {
				p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck kannst du dir nicht leisten!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}

			if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
				cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
				if (!cChunk.isBuyAble()) {
					p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck steht nicht zum verkaufen!");
					p.sendMessage(ChatColor.RED + "Wende dich an deinen Lehnsherren!");
					Hauptmenu.menu.closeMenu(p);
					return;
				}
				p.sendMessage(ChatColor.RED + "Dieses Grundstï¿½ck ist bereits vergeben!");
				Hauptmenu.menu.closeMenu(p);
				return;
			}
			if (cChunk == null) {
				cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(), false, null);
			}
			cChunk.setOwner(p);
		} else {
			cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(), false, null);
		}

		ChunkHandler.ownedChunks.put(chunk.toString(), cChunk);
		ChunkHandler.save(cChunk);
		Account.remove(p, price);
	}

	public static String getOwnerName(String string) {
		CustomChunk chunk = ChunkHandler.ownedChunks.get(string);
		if (chunk.isCity())
>>>>>>> b4ade11... add new directory
			return chunk.getCityName();
		else
			return Bukkit.getOfflinePlayer(chunk.getOwner()).getName();
	}
<<<<<<< HEAD
	
	private Location loadCellSpawns(JailChunk chunk){
		try {
			PreparedStatement preparedStmt = MySQL.getPreStat("SELECT location FROM MCS_jailcell WHERE chunkid=?");
			preparedStmt.setObject (1, chunk.getName());	
			ResultSet res = MySQL.callDB(preparedStmt);
			while(res.next()){
				int x = Integer.parseInt(res.getString("location").split(",")[0]);
				int z = Integer.parseInt(res.getString("location").split(",")[2]);
				int y = Integer.parseInt(res.getString("location").split(",")[1]);
				return  new Location(Bukkit.getWorld("world"),x,y,z);				
=======

	private Location loadCellSpawns(JailChunk chunk) {
		try {
			PreparedStatement preparedStmt = MySQL.getPreStat("SELECT location FROM MCS_jailcell WHERE chunkid=?");
			preparedStmt.setObject(1, chunk.getName());
			ResultSet res = MySQL.callDB(preparedStmt);
			while (res.next()) {
				int x = Integer.parseInt(res.getString("location").split(",")[0]);
				int z = Integer.parseInt(res.getString("location").split(",")[2]);
				int y = Integer.parseInt(res.getString("location").split(",")[1]);
				return new Location(Bukkit.getWorld("world"), x, y, z);
>>>>>>> b4ade11... add new directory
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
<<<<<<< HEAD
	
	private static void saveCellSpawns(JailChunk chunk){

		String sql = "insert IGNORE into MCS_jailcell (location,chunkid)"
		        + " values (?,?)"
		        + " ON DUPLICATE KEY UPDATE location=?";
		
		for(Location loc: chunk.getCellSpawns()){
			
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			
			try {
				preparedStmt.setString (1, loc.getBlockX()+","+ loc.getBlockY()+","+ loc.getBlockZ());				
				preparedStmt.setString (2, chunk.getName());	
				preparedStmt.setString (3, loc.getBlockX()+","+ loc.getBlockZ()+","+ loc.getBlockY());	
				MySQL.insertDB(preparedStmt);								
=======

	private static void saveCellSpawns(JailChunk chunk) {

		String sql = "insert IGNORE into MCS_jailcell (location,chunkid)" + " values (?,?)"
				+ " ON DUPLICATE KEY UPDATE location=?";

		for (Location loc : chunk.getCellSpawns()) {

			PreparedStatement preparedStmt = MySQL.getPreStat(sql);

			try {
				preparedStmt.setString(1, loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ());
				preparedStmt.setString(2, chunk.getName());
				preparedStmt.setString(3, loc.getBlockX() + "," + loc.getBlockZ() + "," + loc.getBlockY());
				MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
<<<<<<< HEAD
			
		}
	}
	@SuppressWarnings("deprecation")
	private void loadOwnedChunks(){
		if(ChunkHandler.ownedChunks != null)
			return;
		
		ChunkHandler.ownedChunks = new HashMap<String,CustomChunk>();
		
		try {		
			if(ChunkHandler.ownedChunksResult == null) {
				ChunkHandler.ownedChunksResult = MySQL.callDB("SELECT chunkid,ownerid, iscity, cityname,buyable,world,buyprice,isJail FROM MCS_chunkowner;");	
			}
			while(ChunkHandler.ownedChunksResult.next()){
				String name,cityname;
				UUID owner;
				boolean ownerIsCity,isJail;
				try{
					owner = UUID.fromString( ChunkHandler.ownedChunksResult.getString( "ownerid" ) );
				}catch(Exception e){
					owner = Bukkit.getOfflinePlayer(ChunkHandler.ownedChunksResult.getString( "ownerid" )).getUniqueId();
=======

		}
	}

	@SuppressWarnings("deprecation")
	private void loadOwnedChunks() {
		if (ChunkHandler.ownedChunks != null)
			return;

		ChunkHandler.ownedChunks = new HashMap<String, CustomChunk>();

		try {
			if (ChunkHandler.ownedChunksResult == null) {
				ChunkHandler.ownedChunksResult = MySQL
						.callDB("SELECT chunkid,ownerid, iscity, cityname,buyable,world,buyprice,isJail FROM MCS_chunkowner;");
			}
			while (ChunkHandler.ownedChunksResult.next()) {
				String name, cityname;
				UUID owner;
				boolean ownerIsCity, isJail;
				try {
					owner = UUID.fromString(ChunkHandler.ownedChunksResult.getString("ownerid"));
				} catch (Exception e) {
					owner = Bukkit.getOfflinePlayer(ChunkHandler.ownedChunksResult.getString("ownerid")).getUniqueId();
>>>>>>> b4ade11... add new directory
				}
				name = ChunkHandler.ownedChunksResult.getString("chunkid");
				ownerIsCity = ChunkHandler.ownedChunksResult.getBoolean("iscity");
				cityname = ChunkHandler.ownedChunksResult.getString("cityname");
				isJail = ChunkHandler.ownedChunksResult.getBoolean("isJail");
<<<<<<< HEAD
				
				CustomChunk chunk;
				chunk = new CustomChunk(name,owner,ownerIsCity,cityname);
				
				if(isJail){
					chunk = new JailChunk(name,owner,ownerIsCity,cityname);
					Jail.setJailChunks((JailChunk) chunk);
					((JailChunk) chunk).createCellSpawn(loadCellSpawns((JailChunk) chunk));
				}
					
				chunk.setBuyAble(ChunkHandler.ownedChunksResult.getBoolean("buyable"));
				chunk.setPrice(ChunkHandler.ownedChunksResult.getDouble("buyprice"));
				ChunkHandler.ownedChunks.put(name,chunk);	
=======

				CustomChunk chunk;
				chunk = new CustomChunk(name, owner, ownerIsCity, cityname);

				if (isJail) {
					chunk = new JailChunk(name, owner, ownerIsCity, cityname);
					Jail.setJailChunks((JailChunk) chunk);
					((JailChunk) chunk).createCellSpawn(loadCellSpawns((JailChunk) chunk));
				}

				chunk.setBuyAble(ChunkHandler.ownedChunksResult.getBoolean("buyable"));
				chunk.setPrice(ChunkHandler.ownedChunksResult.getDouble("buyprice"));
				ChunkHandler.ownedChunks.put(name, chunk);
>>>>>>> b4ade11... add new directory
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent event) {
		Block block = event.getBlock();
		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();
<<<<<<< HEAD
		
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
		
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}
			
			if(cChunk.isCity()){
				//system.out.println("isCity");
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getOwner())){						
					if(City.isVillager(player.getUniqueId(), cChunk.getOwner())){
						//system.out.println("in City");
=======

		if (player.isOp())
			return;

		if (PlayerPermissions.hasAccess(player, "supporter"))
			return;

		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());

			if (cChunk.getOwner().equals(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}

			if (cChunk.hasAccess(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}

			if (cChunk.isCity()) {
				// system.out.println("isCity");
				// TODO: if player in City?
				if (City.cityList.containsKey(cChunk.getOwner())) {
					if (City.isVillager(player.getUniqueId(), cChunk.getOwner())) {
						// system.out.println("in City");
>>>>>>> b4ade11... add new directory
						event.setCancelled(false);
						return;
					}
				} else {
<<<<<<< HEAD
					//system.out.println("not in City Resis");
					event.setCancelled(true);
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
=======
					// system.out.println("not in City Resis");
					event.setCancelled(true);
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstï¿½ck.");
>>>>>>> b4ade11... add new directory
			event.setCancelled(true);
			return;
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();
		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();

<<<<<<< HEAD
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
							
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}
			
			if(cChunk.isCity()){
				//system.out.println("isCity");
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getOwner())){						
					if(City.isVillager(player.getUniqueId(), cChunk.getOwner())){
						//system.out.println("in City");
=======
		if (player.isOp())
			return;

		if (PlayerPermissions.hasAccess(player, "supporter"))
			return;

		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());

			if (cChunk.getOwner().equals(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}

			if (cChunk.hasAccess(player.getUniqueId())) {
				event.setCancelled(false);
				return;
			}

			if (cChunk.isCity()) {
				// system.out.println("isCity");
				// TODO: if player in City?
				if (City.cityList.containsKey(cChunk.getOwner())) {
					if (City.isVillager(player.getUniqueId(), cChunk.getOwner())) {
						// system.out.println("in City");
>>>>>>> b4ade11... add new directory
						event.setCancelled(false);
						return;
					}
				} else {
					event.setCancelled(true);
<<<<<<< HEAD
					//system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
=======
					// system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstï¿½ck.");
>>>>>>> b4ade11... add new directory
			event.setCancelled(true);
			event.setBuild(false);
		}
	}
<<<<<<< HEAD
	
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
		Block block = event.getClickedBlock();		
		
		if(block == null)
			return;
		
		if(ChunkHandler.ownedChunks == null)
			return;
		
		if(block.getType().equals(Material.AIR))
			return;
				
		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();
		
		if(Jail.isJailChunks(chunk)){
			return;
		}
		
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
		
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getCityName() != null)
				if(cChunk.getCityName().equalsIgnoreCase("WorldSpawn")) return;			
			if(cChunk.getOwner().equals(player.getUniqueId())) return;			
			if(cChunk.hasAccess(player.getUniqueId())) return;
			
			if(cChunk.isCity()){
				//system.out.println("isCity");
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getOwner())){						
					if(City.isVillager(player.getUniqueId(), cChunk.getOwner())){
						//system.out.println("in City");
						return;
					}
				} else {
					//system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
=======

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Block block = event.getClickedBlock();

		if (block == null)
			return;

		if (ChunkHandler.ownedChunks == null)
			return;

		if (block.getType().equals(Material.AIR))
			return;

		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();

		if (Jail.isJailChunks(chunk)) {
			return;
		}

		if (player.isOp())
			return;

		if (PlayerPermissions.hasAccess(player, "supporter"))
			return;

		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());

			if (cChunk.getCityName() != null)
				if (cChunk.getCityName().equalsIgnoreCase("WorldSpawn"))
					return;
			if (cChunk.getOwner().equals(player.getUniqueId()))
				return;
			if (cChunk.hasAccess(player.getUniqueId()))
				return;

			if (cChunk.isCity()) {
				// system.out.println("isCity");
				// TODO: if player in City?
				if (City.cityList.containsKey(cChunk.getOwner())) {
					if (City.isVillager(player.getUniqueId(), cChunk.getOwner())) {
						// system.out.println("in City");
						return;
					}
				} else {
					// system.out.println("not in City Resis");
				}
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstï¿½ck.");
>>>>>>> b4ade11... add new directory
			event.setUseInteractedBlock(Result.DENY);
			event.setUseItemInHand(Result.ALLOW);
			event.setCancelled(true);
		}
<<<<<<< HEAD
    }
	
	
	/**
     * Places Blocks of a predetermined type just above the highest Block at each edge of the given Chunk
     *
     * @param chunk The given Chunk
     */
    @SuppressWarnings("deprecation")
	public static void markEdges(Player player) {

		if( ChunkHandler.lastChunk == null)
			 ChunkHandler.lastChunk = new HashMap<String, Chunk>();
    	
    	Chunk chunk = player.getLocation().getChunk();
        
        Location corner1 = chunk.getBlock(0, 0, 0).getLocation();
        Location corner2 = chunk.getBlock(15, 0, 0).getLocation();
        Location corner3 = chunk.getBlock(0, 0, 15).getLocation();
        Location corner4 = chunk.getBlock(15, 0, 15).getLocation();
        int i = 0;
        int i2 = 0;
    
        for(i = 0; i < 127; i++){
            for(i2 = 0; i2 < 15; i2++){
                corner1 = chunk.getBlock(i2, i, 0).getLocation();
                corner2 = chunk.getBlock(15, i, i2).getLocation();
                corner3 = chunk.getBlock((15 - i2), i, 15).getLocation();
                corner4 = chunk.getBlock(0, i, (15 - i2)).getLocation();
                if(corner1.getBlock().getType() == Material.AIR){player.sendBlockChange(corner1, Material.GLASS, (byte) 20);}
                if(corner2.getBlock().getType() == Material.AIR){player.sendBlockChange(corner2, Material.GLASS, (byte) 20);}
                if(corner3.getBlock().getType() == Material.AIR){player.sendBlockChange(corner3, Material.GLASS, (byte) 20);}
                if(corner4.getBlock().getType() == Material.AIR){player.sendBlockChange(corner4, Material.GLASS, (byte) 20);}
            }
        }
        ChunkHandler.lastChunk.put(player.getName(),chunk);
    }
=======
	}

	/**
	 * Places Blocks of a predetermined type just above the highest Block at each
	 * edge of the given Chunk
	 *
	 * @param chunk The given Chunk
	 */
	@SuppressWarnings("deprecation")
	public static void markEdges(Player player) {

		if (ChunkHandler.lastChunk == null)
			ChunkHandler.lastChunk = new HashMap<String, Chunk>();

		Chunk chunk = player.getLocation().getChunk();

		Location corner1 = chunk.getBlock(0, 0, 0).getLocation();
		Location corner2 = chunk.getBlock(15, 0, 0).getLocation();
		Location corner3 = chunk.getBlock(0, 0, 15).getLocation();
		Location corner4 = chunk.getBlock(15, 0, 15).getLocation();
		int i = 0;
		int i2 = 0;

		for (i = 0; i < 127; i++) {
			for (i2 = 0; i2 < 15; i2++) {
				corner1 = chunk.getBlock(i2, i, 0).getLocation();
				corner2 = chunk.getBlock(15, i, i2).getLocation();
				corner3 = chunk.getBlock((15 - i2), i, 15).getLocation();
				corner4 = chunk.getBlock(0, i, (15 - i2)).getLocation();
				if (corner1.getBlock().getType() == Material.AIR) {
					player.sendBlockChange(corner1, Material.GLASS, (byte) 20);
				}
				if (corner2.getBlock().getType() == Material.AIR) {
					player.sendBlockChange(corner2, Material.GLASS, (byte) 20);
				}
				if (corner3.getBlock().getType() == Material.AIR) {
					player.sendBlockChange(corner3, Material.GLASS, (byte) 20);
				}
				if (corner4.getBlock().getType() == Material.AIR) {
					player.sendBlockChange(corner4, Material.GLASS, (byte) 20);
				}
			}
		}
		ChunkHandler.lastChunk.put(player.getName(), chunk);
	}
>>>>>>> b4ade11... add new directory

	public static void save(CustomChunk chunk) {
		// TODO Auto-generated method stub

<<<<<<< HEAD
	        saveChunkAccess(chunk);
	        saveChunkFlags(chunk);
	        insertChunkOwner(chunk);
	}
	
=======
		saveChunkAccess(chunk);
		saveChunkFlags(chunk);
		insertChunkOwner(chunk);
	}

>>>>>>> b4ade11... add new directory
	@SuppressWarnings("rawtypes")
	private static void saveChunkFlags(CustomChunk chunk) {
		// TODO Auto-generated method stub
		Iterator it = chunk.flags.entrySet().iterator();
<<<<<<< HEAD
	    while (it.hasNext()) {
	        Map.Entry flag = (Map.Entry)it.next();
	        insertChunkFlags((String)chunk.getName(),(String)flag.getKey(),(Boolean)flag.getValue());
	    }
	}
	
	private static void insertChunkFlags(String chunkid, String flag, Boolean access){
		String sql = "insert into MSC_chunkflags (chunkid, falg,state)"
		        + " values (?, ?, ?)";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, chunkid);
			preparedStmt.setString (2, flag);		
			preparedStmt.setBoolean(2, access);			
			MySQL.insertDB(preparedStmt);								
=======
		while (it.hasNext()) {
			Map.Entry flag = (Map.Entry) it.next();
			insertChunkFlags((String) chunk.getName(), (String) flag.getKey(), (Boolean) flag.getValue());
		}
	}

	private static void insertChunkFlags(String chunkid, String flag, Boolean access) {
		String sql = "insert into MSC_chunkflags (chunkid, falg,state)" + " values (?, ?, ?)";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, chunkid);
			preparedStmt.setString(2, flag);
			preparedStmt.setBoolean(2, access);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	@SuppressWarnings("rawtypes")
	private static void saveChunkAccess(CustomChunk chunk) {
		// TODO Auto-generated method stub
		Iterator it = chunk.access.entrySet().iterator();
<<<<<<< HEAD
	    while (it.hasNext()) {
	        Map.Entry player = (Map.Entry)it.next();
	        insertChunkAccess((String)chunk.getName(),(UUID)player.getKey(),(Boolean)player.getValue());
	    }
	}
	
	private static void insertChunkAccess(String chunkid, UUID player, Boolean access){
		String sql = "insert into MSC_chunkaccess (chunkid, player,state)"
		        + " values (?, ?, ?)";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, chunkid);
			preparedStmt.setString(2, player.toString());		
			preparedStmt.setBoolean(2, access);			
			MySQL.insertDB(preparedStmt);								
=======
		while (it.hasNext()) {
			Map.Entry player = (Map.Entry) it.next();
			insertChunkAccess((String) chunk.getName(), (UUID) player.getKey(), (Boolean) player.getValue());
		}
	}

	private static void insertChunkAccess(String chunkid, UUID player, Boolean access) {
		String sql = "insert into MSC_chunkaccess (chunkid, player,state)" + " values (?, ?, ?)";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, chunkid);
			preparedStmt.setString(2, player.toString());
			preparedStmt.setBoolean(2, access);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	
	public static void insertChunkOwner(CustomChunk chunk){
		String sql = "insert into MCS_chunkowner (chunkid, ownerid,iscity,cityname,world,buyable,buyprice,isJail)"
		        + " values (?, ?, ?, ?,?,?,?,?)"
		        + " ON DUPLICATE KEY UPDATE ownerid=?, iscity=?, cityname=?, buyable=?, buyprice=?,isJail=?";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		if((chunk instanceof JailChunk)){
			ChunkHandler.saveCellSpawns((JailChunk) chunk);
		}
		try {
			preparedStmt.setString (1, chunk.getName());
			preparedStmt.setString (2, chunk.getOwner().toString());	
			preparedStmt.setInt (3, chunk.isCity()?1:0);
			preparedStmt.setString (4, chunk.getCityName());	
			preparedStmt.setString (5, chunk.getWorld());
			preparedStmt.setBoolean (6, chunk.isBuyAble());
			preparedStmt.setDouble (7, chunk.getPrice());	
			preparedStmt.setBoolean (8, chunk.getIsJail());	
			preparedStmt.setString (9, chunk.getOwner().toString());	
			preparedStmt.setInt (10, chunk.isCity()?1:0);	
			preparedStmt.setString (11, chunk.getCityName());	
			preparedStmt.setBoolean (12, chunk.isBuyAble());
			preparedStmt.setDouble (13, chunk.getPrice());	
			preparedStmt.setBoolean (14, chunk.getIsJail());	
			MySQL.insertDB(preparedStmt);								
=======

	public static void insertChunkOwner(CustomChunk chunk) {
		String sql = "insert into MCS_chunkowner (chunkid, ownerid,iscity,cityname,world,buyable,buyprice,isJail)"
				+ " values (?, ?, ?, ?,?,?,?,?)"
				+ " ON DUPLICATE KEY UPDATE ownerid=?, iscity=?, cityname=?, buyable=?, buyprice=?,isJail=?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		if ((chunk instanceof JailChunk)) {
			ChunkHandler.saveCellSpawns((JailChunk) chunk);
		}
		try {
			preparedStmt.setString(1, chunk.getName());
			preparedStmt.setString(2, chunk.getOwner().toString());
			preparedStmt.setInt(3, chunk.isCity() ? 1 : 0);
			preparedStmt.setString(4, chunk.getCityName());
			preparedStmt.setString(5, chunk.getWorld());
			preparedStmt.setBoolean(6, chunk.isBuyAble());
			preparedStmt.setDouble(7, chunk.getPrice());
			preparedStmt.setBoolean(8, chunk.getIsJail());
			preparedStmt.setString(9, chunk.getOwner().toString());
			preparedStmt.setInt(10, chunk.isCity() ? 1 : 0);
			preparedStmt.setString(11, chunk.getCityName());
			preparedStmt.setBoolean(12, chunk.isBuyAble());
			preparedStmt.setDouble(13, chunk.getPrice());
			preparedStmt.setBoolean(14, chunk.getIsJail());
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
<<<<<<< HEAD
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;
		Chunk chunk = p.getLocation().getChunk();
		
		if(cmd.getName().equalsIgnoreCase("gs")) {
			switch(args.length){
			case 1:
				if(args[0].equalsIgnoreCase("remove")){
					if(p.isOp()){
						ChunkHandler.unclaimChunk(p,0);
						return true;
					}
				} 
				return false;
			case 2:
				if(args[0].equalsIgnoreCase("add")){
					if(p.isOp()){
						ChunkHandler.claimChunk(Bukkit.getPlayer(args[1]),0.00);
						return true;
					}
				}
				return false;
			default: 
				ChunkHandler.markEdges(p);
				if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
					if(ChunkHandler.getOwnerName(chunk.toString())==null){
						if(p.isOp()){
							p.sendMessage("Grundstück " + chunk.toString() );
						}
						p.sendMessage("Grundstück gehört: unbekaannt" );
					}else
						p.sendMessage("Grundstück gehört: " + ChunkHandler.getOwnerName(chunk.toString()) );

					return true;
				}else{
					if(p.isOp()){
						p.sendMessage("Grundstück " + chunk.toString() );
						return true;
					}
					return false;
				}
=======
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if (!(sender instanceof Player)) {
			return false;
		}

		Player p = (Player) sender;
		Chunk chunk = p.getLocation().getChunk();

		if (cmd.getName().equalsIgnoreCase("gs")) {
			switch (args.length) {
				case 1:
					if (args[0].equalsIgnoreCase("remove")) {
						if (p.isOp()) {
							ChunkHandler.unclaimChunk(p, 0);
							return true;
						}
					}
					return false;
				case 2:
					if (args[0].equalsIgnoreCase("add")) {
						if (p.isOp()) {
							ChunkHandler.claimChunk(Bukkit.getPlayer(args[1]), 0.00);
							return true;
						}
					}
					return false;
				default:
					ChunkHandler.markEdges(p);
					if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
						if (ChunkHandler.getOwnerName(chunk.toString()) == null) {
							if (p.isOp()) {
								p.sendMessage("Grundstï¿½ck " + chunk.toString());
							}
							p.sendMessage("Grundstï¿½ck gehï¿½rt: unbekaannt");
						} else
							p.sendMessage("Grundstï¿½ck gehï¿½rt: " + ChunkHandler.getOwnerName(chunk.toString()));

						return true;
					} else {
						if (p.isOp()) {
							p.sendMessage("Grundstï¿½ck " + chunk.toString());
							return true;
						}
						return false;
					}
>>>>>>> b4ade11... add new directory
			}
		}
		return false;
	}

	public static void setAccess(Chunk chunk, Player player) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
=======
		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
>>>>>>> b4ade11... add new directory
			ChunkHandler.ownedChunks.get(chunk.toString()).getOwner();
		}
	}

	public static void removeAccess(Chunk chunk, Player player) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
=======
		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
>>>>>>> b4ade11... add new directory
			ChunkHandler.ownedChunks.get(chunk.toString()).getOwner();
		}
	}

	public static UUID getOwner(Chunk chunk) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
=======
		if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
>>>>>>> b4ade11... add new directory
			return ChunkHandler.ownedChunks.get(chunk.toString()).getOwner();
		}
		return null;
	}

	public static UUID getOwner(Player p) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())){
=======
		if (ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())) {
>>>>>>> b4ade11... add new directory
			return ChunkHandler.ownedChunks.get(p.getLocation().getChunk().toString()).getOwner();
		}
		return null;
	}

<<<<<<< HEAD

	public static void removeCity(Player p) {
		// TODO Auto-generated method stub
		String sql = "UPDATE MCS_chunkowner SET iscity=0, cityname=null WHERE ownerid=?";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, p.getUniqueId().toString());
			MySQL.insertDB(preparedStmt);								
=======
	public static void removeCity(Player p) {
		// TODO Auto-generated method stub
		String sql = "UPDATE MCS_chunkowner SET iscity=0, cityname=null WHERE ownerid=?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, p.getUniqueId().toString());
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		
=======

>>>>>>> b4ade11... add new directory
	}
}
