package de.mcsocial.protection;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import de.mcsocial.city.City;

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

		this.owner = p.getUniqueId();
	}

	public String getWorld() {

		return this.world;
	}

	public Boolean getIsJail() {
		return isJail;
	}

	public void setIsJail(Boolean isJail) {
		this.isJail = isJail;
	}

	public void setCity(Player p) {

		if(p== null){
			this.ownerIsCity = false;
			this.cityname = "";
			return;
		}
		this.ownerIsCity = true;
		this.cityname = City.cityList.get(UUID.fromString(p.getMetadata("city").get(0).asString())).getName();
	}

}
