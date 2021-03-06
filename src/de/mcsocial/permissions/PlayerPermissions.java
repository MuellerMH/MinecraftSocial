package de.mcsocial.permissions;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import de.mcsocial.main.MCSocial;

public class PlayerPermissions {
	public static HashMap<UUID,PermissionAttachment> permissions;
	
	public static void initPlayerPermission(Player p){		
		PermissionAttachment attachment = p.addAttachment(MCSocial.instance);
		if(PlayerPermissions.permissions == null){
			PlayerPermissions.permissions = new HashMap<UUID,PermissionAttachment>();
		}
		PlayerPermissions.permissions.put(p.getUniqueId(), attachment);
		
		PlayerPermissions.loadPermissions(p);
	}
	
	private static void loadPermissions(Player player) {
		
		if(PlayerPermissions.hasAccess(player,"admin")){
			PlayerPermissions.setPermission(player,"MCSocial.bannen",true);
			PlayerPermissions.setPermission(player,"MCSocial.money",true);	
			PlayerPermissions.setPermission(player,"MCSocial.debug",true);	
			PlayerPermissions.setPermission(player,"MCSocial.geben",true);		
			PlayerPermissions.setPermission(player,"MCSocial.balance",true);	
		}
		
		if(PlayerPermissions.hasAccess(player,"moderator")){
			PlayerPermissions.setPermission(player,"MCSocial.timeban",true);
			PlayerPermissions.setPermission(player,"MCSocial.miner",true);	
			PlayerPermissions.setPermission(player,"MCSocial.gm",true);			
		}
		
		if(PlayerPermissions.hasAccess(player,"supporter")){
			PlayerPermissions.setPermission(player,"MCSocial.kicken",true);
			PlayerPermissions.setPermission(player,"MCSocial.fly",true);
			PlayerPermissions.setPermission(player,"MCSocial.teleport",true);
		}		
			
	}

	public static void setPermission(Player p,String name, Boolean value){
		PermissionAttachment attachment = permissions.get(p.getUniqueId());
		attachment.setPermission(name, value);
	}
	
	public static PermissionAttachment getPermission(Player p,PermissionAttachment permission){
		return permissions.get(p.getUniqueId());
	}

	public static void removePermission(Player p,String name){
		PermissionAttachment attachment = permissions.get(p.getUniqueId());
		attachment.unsetPermission(name);
	}
	
	public static Boolean hasAccess(Player p, String level){
		switch(level){
		case"op":
			return p.isOp();
		case"admin":
			if(p.isOp()){
				return p.isOp();
			}
			if(p.hasMetadata("isAdmin")){
				return p.getMetadata("isAdmin").get(0).asBoolean();
			}
			return false;
		case"moderator":
			if(p.isOp()){
				return true;
			}
			if(p.hasMetadata("isAdmin")){
				return p.getMetadata("isAdmin").get(0).asBoolean();
			}
			if(p.hasMetadata("isModerator")){
				return p.getMetadata("isModerator").get(0).asBoolean();
			}
			return false;
		case"supporter":
			if(p.isOp()){
				return true;
			}
			if(p.hasMetadata("isAdmin")){
				return p.getMetadata("isAdmin").get(0).asBoolean();
			}
			if(p.hasMetadata("isModerator")){
				return p.getMetadata("isModerator").get(0).asBoolean();
			}
			if(p.hasMetadata("isSupporter")){
				return p.getMetadata("isSupporter").get(0).asBoolean();
			}
			return false;
		case"donator":
			if(p.isOp()){
				return true;
			}
			if(p.hasMetadata("isAdmin")){
				return p.getMetadata("isAdmin").get(0).asBoolean();
			}
			if(p.hasMetadata("isDonator")){
				return p.getMetadata("isDonator").get(0).asBoolean();
			}
			return false;
		default:
			return false;
		}
	}
}
