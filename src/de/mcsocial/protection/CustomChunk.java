package de.mcsocial.protection;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class CustomChunk {
	private String name;
	private UUID owner;
	private String cityname;
	private Boolean ownerIsCity=false; 
	private Boolean buyable=false; 
	private Boolean isJail=false; 
	private Double buyprice=0.00; 
	private String world="world"; 
	public HashMap<UUID,Boolean>access = new HashMap<UUID,Boolean>();
	public HashMap<String,Boolean>flags = new HashMap<String,Boolean>();
	
	public CustomChunk(String name, UUID owner, boolean ownerIsCity, String city) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.owner = owner;
		this.cityname = city;
		this.ownerIsCity = ownerIsCity;
	}
	
	public void setBuyAble(Boolean isBuyAble){
		this.buyable =isBuyAble;
	}
	
	public void setPrice(Double price){
		this.buyprice =price;
	}

	public Boolean isBuyAble(){
		return this.buyable;
	}
	
	public Double getPrice(){
		if(this.buyable){
			return this.buyprice;
		}
		return 0.00;
	}

	public String getCityName(){
		return this.cityname;
	}

	public String getName(){
		return this.name;
	}
	
	public UUID getOwner(){
		return this.owner;
	}
	
	public Boolean isCity(){
		return this.ownerIsCity;
	}
	
	public Boolean hasAccess(UUID playerID){
		if(!access.containsKey(playerID)){
			return false;
		}
		
		return access.get(playerID);
	}
	
	public Boolean getFlag(String flag){
		if(!flags.containsKey(flag)){
			return false;
		}
		
		return flags.get(flag);
	}

	public void setOwner(Player p) {
		// TODO Auto-generated method stub
		this.owner = p.getUniqueId();
	}

	public String getWorld() {
		// TODO Auto-generated method stub
		return this.world;
	}

	public Boolean getIsJail() {
		return isJail;
	}

	public void setIsJail(Boolean isJail) {
		this.isJail = isJail;
	}
	
}
