package de.mcsocial.city;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.main.MCSocial;
import de.mcsocial.main.MySQL;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.CustomChunk;

public class City {
	
	public static HashMap<UUID,City> cityList=null;
	public static ResultSet CityListResult=null;
	public static HashMap<UUID,City> residentList;
	
	private String name;
	private UUID owner;
	private Location loc;

	public void create(Player p, String arg1) {
		String sql = "insert into MCS_city (name, owner, x, y, z)"
		        + " values (?, ?, ?, ?, ?)";

		Chunk chunk = p.getLocation().getChunk();
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, arg1);
			preparedStmt.setString (2, p.getUniqueId().toString());
			preparedStmt.setLong (3, (int)p.getLocation().getX());
			preparedStmt.setLong (4, (int)p.getLocation().getY());
			preparedStmt.setLong (5, (int)p.getLocation().getZ());

			Location loc = new Location(p.getLocation().getWorld(),p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ());

			City city = new City(p.getUniqueId(),arg1,loc);
			
			City.cityList.put(city.owner,city);	
			
			p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, city.name));
			p.setMetadata("cityowner", new FixedMetadataValue(MCSocial.instance, true));
			
			City.residentList.put(city.owner,city);	
			
			CustomChunk cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(),true,city.name);
			
			ChunkHandler.ownedChunks.put(chunk.toString(),cChunk);	
			ChunkHandler.save(cChunk);
			
			MySQL.insertDB(preparedStmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	public void add(Player p, City city){
		p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, city));	
		City.residentList.put(p.getUniqueId(),city);
	}
	
	public void leave(Player p, City city){
		p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, city));	
		City.residentList.put(p.getUniqueId(),city);
	}
	
	public void remove(Player p, City city){
		p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, city));	
		City.residentList.put(p.getUniqueId(),city);
	}
	
	public void delete() {
		
	}
	
	public void rename() {
		
	}
	
	public void stats() {
		
	}
	
	public String getName() {
		return this.name;
	}

	
	public UUID getOwner() {
		
		return this.owner;
	}

	public static boolean isVillager(UUID playerID, String city){
		return City.residentList.containsKey(playerID) && City.residentList.get(playerID).getName() == city;
	}
	
	public Location getLoc() {
		return this.loc;
	}
	
	public City () {
		loadAllCitys();
	}
	
	public City(UUID owner, String name, Location loc2) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.owner = owner;
		this.loc = loc2;
	}

	public void loadAllVillager(){
		
	}
	
	@SuppressWarnings("deprecation")
	public void loadAllCitys(){
		
		if(cityList != null)
			return;
		
		City.cityList = new HashMap<UUID,City>();

		City.residentList = new HashMap<UUID,City>();
		
		try {		
			if(City.CityListResult == null) {
				City.CityListResult = MySQL.callDB("SELECT name,owner,x,y,z,resident FROM MCS_city ORDER BY name asc;");	
			}
			while(City.CityListResult.next()){
				City city = new City();
				city.loc = new Location(Bukkit.getWorld("world"),City.CityListResult.getInt("x"),City.CityListResult.getInt("y"),City.CityListResult.getInt("z"));
				UUID playerUUID;
				try{
					playerUUID = UUID.fromString( City.CityListResult.getString( "owner" ) );
				}catch(Exception e){
					playerUUID = Bukkit.getOfflinePlayer(City.CityListResult.getString( "owner" )).getUniqueId();
				}
				city.owner = playerUUID;
				city.name = City.CityListResult.getString("name");
				City.cityList.put(playerUUID,city);
				City.residentList.put(playerUUID,city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void save() {
		// TODO Auto-generated method stub
		
	}

	public static boolean isVillager(UUID uniqueId) {
		// TODO Auto-generated method stub
		return City.residentList.containsKey(uniqueId);
	}
}
