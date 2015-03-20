package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.main.MCSocial;
import de.mcsocial.main.MySQL;

public class Jobs implements Listener {
	public static HashMap<String,Job>JobList;
	public static HashMap<Material,Job>allJobItems;
	
	public static void addJob(String name, Job job)
	{
		if(Jobs.JobList == null){
			Jobs.JobList = new HashMap<String,Job>();
		}
		
		Jobs.JobList.put(name, job);		
		
	}
	
	@EventHandler
	public void onFishing(PlayerFishEvent event){
		if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
			if (!(event.getCaught() instanceof Item)) return; //no catch
			
			Player player = event.getPlayer();	
            ItemStack item = ((Item) event.getCaught()).getItemStack();

            Market.updatePrice(item.getType().name()+":"+item.getDurability(), Market.getPrice(item.getType().name()+":"+item.getDurability())*0.10*-1);
            
            if(player.hasMetadata("job")){
    			String playerjob = player.getMetadata("job").get(0).asString();
    			if(playerjob != null){
    				Job job = Jobs.JobList.get(playerjob);
    				if(job.isCraftable(item.getType().name()+":"+item.getDurability()))
    				{
    					Double itemPrice = Market.getPrice(item.getType().name()+":"+item.getDurability());
    					Account.add(player,itemPrice/100);
    					return;
    				}
    			}
    		}
			
			return;
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Block block = event.getBlock();
		List<ItemStack> listItems = (ArrayList<ItemStack>) block.getDrops();
		Double itemPrice = 25.00;
		Player player = event.getPlayer();	
		String mat = block.getType().name();
		
		if(listItems.size() > 0)
		{
			ItemStack item = (ItemStack) listItems.get(0);
			mat = item.getType().name()+":"+item.getDurability();	
			Market.setPrice(mat, (Market.getPrice(mat)-((Market.getPrice(mat)/100))));
			itemPrice = Market.getPrice(mat);
		}

		
        event.getBlock().setMetadata("placedBy", new FixedMetadataValue(MCSocial.instance, player.getUniqueId().toString()));
        
        if(player.hasMetadata("job")){
			String playerjob = player.getMetadata("job").get(0).asString();
			if(playerjob != null){
				Job job = Jobs.JobList.get(playerjob);
				
				if( job.getName().equals("Architekt"))
				{
					Account.add(player,itemPrice/100);
					return;
				}
				
				if(job.isCraftable(block.getType().name()))
				{								
					Account.remove(player,itemPrice/100);
					return;
				}
			}
		}
        
		return;
	}

	
	@EventHandler
	public void onBlockBreack(BlockBreakEvent event){
		Block block = event.getBlock();
		List<ItemStack> listItems = (ArrayList<ItemStack>) block.getDrops();
		Double itemPrice = 25.00;
		Player player = event.getPlayer();	
		String mat = block.getType().name();
		
		if(listItems.size() > 0)
		{
			ItemStack item = (ItemStack) listItems.get(0);
			mat = item.getType().name()+":"+item.getDurability();	
			Market.setPrice(mat, (Market.getPrice(mat)-((Market.getPrice(mat)/100))));
			itemPrice = Market.getPrice(mat);
		}

		
		if(block.getType().equals(Material.SIGN) || block.getType().equals(Material.SIGN_POST) || block.getType().equals(Material.WALL_SIGN)){
			ShopHandler.destroy((Sign)block.getState());
		}
       
		
		if(block.hasMetadata("placedBy")){
			UUID playerID = UUID.fromString(block.getMetadata("placedBy").get(0).asString());
			if(player.getUniqueId().equals(playerID))
			{
				return;
			}
		}

        if(player.hasMetadata("job")){
			String playerjob = player.getMetadata("job").get(0).asString();
			if(playerjob != null){
				Job job = Jobs.JobList.get(playerjob);
				if(job == null){
					return;
				}
				if(job.isCraftable(block.getType().name()))
				{
					
					Account.add(player,itemPrice/100);
					return;
				}
			}
		}
		
		return;
	}
	
	@EventHandler
	public void onCraftEvent(CraftItemEvent event){
		ItemStack item = event.getInventory().getResult();
		String mat = item.getType().name()+":"+((ItemStack) item).getDurability();
		Player player = (Player)event.getWhoClicked();		
		Double itemPrice = 25.00;

        Market.setPrice(mat, (Market.getPrice(mat)-((Market.getPrice(mat)/100))));
		
		if(player.hasMetadata("job")){
			String playerjob = player.getMetadata("job").get(0).asString();
			if(playerjob != null){
				Job job = Jobs.JobList.get(playerjob);
				if(job.isCraftable(item.getType().name()))
				{
					itemPrice = Market.getPrice(mat);
					Account.add(player,itemPrice/100);
					player.sendMessage(mat + itemPrice);
					return;
				}
			}
		}
		
		if(!Jobs.allJobItems.containsKey(mat))
		{
			return;
		}
		Job neededJob = Jobs.allJobItems.get(mat);
		
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"Du hast nicht die Fähigkeit den Gegenstand "+ChatColor.BLUE+mat.toString()+ChatColor.RED+" Herrzustellen!");
        player.sendMessage(ChatColor.RED+"Du kannst den Gegenstand von einem "+ChatColor.BLUE+neededJob.getName()+ChatColor.RED+" erwerben!");
	}
	
	public static Job getJob(String name){
		if(Jobs.JobList == null){
			return new Job();
		} 
		
		return Jobs.JobList.get(name);
	}
	
	public static void loadJobs() {
		
		if(Jobs.JobList != null){
			return;
		}
		
		if(Jobs.allJobItems == null){
			Jobs.allJobItems = new HashMap<Material,Job>();
		}
		
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT name, description, items FROM MCS_jobs WHERE status=1");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);			
			while(result.next()){
				Job job = new Job();
				job.setName(result.getString("name"));
				job.setDescription(result.getString("description"));
				
				String allowedString = result.getString("items");
				if(allowedString.contains(","))
				{
					List<String> materialList = new ArrayList<String>(Arrays.asList(allowedString.split(",")));
					for (String matString : materialList) {
						job.addAllowed(Material.getMaterial(matString));
						Jobs.allJobItems.put(Material.getMaterial(matString),job);
					}
				}
				
				Jobs.addJob(result.getString("name"), job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
