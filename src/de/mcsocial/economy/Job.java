package de.mcsocial.economy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Job {
	
	private String name;	
	private String description;
	private List<Material>allowed;
	
	public Job() {	
		allowed = new ArrayList<Material>();
	}
	
	public Boolean isCraftable(Material mat) {
		return allowed.contains(mat);
	}
	
	public void addMoney(Material item){
		
	}
	
	public void addAllowed(Material item){
		allowed.add(item);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	

	public void setName(String string) {
		// TODO Auto-generated method stub
		this.name = string;
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		this.description = string;
	}
	
}
