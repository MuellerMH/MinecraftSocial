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

public class ChunkHandler implements Listener,CommandExecutor {

	public static Material edgeID = Material.WOOL;
	public static Material edgeIDRemove = Material.AIR;	
	public static HashMap<String,Chunk> lastChunk = new HashMap<String,Chunk>();	
	public static HashMap<String,CustomChunk> ownedChunks = null;
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
		
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				return;
			}
			
			if(Jail.isJailChunks(chunk)){
				return;
			}
			
			if(cChunk.getCityName().equalsIgnoreCase("worldspawn")){
				if(event.getRightClicked().isCustomNameVisible())
					return;
			}
			
			if(cChunk.isCity()){
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getCityName())){	
					
					if(City.isVillager(player.getUniqueId(), cChunk.getCityName())){
						return;
					}
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
			return false;
		}
		return true;
	}
	
	public static Boolean isClaimAble(Player p) {
		if(ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())){
			return false;
		}
		return true;
	}

	public static void unclaimChunk(Player p, double price) {
		// TODO Auto-generated method stub
		Chunk chunk = p.getLocation().getChunk();

		if(!ChunkHandler.ownedChunks.containsKey(chunk.toString())){
			return;
		}
			
		if(ChunkHandler.getOwner(chunk) != null){
			if(!ChunkHandler.getOwner(chunk).equals(p.getUniqueId())){
				return;
			}
		}
		
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CustomChunk getChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString()))
			return ChunkHandler.ownedChunks.get(chunk.toString());
		return null;
	}

	public static void claimJailChunk(Player p, Double price){

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
		Jail.setJailChunks(cChunk);
		ChunkHandler.save(cChunk);
		Account.remove(p, price);
	}

	public static void claimChunk(Player p, Double price){

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
			return chunk.getCityName();
		else
			return Bukkit.getPlayer(chunk.getOwner()).getName();
	}
	
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
				}
				name = ChunkHandler.ownedChunksResult.getString("chunkid");
				ownerIsCity = ChunkHandler.ownedChunksResult.getBoolean("iscity");
				cityname = ChunkHandler.ownedChunksResult.getString("cityname");
				isJail = ChunkHandler.ownedChunksResult.getBoolean("isJail");
				
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent event) {
		Block block = event.getBlock();
		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();
		
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
		
				
		switch(block.getType()){
		
		case AIR:		
		case APPLE:			
		case BAKED_POTATO:
		case BOAT:
		case BOOK_AND_QUILL:
		case BREAD:
		case CAKE:
		case CARROT:
		case COMPASS:
		case COOKED_BEEF:
		case COOKED_CHICKEN:
		case COOKED_FISH:
		case COOKED_MUTTON:
		case COOKED_RABBIT:
		case COOKIE:
		case GOLDEN_APPLE:
		case GOLDEN_CARROT:
		case GRILLED_PORK:
		case MUSHROOM_SOUP:
		case RABBIT_FOOT:
			event.setCancelled(false);
			return;
		default:
			break;
		
		}

		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.isCity()){
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getCityName())){					
					if(City.isVillager(player.getUniqueId(), cChunk.getCityName())){
						return;
					}
				}				
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();

		
		
		
		switch(block.getType()){
		
		case AIR:		
		case APPLE:			
		case BAKED_POTATO:
		case BOAT:
		case BOOK_AND_QUILL:
		case BREAD:
		case CAKE:
		case CARROT:
		case COMPASS:
		case COOKED_BEEF:
		case COOKED_CHICKEN:
		case COOKED_FISH:
		case COOKED_MUTTON:
		case COOKED_RABBIT:
		case COOKIE:
		case GOLDEN_APPLE:
		case GOLDEN_CARROT:
		case GRILLED_PORK:
		case MUSHROOM_SOUP:
		case RABBIT_FOOT:
			event.setCancelled(false);
			return;
		default:
			break;
		
		}
		Chunk chunk = block.getLocation().getChunk();
		Player player = event.getPlayer();
		
		if(player.isOp())
			return;
		
		if(PlayerPermissions.hasAccess(player,"supporter"))
			return;
		
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
			CustomChunk cChunk = ChunkHandler.ownedChunks.get(chunk.toString());
			
			if(cChunk.getOwner().equals(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.hasAccess(player.getUniqueId())) {
				return;
			}
			
			if(cChunk.isCity()){
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getCityName())){					
					if(City.isVillager(player.getUniqueId(), cChunk.getCityName())){
						return;
					}
				}				
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
			event.setCancelled(true);
		}
	}
	
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
		Block block = event.getClickedBlock();		
		
		if(block == null)
			return;
		
		if(ChunkHandler.ownedChunks == null)
			return;
		
		if(block.getType().equals(Material.AIR))
			return;
		
		switch(block.getType()){
		
		case AIR:		
		case APPLE:			
		case BAKED_POTATO:
		case BOAT:
		case BOOK_AND_QUILL:
		case BREAD:
		case CAKE:
		case CARROT:
		case COMPASS:
		case COOKED_BEEF:
		case COOKED_CHICKEN:
		case COOKED_FISH:
		case COOKED_MUTTON:
		case COOKED_RABBIT:
		case COOKIE:
		case GOLDEN_APPLE:
		case GOLDEN_CARROT:
		case GRILLED_PORK:
		case MUSHROOM_SOUP:
		case RABBIT_FOOT:
			event.setUseInteractedBlock(Result.ALLOW);
			event.setUseItemInHand(Result.ALLOW);
			return;
		default:
			break;
		
		}
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
				//TODO: if player in City?
				if(City.cityList.containsKey(cChunk.getCityName())){
					
					
					if(City.isVillager(player.getUniqueId(), cChunk.getCityName())){
						return;
					}
				}				
			}
			player.sendMessage("Du besitzt keine Berechtigungen auf diesem Grundstück.");
			event.setUseInteractedBlock(Result.DENY);
			event.setUseItemInHand(Result.ALLOW);
		}
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

	public static void save(CustomChunk chunk) {
		// TODO Auto-generated method stub

	        saveChunkAccess(chunk);
	        saveChunkFlags(chunk);
	        insertChunkOwner(chunk);
	}
	
	@SuppressWarnings("rawtypes")
	private static void saveChunkFlags(CustomChunk chunk) {
		// TODO Auto-generated method stub
		Iterator it = chunk.flags.entrySet().iterator();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void saveChunkAccess(CustomChunk chunk) {
		// TODO Auto-generated method stub
		Iterator it = chunk.access.entrySet().iterator();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("gs")) {
			switch(args.length){
			default: 
				ChunkHandler.markEdges(p);
				Chunk chunk = p.getLocation().getChunk();
				if(ChunkHandler.ownedChunks.containsKey(chunk.toString())) {
					if(ChunkHandler.getOwnerName(chunk.toString())==null)
						p.sendMessage("Grundstück gehört: unbekaannt" );
					else
						p.sendMessage("Grundstück gehört: " + ChunkHandler.getOwnerName(chunk.toString()) );
				}
				break;
			}
		}
		return false;
	}

	public static UUID getOwner(Chunk chunk) {
		// TODO Auto-generated method stub
		if(ChunkHandler.ownedChunks.containsKey(chunk.toString())){
			return ChunkHandler.ownedChunks.get(chunk.toString()).getOwner();
		}
		return null;
	}

	public static UUID getOwner(Player p) {
		// TODO Auto-generated method stub
		if(ChunkHandler.ownedChunks.containsKey(p.getLocation().getChunk().toString())){
			return ChunkHandler.ownedChunks.get(p.getLocation().getChunk().toString()).getOwner();
		}
		return null;
	}
}
