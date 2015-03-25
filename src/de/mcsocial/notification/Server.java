package de.mcsocial.notification;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import de.mcsocial.main.MCSocial;

public class Server {
	
	public Server(){
		new BukkitRunnable() {	           
	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	        	Bukkit.broadcastMessage(ChatColor.DARK_GREEN +  "Werde reich belohnt! Vote unter: ");
	        	Bukkit.broadcastMessage(ChatColor.DARK_GREEN +  "https://minecraft-server.eu/server/index/107161/minecraft_social");
	        }
	    }.runTaskTimer(MCSocial.instance, 60L, 20000L);
	   
	   new BukkitRunnable() {           
	        @Override
	        public void run() {
		    	Bukkit.broadcastMessage(ChatColor.DARK_GREEN +  "Homepage: http://minecraft-social.de");
		    	Bukkit.broadcastMessage(ChatColor.DARK_GREEN +  "Teamspeakserver: ts84.nitrado.net:17700");
		    	Bukkit.broadcastMessage(ChatColor.DARK_GREEN +  "Twitch: http://www.twitch.tv/muellermh");
	        }
	    }.runTaskTimer(MCSocial.instance, 60L, 30000L);
	 }
	
}
