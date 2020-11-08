package de.mcsocial.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Jail {

	private static HashMap<Player,ItemStack[]>playerItems;
	private static HashMap<Player,Integer>playerInJail;
	private static List<JailChunk>jailChunks;

	public static Boolean isInJail(Player p){
		if(Jail.playerInJail == null){
			Jail.playerInJail = new HashMap<Player,Integer>();
	}
		return Jail.playerInJail.containsKey(p);
	}

	public static HashMap<Player,Integer> getPrisonerAll(){
		return playerInJail;
	}

	public static int getPrisonerCount(){
		return playerInJail.size();
	}
	public static void add(Player p, Integer seconds)
	{
		if(Jail.playerInJail == null){
			Jail.playerInJail = new HashMap<Player,Integer>();
		}
		Jail.playerInJail.put(p,seconds);
		Jail.saveOwnItems(p);
		Jail.giveJailItems(p);

		//TODO JailTeleport
	}

	public static void remove(Player p){
		Jail.playerInJail.remove(p);
		Jail.removeJailItems(p);
		Jail.returnOwnItems(p);
	}

	private static void saveOwnItems(Player p){
		if(Jail.playerItems == null){
			Jail.playerItems = new HashMap<Player,ItemStack[]>();
		}
		Jail.playerItems.put(p,p.getInventory().getContents());
		ItemStack[] tmpToRemove = p.getInventory().getContents();
		for(ItemStack item: tmpToRemove){
			p.getInventory().remove(item);
		}
	}

	private static void giveJailItems(Player p){
		p.getInventory().addItem(new ItemStack(Material.BREAD,4));
		p.getInventory().addItem(new ItemStack(Material.WRITABLE_BOOK,4));
	}

	private static  void removeJailItems(Player p){
		ItemStack[] tmpToRemove = p.getInventory().getContents();
		for(ItemStack item: tmpToRemove){
			p.getInventory().remove(item);
		}
	}

	private static  void returnOwnItems(Player p){
		if(Jail.playerItems == null){
			Jail.playerItems = new HashMap<Player,ItemStack[]>();
		}
		ItemStack[] tmpToRemove = Jail.playerItems.get(p);
		for(ItemStack item: tmpToRemove){
			if(item == null)
				continue;
			p.getInventory().addItem(item);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static Boolean isJailChunks(Chunk chunk) {
		if(Jail.jailChunks== null){
			Jail.jailChunks = new ArrayList<JailChunk>();
		}
		return Jail.jailChunks.contains(chunk);
	}

	public static void setJailChunks(JailChunk jailChunk) {
		if(Jail.jailChunks == null){
			Jail.jailChunks = new ArrayList<JailChunk>();
		}
		Jail.jailChunks.add(jailChunk);
	}

	public static HashMap<Location, JailChunk> getList() {

		HashMap<Location,JailChunk>allCells = new HashMap<Location,JailChunk>();

		if(Jail.jailChunks == null){
			Jail.jailChunks = new ArrayList<JailChunk>();
		}
		for(JailChunk c: Jail.jailChunks){
			for(Location cell: c.getCellSpawns()){
				allCells.put(cell,c);
			}
		}
		return allCells;
	}

	public static List<Location> getCellList(){
		List<Location>allCellLocation = new ArrayList<Location>();
		Iterator<Entry<Location, JailChunk>> allCell = Jail.getList().entrySet().iterator();
		while(allCell.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allCell.next();
			allCellLocation.add((Location) pair.getKey());

		}
		return allCellLocation;
	}
}
