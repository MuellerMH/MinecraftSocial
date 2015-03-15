package de.mcsocial.main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.mcsocial.chat.Channel;
import de.mcsocial.chat.ChatListener;
import de.mcsocial.cheatprotection.Miner;
import de.mcsocial.city.City;
import de.mcsocial.city.Resident;
import de.mcsocial.economy.Jobs;
import de.mcsocial.economy.Market;
import de.mcsocial.economy.ShopHandler;
import de.mcsocial.gui.Gui;
import de.mcsocial.notification.Server;
import de.mcsocial.protection.ChunkHandler;

public class MCSocial  extends JavaPlugin  implements Listener {
	
	public static Plugin instance = null;
	public static Gui guiHandler = null;
	public static City cityHandler = null;
	private static Server notificationServer;
	public static Channel channel;
	
	// called on PluginLoad
	@SuppressWarnings("static-access")
	public void onEnable(){ 
		
		MCSocial.instance = this;
		MCSocial.guiHandler = new Gui("Hauptmenu",3);
		MCSocial.cityHandler = new City();
		Listener jobListener = new Jobs();
		Listener chatListener = new ChatListener();
		Listener residentListener = new Resident();
		Listener chunkListener = new ChunkHandler();
		Listener shopListener = new ShopHandler();
		Listener miner = new Miner();

		Miner.loadMinerData();
		((ShopHandler) shopListener).load();
		

		MCSocial.setChannel(new Channel());
		MCSocial.channel.create("Support");
		MCSocial.channel.create("Admin");
		MCSocial.channel.create("Global");
		MCSocial.channel.create("Handel");	
		MCSocial.channel.create("Lokal");

		getServer().getPluginManager().registerEvents(shopListener, this);
		getServer().getPluginManager().registerEvents(jobListener, this);
		getServer().getPluginManager().registerEvents(chunkListener, this);
		getServer().getPluginManager().registerEvents(residentListener, this);
		getServer().getPluginManager().registerEvents(chatListener, this);
        getServer().getPluginManager().registerEvents(MCSocial.guiHandler, this);
        getServer().getPluginManager().registerEvents(miner, this);
                	

		getCommand("miner").setExecutor((CommandExecutor) miner);
		getCommand("join").setExecutor((CommandExecutor) chatListener);
		getCommand("list").setExecutor((CommandExecutor) chatListener);
		getCommand("leave").setExecutor((CommandExecutor) chatListener);
		getCommand("menu").setExecutor(MCSocial.guiHandler);	
		getCommand("gs").setExecutor((CommandExecutor)chunkListener);	
		
		Market.loadPrices();
		Jobs.loadJobs();
		
		
		MCSocial.setNotificationServer(new Server());
			
		
	}
	
	public void onDisable(){ 
		Miner.saveMinerData();
		Market.savePrices();
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
