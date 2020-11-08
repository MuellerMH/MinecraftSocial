package de.mcsocial.main;

import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
<<<<<<< HEAD

import net.minecraft.server.v1_8_R1.EntityVillager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
=======
import java.security.KeyPairGenerator;

import com.vexsoftware.votifier.crypto.RSAIO;

>>>>>>> b4ade11... add new directory
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
<<<<<<< HEAD
=======
import de.mcsocial.docctorsAddons.SimpleConfigHandler;
>>>>>>> b4ade11... add new directory
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
<<<<<<< HEAD
import de.mcsocial.tracker.VoteTracker;
import de.mcsocial.trader.TraderHandler;
import de.mcsocial.trader.VillagerShop;

public class MCSocial  extends JavaPlugin  implements Listener {
	
=======
import de.mcsocial.trader.TraderHandler;

public class MCSocial extends JavaPlugin implements Listener {

>>>>>>> b4ade11... add new directory
	public static Plugin instance = null;
	public static Gui guiHandler = null;
	public static City cityHandler = null;
	private static Server notificationServer;
	public static Channel channel;
	private static KeyPair keyPair;

	public static FileConfiguration config;
<<<<<<< HEAD
	
	public KeyPair getKeyPair(){
		return MCSocial.keyPair;
	}
	
	// called on PluginLoad
	@SuppressWarnings("static-access")
	public void onEnable(){ 
		
		
		File pluginFolder = new File(getDataFolder().toString());
		
		if(!pluginFolder.exists()){
=======

	public KeyPair getKeyPair() {
		return MCSocial.keyPair;
	}

	// called on PluginLoad
	@SuppressWarnings("static-access")
	public void onEnable() {
		saveDefaultConfig();
		SimpleConfigHandler.loadConfig();

		File pluginFolder = new File(getDataFolder().toString());

		if (!pluginFolder.exists()) {
>>>>>>> b4ade11... add new directory
			pluginFolder.mkdir();
		}

		loadProperties();
<<<<<<< HEAD
		
		if ( !MCSocial.config.getBoolean("dbCreated") )
		{
=======

		if (!MCSocial.config.getBoolean("dbCreated")) {
>>>>>>> b4ade11... add new directory
			MySQLSetup.createTables();
			MCSocial.config.set("dbCreated", true);
			saveProperties();
		}
<<<<<<< HEAD
			
		
		/*
		 * Create RSA directory and keys if it does not exist; otherwise, read
		 * keys.
		 */
		
		NMSUtils nms = new NMSUtils();
        nms.registerEntity("VillagerShop", 120, EntityVillager.class, VillagerShop.class);
        
		MCSocial.instance = this;
		MCSocial.guiHandler = new Gui("Hauptmenu",3);
=======

		/*
		 * Create RSA directory and keys if it does not exist; otherwise, read keys.
		 */
		File path = new File("./plugins/MinecraftSocial/rsa/");
		if (!path.exists())
			path.mkdir();

		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			keygen.initialize(1024);
			keyPair = keygen.genKeyPair();
			RSAIO.save(path, keyPair);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		MCSocial.instance = this;
		MCSocial.guiHandler = new Gui("Hauptmenu", 3);
>>>>>>> b4ade11... add new directory
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
<<<<<<< HEAD
		
=======

>>>>>>> b4ade11... add new directory
		MCSocial.setChannel(new Channel());
		MCSocial.channel.create("Support");
		MCSocial.channel.create("Admin");
		MCSocial.channel.create("Global");
<<<<<<< HEAD
		MCSocial.channel.create("Handel");	
=======
		MCSocial.channel.create("Handel");
>>>>>>> b4ade11... add new directory
		MCSocial.channel.create("Lokal");

		getServer().getPluginManager().registerEvents(skillListener, this);
		getServer().getPluginManager().registerEvents(jobListener, this);
		getServer().getPluginManager().registerEvents(traderListener, this);
		getServer().getPluginManager().registerEvents(shopListener, this);
		getServer().getPluginManager().registerEvents(jobListener, this);
		getServer().getPluginManager().registerEvents(chunkListener, this);
		getServer().getPluginManager().registerEvents(residentListener, this);
		getServer().getPluginManager().registerEvents(chatListener, this);
<<<<<<< HEAD
        getServer().getPluginManager().registerEvents(MCSocial.guiHandler, this);
        getServer().getPluginManager().registerEvents(miner, this);
        
=======
		getServer().getPluginManager().registerEvents(MCSocial.guiHandler, this);
		getServer().getPluginManager().registerEvents(miner, this);

>>>>>>> b4ade11... add new directory
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
<<<<<<< HEAD
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

    	final ChunkCleaner clean = new ChunkCleaner();
		new BukkitRunnable() {           
	        @Override
	        public void run() {
		    	clean.run();
	        }
	    }.runTaskTimer(MCSocial.instance, 32L, 32L);
		
	    
	    // refactor
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
	
	
	private void saveProperties() {
		// TODO Auto-generated method stub
		File configFile = new File(getDataFolder(),"mcsocial.yml");
		try {
			MCSocial.config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
=======
		getCommand("menu").setExecutor(MCSocial.guiHandler);
		getCommand("fly").setExecutor(adminPlayer);
		getCommand("kicken").setExecutor(adminPlayer);
		getCommand("bannen").setExecutor(adminPlayer);
		getCommand("timeban").setExecutor(adminPlayer);
		getCommand("geben").setExecutor(adminPlayer);
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

		final ChunkCleaner clean = new ChunkCleaner();
		new BukkitRunnable() {
			@Override
			public void run() {
				clean.run();
			}
		}.runTaskTimer(MCSocial.instance, 32L, 32L);

		try {
			WebListener.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveProperties() {
		File configFile = new File(getDataFolder(), "config.yml");
		try {
			MCSocial.config.save(configFile);
		} catch (IOException e) {
>>>>>>> b4ade11... add new directory
			e.printStackTrace();
		}
	}

<<<<<<< HEAD
	private void loadProperties()
	{
		File configFile = new File(getDataFolder(),"mcsocial.yml");
		MCSocial.config = YamlConfiguration.loadConfiguration(configFile);
	}
	
	public void onDisable(){ 
		Miner.saveMinerData();
		Market.savePrices();
		SkillListener.saveSkills();	
		VoteTracker.onDisable();
=======
	private void loadProperties() {
		File configFile = new File(getDataFolder(), "config.yml");
		MCSocial.config = YamlConfiguration.loadConfiguration(configFile);
	}

	public void onDisable() {
		Miner.saveMinerData();
		Market.savePrices();
		SkillListener.saveSkills();
>>>>>>> b4ade11... add new directory
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
