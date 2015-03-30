package de.mcsocial.city;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.gui.Menus.CityManagerMenu;
import de.mcsocial.gui.items.CityManagerItem;
import de.mcsocial.main.MCSocial;
import de.mcsocial.main.MySQL;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.CustomChunk;

public class City {
	
	public static HashMap<UUID,City> cityList=null;
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
			
			City.cityList.put(city.getOwner(),city);	
			
			p.setMetadata("city", new FixedMetadataValue(MCSocial.instance, city.owner));
			p.setMetadata("cityowner", new FixedMetadataValue(MCSocial.instance, true));
			
			City.residentList.put(city.getOwner(),city);	
			
			CustomChunk cChunk = new CustomChunk(chunk.toString(), p.getUniqueId(),true,city.name);
			
			ChunkHandler.ownedChunks.put(chunk.toString(),cChunk);	
			ChunkHandler.save(cChunk);
			
			MySQL.insertDB(preparedStmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	public static void add(Player p, City city){
		if(City.residentList == null){
			City.residentList = new HashMap<UUID,City>();
		}
		p.setMetadata("city", new FixedMetadataValue(MCSocial.instance,  city.getOwner()));	
		City.residentList.put(p.getUniqueId(),city);
		//system.out.println("Spieler "+p.getName()+" wurde der Stadt "+city.getName()+" hinzugefügt.");
	}
	
	public static void leave(Player p, City city){
		if(!city.getOwner().equals(p.getUniqueId())){
			p.sendMessage("Du bist der Lehsnherr dieser Stadt, du kannst sie nicht verlassen.");
			return;
		}
		if(City.residentList == null)return;
		if(!City.residentList.containsKey(p.getUniqueId()))return;
		p.removeMetadata("city", MCSocial.instance);
		City.residentList.remove(p.getUniqueId());
	}
	
	public static void remove(Player p, City city){
		if(City.residentList == null)return;
		if(!City.residentList.containsKey(p.getUniqueId()))return;
		p.removeMetadata("city", MCSocial.instance);	
		City.residentList.remove(p.getUniqueId());
		//system.out.println("Spieler "+p.getName()+" wurde aus der Stadt "+city.getName()+" entfernt.");
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

	public static boolean isVillager(UUID playerID, UUID city){
		System.out.println(City.residentList.toString());
		try{
		if(City.residentList == null)
			City.loadAllVillager();
		if(City.residentList.containsKey(playerID)){
			System.out.println("IS IN LIST " + City.residentList.get(playerID).getOwner() + " " + city);
			if(City.residentList.get(playerID).getOwner().equals(city)){
				return true;
			}
		}
		}catch(Exception e){
			return false;
		}
		return false;
	}
	
	public Location getLoc() {
		return this.loc;
	}
	
	public City () {
		City.loadAllCitys();
		City.loadAllVillager();
	}
	
	public City(UUID owner, String name, Location loc2) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.owner = owner;
		this.loc = loc2;
	}

	public static void loadAllVillager(){		
		if(City.residentList == null)
			City.residentList = new HashMap<UUID,City>();
		try {		
			
			ResultSet result = MySQL.callDB("SELECT name,player FROM MCS_city_resident;");	
			
			while(result.next()){
				UUID playerUUID;
				try{
					playerUUID = UUID.fromString( result.getString( "player" ) );
				}catch(Exception e){
					playerUUID = Bukkit.getOfflinePlayer(result.getString( "player" )).getUniqueId();
				}
				try{
					UUID owner = UUID.fromString(result.getString("name"));
					City city = City.cityList.get(owner);
					City.residentList.put(playerUUID,city);
				} catch(IllegalArgumentException e){
					continue;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void debug(){
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while(allResidents.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allResidents.next();
			//system.out.println(pair.getKey() +  ": " + ((City)pair.getValue()).getName() +" - " + pair.getValue().toString());
		}
		//system.out.println(City.residentList.toString());
	}

	public static void saveAllVillager(){
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while(allResidents.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allResidents.next();
			
			
			
			String sql = "insert ignore into MCS_city_resident (name, player)"
			        + " values (?, ?)";

			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			
			try {
				preparedStmt.setString (1, ((City)pair.getValue()).getOwner().toString());
				preparedStmt.setString (2, pair.getKey().toString());
					
				MySQL.insertDB(preparedStmt);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			City.cityList=null;
			City.residentList=null;
		}	
	}
	
	@SuppressWarnings("deprecation")
	public static void loadAllCitys(){

		if(City.cityList == null)
			City.cityList = new HashMap<UUID,City>();
		else
			return;
		if(City.residentList == null)
			City.residentList = new HashMap<UUID,City>();
		
		try {		
			ResultSet result = MySQL.callDB("SELECT name,owner,x,y,z,resident FROM MCS_city ORDER BY name asc;");	
			
			while(result.next()){
				City city = new City();
				city.loc = new Location(Bukkit.getWorld("world"),result.getInt("x"),result.getInt("y"),result.getInt("z"));
				UUID playerUUID;
				try{
					playerUUID = UUID.fromString( result.getString( "owner" ) );
				}catch(Exception e){
					playerUUID = Bukkit.getOfflinePlayer(result.getString( "owner" )).getUniqueId();
				}
				city.owner = playerUUID;
				city.name = result.getString("name");
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

	public static void removeCity(Player p) {
		// TODO Auto-generated method stub

		List<UUID> deleteCity = new ArrayList<UUID>();
		
		Iterator<Entry<UUID, City>> allResidents = City.residentList.entrySet().iterator();
		while(allResidents.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allResidents.next();
			try{
				City city = (City)pair.getValue();
				if(city.getOwner().equals(p.getUniqueId())){
					deleteCity.add((UUID) pair.getKey());
				}
			}catch(NullPointerException e){
				
			}
					
		}
		

		for(UUID resi: deleteCity ){
			City.residentList.remove(resi);
		}
		

		p.setMetadata("cityowner", new FixedMetadataValue(MCSocial.instance, false));

		City.cityList.remove(p.getUniqueId());
		City.delete(p);
		City.deleteVillager(p);
		
	}
	
	public static void delete(Player p) {
		String sql = "DELETE FROM MCS_city WHERE owner=?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, p.getUniqueId().toString());
			MySQL.insertDB(preparedStmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	public static void deleteVillager(Player p) {
		String sql = "DELETE FROM MCS_city_resident WHERE name=?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		
		try {
			preparedStmt.setString (1, p.getUniqueId().toString());
			MySQL.insertDB(preparedStmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
}
