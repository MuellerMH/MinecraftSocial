package de.mcsocial.main;

import java.io.File;
import java.security.KeyPair;

import net.minecraft.server.v1_8_R1.EntityVillager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.mcsocial.admin.AdminPlayer;
import de.mcsocial.chat.Channel;
import de.mcsocial.chat.ChatListener;
import de.mcsocial.cheatprotection.Miner;
import de.mcsocial.city.City;
import de.mcsocial.city.Resident;
import de.mcsocial.economy.Jobs;
import de.mcsocial.economy.Market;
import de.mcsocial.economy.ShopHandler;
import de.mcsocial.gui.Gui;
import de.mcsocial.notification.CommandPlayer;
import de.mcsocial.notification.Server;
import de.mcsocial.notification.WebListener;
import de.mcsocial.protection.ChunkCleaner;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.skills.SkillListener;
import de.mcsocial.tracker.VoteTracker;
import de.mcsocial.trader.TraderHandler;
import de.mcsocial.trader.VillagerShop;

public class MCSocial  extends JavaPlugin  implements Listener {
	
	public static Plugin instance = null;
	public static Gui guiHandler = null;
	public static City cityHandler = null;
	private static Server notificationServer;
	public static Channel channel;
	private static KeyPair keyPair;
	
	public KeyPair getKeyPair(){
		return MCSocial.keyPair;
	}
	
	// called on PluginLoad
	@SuppressWarnings("static-access")
	public void onEnable(){ 
		
		File pluginFolder = new File(getDataFolder().toString());
		if(!pluginFolder.exists()){
			pluginFolder.mkdir();
		}
		/*
		 * Create RSA directory and keys if it does not exist; otherwise, read
		 * keys.
		 */
		
		NMSUtils nms = new NMSUtils();
        nms.registerEntity("VillagerShop", 120, EntityVillager.class, VillagerShop.class);
        
		MCSocial.instance = this;
		MCSocial.guiHandler = new Gui("Hauptmenu",3);
		MCSocial.cityHandler = new City();
		Listener jobListener = new Jobs();
		Listener chatListener = new ChatListener();
		Listener residentListener = new Resident();
		Listener chunkListener = new ChunkHandler();
		Listener shopListener = new ShopHandler();
		Listener miner = new Miner();
		Listener traderListener = new TraderHandler();
		Listener skillListener = new SkillListener();
		CommandExecutor adminPlayer = new AdminPlayer();
		CommandExecutor commandPlayer = new CommandPlayer();

		Miner.loadMinerData();
		((ShopHandler) shopListener).load();
		TraderHandler.loadShops();
		

		MCSocial.setChannel(new Channel());
		MCSocial.channel.create("Support");
		MCSocial.channel.create("Admin");
		MCSocial.channel.create("Global");
		MCSocial.channel.create("Handel");	
		MCSocial.channel.create("Lokal");

		getServer().getPluginManager().registerEvents(skillListener, this);
		getServer().getPluginManager().registerEvents(jobListener, this);
		getServer().getPluginManager().registerEvents(traderListener, this);
		getServer().getPluginManager().registerEvents(shopListener, this);
		getServer().getPluginManager().registerEvents(jobListener, this);
		getServer().getPluginManager().registerEvents(chunkListener, this);
		getServer().getPluginManager().registerEvents(residentListener, this);
		getServer().getPluginManager().registerEvents(chatListener, this);
        getServer().getPluginManager().registerEvents(MCSocial.guiHandler, this);
        getServer().getPluginManager().registerEvents(miner, this);
        
		getCommand("infoitem").setExecutor((CommandExecutor) miner);
		getCommand("shop").setExecutor((CommandExecutor) traderListener);
		getCommand("miner").setExecutor((CommandExecutor) miner);
		getCommand("join").setExecutor((CommandExecutor) chatListener);
		getCommand("list").setExecutor((CommandExecutor) chatListener);
		getCommand("leave").setExecutor((CommandExecutor) chatListener);
		getCommand("g").setExecutor((CommandExecutor) chatListener);
		getCommand("h").setExecutor((CommandExecutor) chatListener);
		getCommand("a").setExecutor((CommandExecutor) chatListener);
		getCommand("l").setExecutor((CommandExecutor) chatListener);
		getCommand("menu").setExecutor(MCSocial.guiHandler);	
		getCommand("fly").setExecutor(adminPlayer);	
		getCommand("kicken").setExecutor(adminPlayer);	
		getCommand("bannen").setExecutor(adminPlayer);	
		getCommand("timeban").setExecutor(adminPlayer);	
		getCommand("geben").setExecutor(adminPlayer);	
		getCommand("bank").setExecutor(adminPlayer);	
		getCommand("gm").setExecutor(adminPlayer);	
		getCommand("teleport").setExecutor(adminPlayer);	
		getCommand("debug").setExecutor(adminPlayer);		
		getCommand("balance").setExecutor(adminPlayer);		
		getCommand("gs").setExecutor((CommandExecutor) chunkListener);	
		getCommand("home").setExecutor((CommandExecutor) commandPlayer);	
		getCommand("money").setExecutor((CommandExecutor) commandPlayer);	
		getCommand("spawn").setExecutor((CommandExecutor) commandPlayer);	
		getCommand("ts").setExecutor((CommandExecutor) commandPlayer);		
		getCommand("vote").setExecutor((CommandExecutor) commandPlayer);
		
		Market.loadPrices();
		Jobs.loadJobs();
	
		City.loadAllCitys();
		City.loadAllVillager();			
		
		new BukkitRunnable() {           
	        @Override
	        public void run() {
		    	ChunkCleaner clean = new ChunkCleaner();
		    	clean.run();
	        }
	    }.runTaskTimer(MCSocial.instance, 320L, 320L);
		
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
		
		VoteTracker.onEnable(this);
		try {
			WebListener.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onDisable(){ 
		Miner.saveMinerData();
		Market.savePrices();
		SkillListener.saveSkills();	
		VoteTracker.onDisable();
		TraderHandler.onDisable();
		City.saveAllVillager();
	}

	public static Server getNotificationServer() {
		return notificationServer;
	}

	public static void setNotificationServer(Server notificationServer) {
		MCSocial.notificationServer = notificationServer;
	}

	public static Channel getChannel() {
		return channel;
	}

	public static void setChannel(Channel channel) {
		MCSocial.channel = channel;
	}

}
