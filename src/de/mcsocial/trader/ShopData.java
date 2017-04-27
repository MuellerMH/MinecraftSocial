package de.mcsocial.trader;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class ShopData {
	
	private List<ItemStack> shopItems;
	private String name;
	private String location;
	private int profession;
	
	public List<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return shopItems;
	}
	public void setItems(List<ItemStack> itemStack) {
		// TODO Auto-generated method stub
		shopItems = itemStack;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(double x, double y, double z) {
		this.location = x +","+y+","+z;
		
	}
	public String getLocation() {
		return this.location;
	}
	
	public void setProfession(int profession) {
		this.profession =profession;
		
	}
	
	public int getProfession() {
		return this.profession;
	}
	
	public void setLocation(String string) {
		this.location = string;
	}
	public void setLocation(Location location2) {
		// TODO Auto-generated method stub
		this.location = location2.getX() +","+location2.getY()+","+location2.getZ();
	}
	

}
