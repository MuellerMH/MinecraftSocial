package de.mcsocial.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class JailChunk extends CustomChunk {

	private static List<Location>cellSpawns;

	public JailChunk(String name, UUID owner, boolean ownerIsCity, String city) {
		super(name, owner, ownerIsCity, city);
		if(JailChunk.cellSpawns == null){
			JailChunk.cellSpawns = new ArrayList<Location>();
		}

	}


	public void createCellSpawn(Player p){
		if(JailChunk.cellSpawns == null){
			JailChunk.cellSpawns = new ArrayList<Location>();
		}
		JailChunk.cellSpawns.add(p.getLocation());
	}

	public void removeCellSpawn(Player p){
		if(JailChunk.cellSpawns != null){
			if(JailChunk.cellSpawns.contains(p.getLocation())){
				JailChunk.cellSpawns.remove(p.getLocation());
			}
		}
	}
	public List<Location> getCellSpawns(){
		return cellSpawns;
	}
	public void gotoJailSpawn(Location loc, Player p){
		p.teleport(loc);
	}


	public void createCellSpawn(Location object) {

		if(JailChunk.cellSpawns == null){
			JailChunk.cellSpawns = new ArrayList<Location>();
		}
		JailChunk.cellSpawns.add(object);
	}

}
