package de.mcsocial.economy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Job {

	private String name;
	private String description;
	private List<String>allowed;

	public Job() {
		allowed = new ArrayList<String>();
	}

	public Boolean isCraftable(String string) {
		return allowed.contains(string);
	}

	public void addMoney(Material item){

	}

	public void addAllowed(String item){
		allowed.add(item);
	}

	public String getName(){
		return this.name;
	}

	public String getDescription(){
		return this.description;
	}


	public void setName(String string) {
		this.name = string;
	}

	public void setDescription(String string) {
		this.description = string;
	}

}
