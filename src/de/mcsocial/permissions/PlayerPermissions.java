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
				return true;
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
				if(p.getMetadata("isAdmin").get(0).asBoolean())
				{
					return true;
				}
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
				if(p.getMetadata("isAdmin").get(0).asBoolean())
				{
					return true;
				}
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
				if(p.getMetadata("isAdmin").get(0).asBoolean())
				{
					return true;
				}
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
