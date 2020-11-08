package de.mcsocial.city;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.admin.AdminPlayer;
import de.mcsocial.books.WelcomeBook;
import de.mcsocial.chat.Channel;
import de.mcsocial.cheatprotection.Miner;
import de.mcsocial.economy.Account;
import de.mcsocial.economy.Jobs;
import de.mcsocial.economy.Market;
import de.mcsocial.main.MCSocial;
import de.mcsocial.main.MySQL;
import de.mcsocial.permissions.PlayerPermissions;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.CustomChunk;
import de.mcsocial.skills.SkillListener;
import de.mcsocial.tracker.VoteTracker;
import de.mcsocial.trader.TraderHandler;

public class Resident implements Listener {
<<<<<<< HEAD
	
	@EventHandler
	public void on(PlayerTeleportEvent e){
=======

	@EventHandler
	public void on(PlayerTeleportEvent e) {
>>>>>>> b4ade11... add new directory
		if ((e.getCause() == TeleportCause.ENDER_PEARL)) {
			e.setCancelled(true);
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	// Events outside of onCommand
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		event.setDeathMessage(null);
	}
<<<<<<< HEAD
	
	@EventHandler
	public void onExplosion(EntityExplodeEvent e){
		if(e.getEntity().getType() == EntityType.PRIMED_TNT){
			e.setCancelled(true);
		}
	}
	/**
	 * Prevent PvP and PvM damage dependent upon PvP settings and location.
	 * 
=======

	@EventHandler
	public void onExplosion(EntityExplodeEvent e) {
		if (e.getEntity().getType() == EntityType.PRIMED_TNT) {
			e.setCancelled(true);
		}
	}

	/**
	 * Prevent PvP and PvM damage dependent upon PvP settings and location.
	 *
>>>>>>> b4ade11... add new directory
	 * @param event
	 */
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onEntityDamageByEntity(EntityDamageEvent event) {
<<<<<<< HEAD
		if(!ChunkHandler.isClaimAble(event.getEntity().getLocation().getChunk())){
			
			Chunk chunk = event.getEntity().getLocation().getChunk();
			
			if (event.getEntity() instanceof Player){
				event.setCancelled(true);
				return;
			}
			
			if (event instanceof EntityDamageByEntityEvent){
				Player damager = null;
				EntityDamageByEntityEvent edbye = (EntityDamageByEntityEvent) event;
				
				 if (edbye.getDamager() instanceof Player){
					damager = (Player) edbye.getDamager();
					
					if(ChunkHandler.ownedChunks == null)
					{
						ChunkHandler.ownedChunks = new HashMap<String,CustomChunk>();
					}
					if(damager.isOp()){
						return;
					}
					
					if(PlayerPermissions.hasAccess(damager,"supporter")){
						return;
					}
					
					if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
						CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());	
						
						if(cChunk.getOwner().equals(damager.getUniqueId())){
							return;
						}
						
						if(cChunk.hasAccess(damager.getUniqueId())){
=======
		if (!ChunkHandler.isClaimAble(event.getEntity().getLocation().getChunk())) {

			Chunk chunk = event.getEntity().getLocation().getChunk();

			if (event.getEntity() instanceof Player) {
				event.setCancelled(true);
				return;
			}

			if (event instanceof EntityDamageByEntityEvent) {
				Player damager = null;
				EntityDamageByEntityEvent edbye = (EntityDamageByEntityEvent) event;

				if (edbye.getDamager() instanceof Player) {
					damager = (Player) edbye.getDamager();

					if (ChunkHandler.ownedChunks == null) {
						ChunkHandler.ownedChunks = new HashMap<String, CustomChunk>();
					}
					if (damager.isOp()) {
						return;
					}

					if (PlayerPermissions.hasAccess(damager, "supporter")) {
						return;
					}

					if (ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
						CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());

						if (cChunk.getOwner().equals(damager.getUniqueId())) {
							return;
						}

						if (cChunk.hasAccess(damager.getUniqueId())) {
>>>>>>> b4ade11... add new directory
							return;
						}
					}

					event.setCancelled(true);
<<<<<<< HEAD
					
=======

>>>>>>> b4ade11... add new directory
				}
			}
			event.setCancelled(true);
			return;
		}
	}
<<<<<<< HEAD
			
=======

>>>>>>> b4ade11... add new directory
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

<<<<<<< HEAD
		if( ChunkHandler.lastChunk == null)
			 ChunkHandler.lastChunk = new HashMap<String, Chunk>();
		
		final Player player = event.getPlayer();
		Location loc = player.getLocation();
		final Chunk chunk = loc.getChunk();
		if( ChunkHandler.lastChunk.containsKey(player.getName()) ){
			int seconds = 3;
			 
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MCSocial.instance, new Runnable() {
			     public void run() {
			          // code to run when the time is up.
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
	                        if(corner1.getBlock().getType() == Material.AIR){player.sendBlockChange(corner1, Material.AIR, (byte) 0);}
	                        if(corner2.getBlock().getType() == Material.AIR){player.sendBlockChange(corner2, Material.AIR, (byte) 0);}
	                        if(corner3.getBlock().getType() == Material.AIR){player.sendBlockChange(corner3, Material.AIR, (byte) 0);}
	                        if(corner4.getBlock().getType() == Material.AIR){player.sendBlockChange(corner4, Material.AIR, (byte) 0);}
	                    }
	                 }
	                 ChunkHandler.lastChunk.remove(player.getName());
			     }
			}, (seconds * 20)); // Always multiply by twenty because that's the amount of ticks in Minecraft
			 
                 
		} 
	}	
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		if(AdminPlayer.bannedPlayer != null){
			if(AdminPlayer.bannedPlayer.containsKey(p.getUniqueId())){
				if(System.currentTimeMillis() < AdminPlayer.bannedPlayer.get(p.getUniqueId())){
					p.kickPlayer("Du bist noch gebannt.");
				}
			}
			
		}
		
		//fixOpenPlayer(p);
		
		if(!p.hasPlayedBefore()) {
=======
		if (ChunkHandler.lastChunk == null)
			ChunkHandler.lastChunk = new HashMap<String, Chunk>();

		final Player player = event.getPlayer();
		Location loc = player.getLocation();
		final Chunk chunk = loc.getChunk();
		if (ChunkHandler.lastChunk.containsKey(player.getName())) {
			int seconds = 3;

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MCSocial.instance, new Runnable() {
				public void run() {
					// code to run when the time is up.
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
								player.sendBlockChange(corner1, Material.AIR, (byte) 0);
							}
							if (corner2.getBlock().getType() == Material.AIR) {
								player.sendBlockChange(corner2, Material.AIR, (byte) 0);
							}
							if (corner3.getBlock().getType() == Material.AIR) {
								player.sendBlockChange(corner3, Material.AIR, (byte) 0);
							}
							if (corner4.getBlock().getType() == Material.AIR) {
								player.sendBlockChange(corner4, Material.AIR, (byte) 0);
							}
						}
					}
					ChunkHandler.lastChunk.remove(player.getName());
				}
			}, (seconds * 20)); // Always multiply by twenty because that's the amount of ticks in Minecraft

		}
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();

		if (AdminPlayer.bannedPlayer != null) {
			if (AdminPlayer.bannedPlayer.containsKey(p.getUniqueId())) {
				if (System.currentTimeMillis() < AdminPlayer.bannedPlayer.get(p.getUniqueId())) {
					p.kickPlayer("Du bist noch gebannt.");
				}
			}

		}

		if (!p.hasPlayedBefore()) {
>>>>>>> b4ade11... add new directory
			Account.create(p);
			Resident.create(p);
			p.setMetadata("newPlayer", new FixedMetadataValue(MCSocial.instance, true));
			p.getInventory().addItem(new WelcomeBook().getBook());
		}
<<<<<<< HEAD
				
		Resident.initPlayer(p);
		PlayerPermissions.initPlayerPermission(p);		
=======

		fixOpenPlayer(p);
		PlayerPermissions.initPlayerPermission(p);
>>>>>>> b4ade11... add new directory
		Resident.setChat(p);
		Resident.create(p);

		getCityOwner(p);
		getCityResident(p);
		getMoney(p);
<<<<<<< HEAD
		
	}
	
	private void bugFixUpdateAccount(String uuidNew, String uuidOld){
		String sql = "UPDATE MCS_account SET player = ? WHERE player = ? ";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, uuidNew );
			preparedStmt.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt);								
=======

	}

	private void bugFixUpdateAccount(String uuidNew, String uuidOld) {
		String sql = "UPDATE MCS_account SET player = ? WHERE player = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, uuidNew);
			preparedStmt.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private void bugFixUpdateCity(String uuidNew, String uuidOld){
		String sql = "UPDATE MCS_city SET owner = ? WHERE owner = ? ";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, uuidNew );
			preparedStmt.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt);								
=======

	private void bugFixUpdateCity(String uuidNew, String uuidOld) {
		String sql = "UPDATE MCS_city SET owner = ? WHERE owner = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, uuidNew);
			preparedStmt.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private void bugFixUpdateCityRes(String uuidNew, String uuidOld){
		String sql = "UPDATE MCS_city_resident SET player = ? WHERE player = ? ";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, uuidNew );
			preparedStmt.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt);								
=======

	private void bugFixUpdateCityRes(String uuidNew, String uuidOld) {
		String sql = "UPDATE MCS_city_resident SET player = ? WHERE player = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, uuidNew);
			preparedStmt.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		String sql2 = "UPDATE MCS_city_resident SET name = ? WHERE name = ? ";
		
		PreparedStatement preparedStmt2 = MySQL.getPreStat(sql2);
		
		try {
			preparedStmt2.setString (1, uuidNew );
			preparedStmt2.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt2);								
=======

		String sql2 = "UPDATE MCS_city_resident SET name = ? WHERE name = ? ";

		PreparedStatement preparedStmt2 = MySQL.getPreStat(sql2);

		try {
			preparedStmt2.setString(1, uuidNew);
			preparedStmt2.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt2);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private void bugFixUpdateChunks(String uuidNew, String uuidOld){
		String sql = "UPDATE MCS_chunkowner SET ownerid = ? WHERE ownerid = ? ";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, uuidNew );
			preparedStmt.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt);								
=======

	private void bugFixUpdateChunks(String uuidNew, String uuidOld) {
		String sql = "UPDATE MCS_chunkowner SET ownerid = ? WHERE ownerid = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, uuidNew);
			preparedStmt.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private void bugFixUpdateProfil(String uuidNew, String uuidOld){
		String sql = "UPDATE MCS_player SET uuid = ? WHERE uuid = ? ";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, uuidNew );
			preparedStmt.setString (2, uuidOld);		
			MySQL.insertDB(preparedStmt);								
=======

	private void bugFixUpdateProfil(String uuidNew, String uuidOld) {
		String sql = "UPDATE MCS_player SET uuid = ? WHERE uuid = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, uuidNew);
			preparedStmt.setString(2, uuidOld);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	@SuppressWarnings("unused")
	private void fixOpenPlayer(Player p){
=======

	@SuppressWarnings("unused")
	private void fixOpenPlayer(Player p) {
>>>>>>> b4ade11... add new directory
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT * FROM MCS_player WHERE name=?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, p.getName().toString());
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			while(result.next()){
				if( result.getString("uuid").equalsIgnoreCase(p.getUniqueId().toString()) )continue;
				
				Miner.saveMinerData();
				Market.savePrices();
				SkillListener.saveSkills();	
				VoteTracker.onDisable();
				TraderHandler.onDisable();
				City.saveAllVillager();
				
				bugFixUpdateProfil( p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateAccount( p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateCity( p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateCityRes( p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateChunks( p.getUniqueId().toString(), result.getString("uuid"));
				
				TraderHandler.loadShops();
				Miner.loadMinerData();
				City.loadAllCitys();
				City.loadAllVillager();	
=======
			while (result.next()) {
				if (result.getString("uuid").equalsIgnoreCase(p.getUniqueId().toString()))
					continue;

				Miner.saveMinerData();
				Market.savePrices();
				SkillListener.saveSkills();
				VoteTracker.onDisable();
				TraderHandler.onDisable();
				City.saveAllVillager();

				bugFixUpdateProfil(p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateAccount(p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateCity(p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateCityRes(p.getUniqueId().toString(), result.getString("uuid"));
				bugFixUpdateChunks(p.getUniqueId().toString(), result.getString("uuid"));

				TraderHandler.loadShops();
				Miner.loadMinerData();
				City.loadAllCitys();
				City.loadAllVillager();
>>>>>>> b4ade11... add new directory
				Market.loadPrices();
				Jobs.loadJobs();
				initPlayer(p);
			}
<<<<<<< HEAD
		}catch (SQLException e) {
=======
		} catch (SQLException e) {
>>>>>>> b4ade11... add new directory
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private static void setChat(Player p) {
		// TODO Auto-generated method stub
		if((p.hasMetadata("isAdmin") && p.getMetadata("isAdmin").get(0).asBoolean()) ){
			Channel.join(p,"Admin");
		}
		if(
			(p.hasMetadata("isModerator") && p.getMetadata("isModerator").get(0).asBoolean())
				||
			(p.hasMetadata("isSupporter") && p.getMetadata("isSupporter").get(0).asBoolean())
		){

			Channel.join(p,"Support");
		}	
		Channel.join(p,"Lokal");
		Channel.join(p,"Handel");
		Channel.join(p,"Global");
	}

	@EventHandler
	public void onPlayerLeft(PlayerQuitEvent event){
		Account.create(event.getPlayer());
		Resident.create(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerLeft(PlayerKickEvent event){
		Account.create(event.getPlayer());
		Resident.create(event.getPlayer());
	}
	
	private static void initPlayer(Player p){
=======

	private static void setChat(Player p) {
		// TODO Auto-generated method stub
		if ((p.hasMetadata("isAdmin") && p.getMetadata("isAdmin").get(0).asBoolean())) {
			Channel.join(p, "Admin");
		}
		if ((p.hasMetadata("isModerator") && p.getMetadata("isModerator").get(0).asBoolean())
				|| (p.hasMetadata("isSupporter") && p.getMetadata("isSupporter").get(0).asBoolean())) {

			Channel.join(p, "Support");
		}
		Channel.join(p, "Lokal");
		Channel.join(p, "Handel");
		Channel.join(p, "Global");
	}

	@EventHandler
	public void onPlayerLeft(PlayerQuitEvent event) {
		Account.create(event.getPlayer());
		Resident.create(event.getPlayer());
	}

	@EventHandler
	public void onPlayerLeft(PlayerKickEvent event) {
		Account.create(event.getPlayer());
		Resident.create(event.getPlayer());
	}

	private static void initPlayer(Player p) {
>>>>>>> b4ade11... add new directory
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT * FROM MCS_player WHERE uuid = ?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, p.getUniqueId().toString());
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
=======

>>>>>>> b4ade11... add new directory
			p.removeMetadata("isSupporter", MCSocial.instance);
			p.removeMetadata("isModerator", MCSocial.instance);
			p.removeMetadata("isAdmin", MCSocial.instance);
			p.removeMetadata("isDonator", MCSocial.instance);
			p.removeMetadata("job", MCSocial.instance);
			p.removeMetadata("folk", MCSocial.instance);
			p.removeMetadata("nation", MCSocial.instance);
			p.removeMetadata("lastJobChange", MCSocial.instance);
			p.removeMetadata("channel", MCSocial.instance);
<<<<<<< HEAD
			
			while(result.next()){
=======

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				p.setMetadata("isSupporter", new FixedMetadataValue(MCSocial.instance, result.getBoolean("isSupporter")));
				p.setMetadata("isModerator", new FixedMetadataValue(MCSocial.instance, result.getBoolean("isModerator")));
				p.setMetadata("isAdmin", new FixedMetadataValue(MCSocial.instance, result.getBoolean("isAdmin")));
				p.setMetadata("isDonator", new FixedMetadataValue(MCSocial.instance, result.getBoolean("isDonator")));
<<<<<<< HEAD
				
				if(result.getString("job") != null){
					p.setMetadata("job", new FixedMetadataValue(MCSocial.instance, result.getString("job")));
				}
				if(result.getString("folk") != null){
					p.setMetadata("folk", new FixedMetadataValue(MCSocial.instance, result.getString("folk")));
					p.setDisplayName(result.getString("folk") + " " + p.getName());
				}
				if(result.getString("nation") != null){
					p.setMetadata("nation", new FixedMetadataValue(MCSocial.instance, result.getString("nation")));
				}
				if(result.getString("lastJobChange") != null){
=======

				if (result.getString("job") != null) {
					p.setMetadata("job", new FixedMetadataValue(MCSocial.instance, result.getString("job")));
				}
				if (result.getString("folk") != null) {
					p.setMetadata("folk", new FixedMetadataValue(MCSocial.instance, result.getString("folk")));
					p.setDisplayName(result.getString("folk") + " " + p.getName());
				}
				if (result.getString("nation") != null) {
					p.setMetadata("nation", new FixedMetadataValue(MCSocial.instance, result.getString("nation")));
				}
				if (result.getString("lastJobChange") != null) {
>>>>>>> b4ade11... add new directory
					p.setMetadata("lastJobChange", new FixedMetadataValue(MCSocial.instance, result.getLong("lastJobChange")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	public static void create(Player player) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "insert ignore into MCS_player (name, uuid)"
		        + " values (?, ?)"
		        + " ON DUPLICATE KEY UPDATE job= ?, lastJobChange=?, folk=?, lastlogin=NOW()";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, player.getName());
			preparedStmt.setString (2, player.getUniqueId().toString());	
			preparedStmt.setString (3, player.hasMetadata("job")?player.getMetadata("job").get(0).asString():null);	
			preparedStmt.setLong (4, player.hasMetadata("lastJobChange")?player.getMetadata("lastJobChange").get(0).asLong():0);
			preparedStmt.setString (5, player.hasMetadata("folk")?player.getMetadata("folk").get(0).asString():null);				
			MySQL.insertDB(preparedStmt);								
=======

	public static void create(Player player) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "insert ignore into MCS_player (name, uuid)" + " values (?, ?)"
				+ " ON DUPLICATE KEY UPDATE job= ?, lastJobChange=?, folk=?, lastlogin=NOW()";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, player.getName());
			preparedStmt.setString(2, player.getUniqueId().toString());
			preparedStmt.setString(3, player.hasMetadata("job") ? player.getMetadata("job").get(0).asString() : null);
			preparedStmt.setLong(4,
					player.hasMetadata("lastJobChange") ? player.getMetadata("lastJobChange").get(0).asLong() : 0);
			preparedStmt.setString(5, player.hasMetadata("folk") ? player.getMetadata("folk").get(0).asString() : null);
			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	@SuppressWarnings("deprecation")
	public static void onEnable(){
		for(Player pl: Bukkit.getOnlinePlayers()){		
			if(pl == null) {
				//System.out.println("Spieler existiert nicht");
				continue;
			}
			
			Resident.initPlayer(pl);
			PlayerPermissions.initPlayerPermission(pl);			
			Resident.setChat(pl);
			
		}	
=======

	public static void onEnable() {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (pl == null) {
				// System.out.println("Spieler existiert nicht");
				continue;
			}

			Resident.initPlayer(pl);
			PlayerPermissions.initPlayerPermission(pl);
			Resident.setChat(pl);

		}
>>>>>>> b4ade11... add new directory
	}

	private void getCityOwner(Player p) {
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT name FROM MCS_city WHERE owner = ?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, p.getUniqueId().toString());
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
			while(result.next()){
=======

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				p.setMetadata("cityowner", new FixedMetadataValue(MCSocial.instance, result.getString("name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	private void getCityResident(Player p) {
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT name FROM MCS_city_resident WHERE player = ?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, p.getUniqueId().toString());
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
			while(result.next()){
=======

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, result.getString("name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	private void getMoney(Player p) {
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT balance FROM MCS_account WHERE player = ?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, p.getUniqueId().toString());
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
			while(result.next()){
=======

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				p.setMetadata("account", new FixedMetadataValue(MCSocial.instance, result.getDouble("balance")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getName(UUID owner) {
		// TODO Auto-generated method stub
		Player p = Bukkit.getPlayer(owner);
		return p.getName();
	}

	public static void removeFolk(Player p) {
		// TODO Auto-generated method stub
		p.removeMetadata("folk", MCSocial.instance);
		Resident.create(p);
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	public static void addFolk(Player p, String string) {
		// TODO Auto-generated method stub
		p.setMetadata("folk", new FixedMetadataValue(MCSocial.instance, string));
		Resident.create(p);
	}

	public static void removeNation(Player p) {
		// TODO Auto-generated method stub
		p.removeMetadata("nation", MCSocial.instance);
		Resident.create(p);
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
	public static void addNation(Player p, String string) {
		// TODO Auto-generated method stub
		p.setMetadata("nation", new FixedMetadataValue(MCSocial.instance, string));
		Resident.create(p);
	}

	public static void removeJob(Player p) {
		// TODO Auto-generated method stub
		p.removeMetadata("job", MCSocial.instance);
		Resident.create(p);
	}
<<<<<<< HEAD
	
	public static void addJob(Player p, String string) {
		// TODO Auto-generated method stub
		p.setMetadata("job", new FixedMetadataValue(MCSocial.instance, string));
		p.setMetadata("lastJobChange", new FixedMetadataValue(MCSocial.instance,System.currentTimeMillis()));
=======

	public static void addJob(Player p, String string) {
		// TODO Auto-generated method stub
		p.setMetadata("job", new FixedMetadataValue(MCSocial.instance, string));
		p.setMetadata("lastJobChange", new FixedMetadataValue(MCSocial.instance, System.currentTimeMillis()));
>>>>>>> b4ade11... add new directory
		Resident.create(p);
	}
}
