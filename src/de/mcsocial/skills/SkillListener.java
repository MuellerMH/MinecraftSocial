package de.mcsocial.skills;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.main.MySQL;

public class SkillListener implements Listener {
	private static HashMap<UUID,HashMap<String,Integer>>playerSkills;	
	private static List<String>skillItems;
	
	@EventHandler
	public void onFishing(PlayerFishEvent event){
		if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
			if (!(event.getCaught() instanceof Item)) return; //no catch
			
			Player player = event.getPlayer();
<<<<<<< HEAD
=======
			@SuppressWarnings("deprecation")
>>>>>>> b4ade11... add new directory
			ItemStack inHand = player.getItemInHand();
			
			loadSkillItems();
			
			if(SkillListener.playerSkills == null){
				SkillListener.playerSkills = new HashMap<UUID,HashMap<String,Integer>>();
			}
			
			if(!SkillListener.playerSkills.containsKey(player.getUniqueId())) return;
			
			if(!SkillListener.playerSkills.get(player.getUniqueId()).containsKey(inHand.getType().toString())){
				SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),1);
			}

			int oldScore = SkillListener.playerSkills.get(player.getUniqueId()).get(inHand.getType().toString());			

			SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),oldScore+24);
			
			return;
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
<<<<<<< HEAD
=======
		@SuppressWarnings("deprecation")
>>>>>>> b4ade11... add new directory
		ItemStack inHand = player.getItemInHand();
		
		loadSkillItems();
		
		if(SkillListener.playerSkills == null){
			SkillListener.playerSkills = new HashMap<UUID,HashMap<String,Integer>>();
		}
		if(!SkillListener.playerSkills.containsKey(player.getUniqueId())) return;

		if(!SkillListener.playerSkills.get(player.getUniqueId()).containsKey(inHand.getType().toString())){
			SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),1);
		}

		int oldScore = SkillListener.playerSkills.get(player.getUniqueId()).get(inHand.getType().toString());
		
		if(inHand.getType().toString().startsWith("DIAMOND")) {
			SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),oldScore+24);
			
		}
		if(inHand.getType().toString().startsWith("IRON")) {
			SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),oldScore+16);
			
		}
		if(inHand.getType().toString().startsWith("WOOD")) {
			SkillListener.playerSkills.get(player.getUniqueId()).put(inHand.getType().toString(),oldScore+8);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void saveSkills(){
		String sql = "insert into MCS_skills (user,item,points) "
				+ "VALUES ( ?,?,?)"
				+ " ON DUPLICATE KEY UPDATE points=?";
		
		try {
			if(SkillListener.playerSkills == null)return;
			Iterator playerSkills = SkillListener.playerSkills.entrySet().iterator();
		    while (playerSkills.hasNext()) {
		        Map.Entry pairplayerSkills = (Map.Entry)playerSkills.next();
		        HashMap<String,Integer>skillHash  = (HashMap<String, Integer>) pairplayerSkills.getValue();
		        Iterator skills = skillHash.entrySet().iterator();
			    while (skills.hasNext()) {
					PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			        Map.Entry pairskills = (Map.Entry)skills.next();
					preparedStmt.setString (1, pairplayerSkills.getKey().toString());
					preparedStmt.setString (2, (String) pairskills.getKey());			
					preparedStmt.setInt (3, (int) pairskills.getValue());				
					preparedStmt.setInt (4, (int) pairskills.getValue());					
					MySQL.insertDB(preparedStmt);
			    }
		    }								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadSkillItems(){
		if(SkillListener.skillItems == null){
			SkillListener.skillItems = new ArrayList<String>();			
		}
		SkillListener.skillItems.add("DIAMOND_SWORD");
		SkillListener.skillItems.add("DIAMOND_PICKAXE");
		SkillListener.skillItems.add("DIAMOND_AXE");
		SkillListener.skillItems.add("IRON_SWORD");
		SkillListener.skillItems.add("IRON_PICKAXE");
		SkillListener.skillItems.add("IRON_AXE");
		SkillListener.skillItems.add("WOOD_SWORD");
		SkillListener.skillItems.add("WOOD_PICKAXE");
		SkillListener.skillItems.add("WOOD_AXE");
	}

}
