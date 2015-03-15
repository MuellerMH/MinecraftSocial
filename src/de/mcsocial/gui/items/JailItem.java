package de.mcsocial.gui.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AccountMenu;
import de.mcsocial.gui.Menus.AdminMenu;
import de.mcsocial.gui.Menus.JailMenu;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.Jail;
import de.mcsocial.protection.JailChunk;

public class JailItem  extends MenuItem {
	private Boolean isCellSpawn;
	private Location cellLocation;
	private Player player;
	private UUID uuid;
	
	public JailItem(String text) {
		super(text);
		isCellSpawn = false;
	}
	
	public JailItem(String text, Material materialData) {
		super(text, new MaterialData( materialData));
		isCellSpawn = false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(Player p) {
		Menu playerSelect;
		int needetRows = 3;
		switch(this.getText()){
			case "einsperren":		
				List<Player> allPlayer = Arrays.asList(Bukkit.getServer().getOnlinePlayers());
				needetRows = Math.max(1,(int)Math.ceil(allPlayer.size()/9));
				playerSelect = new Menu("Spieler wählen",needetRows);
				JailMenu.createPlayerMenu(playerSelect,allPlayer,"select");
				Gui.switchMenu(p, JailMenu.menu, playerSelect);
				break;			
			case "Admin Menu":				
				Gui.switchMenu(p, JailMenu.menu, AdminMenu.menu);
				break;			
			case "Neue Zelle":	
				JailChunk jailChunk = null;
				if(!ChunkHandler.isClaimAble(p.getLocation().getChunk())){
					if(!Jail.isJailChunks(p.getLocation().getChunk())){
						ChunkHandler.unclaimChunk(p, 0.00);
						ChunkHandler.claimJailChunk(p, 0.00);
					}
				}else{
					ChunkHandler.claimJailChunk(p, 0.00);
				}
				
				jailChunk = (JailChunk) ChunkHandler.getChunk(p.getLocation().getChunk());
				
				jailChunk.createCellSpawn(p);
				ChunkHandler.insertChunkOwner(jailChunk);
				p.sendMessage("Gefängnis Zelle hinzugefügt.");
				JailMenu.menu.closeMenu(p);	  
				break;		
			case "frei lassen":				
				needetRows = Math.max(1,(int)Math.ceil(Jail.getPrisonerCount()/9));
				playerSelect = new Menu("Spieler wählen",(int)Math.ceil(needetRows));
				JailMenu.createPlayerMenu(playerSelect,Jail.getPrisonerAll(),"remove");
				Gui.switchMenu(p, JailMenu.menu, playerSelect);
				break;	
			default:
				switch(JailMenu.nextAction){
				case"teleport":
					p.teleport(this.cellLocation);
					JailMenu.menu.closeMenu(p);	  
					break;
				case"select":
					Random randomGenerator = new Random();
					int index = randomGenerator.nextInt(Jail.getCellList().size());
					Jail.add((Player) Bukkit.getPlayer(this.uuid),20*1*15);
					Bukkit.getPlayer(this.uuid).teleport(Jail.getCellList().get(index));
					JailMenu.menu.closeMenu(p);	  
					break;
				case"remove":
					Jail.remove((Player) Bukkit.getOfflinePlayer(this.uuid));
					JailMenu.menu.closeMenu(p);	  
					break;
				default:
					break;
				}
				break;
		}
		
	}

	public void setIsCellSpawn(boolean b) {
		this.isCellSpawn = b;
		
	}

	public void setLocation(Location key) {
		this.cellLocation = key;
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setUUID(UUID uniqueId) {
		this.uuid = uniqueId;
		
	}
	
	public UUID getUUID() {
		return this.uuid;
		
	}
}
