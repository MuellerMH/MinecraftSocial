package de.mcsocial.trader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
<<<<<<< HEAD
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
=======
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftVillager;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
>>>>>>> b4ade11... add new directory
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.ShopMenu;
import de.mcsocial.main.MySQL;

<<<<<<< HEAD
public class TraderHandler implements Listener, CommandExecutor{
	
	private static HashMap<String,ShopData>shopList;
	private static HashMap<String,Villager>villagerList;
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent  event){
		Entity villager = event.getRightClicked();
		if(villager instanceof CraftVillager){
			if(villager.getCustomName() != null ){
				event.setCancelled(true);
				if( Hauptmenu.menu == null){
					Menu menu = Gui.createMenu("Hauptmenu",3);
					Hauptmenu.loadMenu(menu,event.getPlayer());
					menu.openMenu(event.getPlayer());
				}
				Menu shopMenu = new Menu(villager.getCustomName(),4);
				ShopMenu.loadMenu(shopMenu,event.getPlayer(),(CraftVillager) villager);
				Gui.switchMenu(event.getPlayer(), Hauptmenu.menu, shopMenu);
			}
    		return;
    	}		
		return;
	}
	   

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {	
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("shop")) {
			if(args.length == 0){
				return false;
			}
			
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
=======
public class TraderHandler implements Listener, CommandExecutor {

	private static HashMap<String, ShopData> shopList;
	private static HashMap<String, Villager> villagerList;

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent event) {
		Entity villager = event.getRightClicked();
		if (villager instanceof CraftVillager) {
			if (villager.getCustomName() != null) {
				event.setCancelled(true);
				if (Hauptmenu.menu == null) {
					Menu menu = Gui.createMenu("Hauptmenu", 3);
					Hauptmenu.loadMenu(menu, event.getPlayer());
					menu.openMenu(event.getPlayer());
				}
				Menu shopMenu = new Menu(villager.getCustomName(), 4);
				ShopMenu.loadMenu(shopMenu, event.getPlayer(), (CraftVillager) villager);
				Gui.switchMenu(event.getPlayer(), Hauptmenu.menu, shopMenu);
			}
			return;
		}
		return;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("[MCSocial] Dieser Befehl kann nur von einem Spieler ausgefï¿½hrt werden!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("shop")) {
			if (args.length == 0) {
				return false;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("list")) {
>>>>>>> b4ade11... add new directory
					// display all Shops
					p.sendMessage("Noch nicht implementiert");
					return true;
				}
				return false;
			}
<<<<<<< HEAD
			
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("reload")){
					VillagerShop.despawn((Villager)villagerList.get(args[1]));
=======

			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reload")) {
					VillagerShop.despawn((Villager) villagerList.get(args[1]));
>>>>>>> b4ade11... add new directory
					TraderHandler.loadShop(args[1]);
					p.sendMessage("Shop " + args[1] + " reloaded");
					return true;
				}
<<<<<<< HEAD
				
				if(args[0].equalsIgnoreCase("remove")){
					removeShop(args[1]);
					VillagerShop.despawn((Villager)villagerList.get(args[1]));
=======

				if (args[0].equalsIgnoreCase("remove")) {
					removeShop(args[1]);

					VillagerShop.despawn((Villager) villagerList.get(args[1]));
>>>>>>> b4ade11... add new directory
					TraderHandler.removeShop(args[1]);
					p.sendMessage("Shop mit dem Namen " + args[1] + " entfernt.");
					return true;
				}
				return false;
			}
<<<<<<< HEAD
			
			if(args.length == 3){
				
				Integer profession = Integer.parseInt(args[2]);
				
				if(args[0].equalsIgnoreCase("add")){
					Villager village = VillagerShop.spawn(((Player)sender).getLocation(), args[1],profession);					
					village.setProfession(TraderHandler.getProfession(profession));
					if(TraderHandler.villagerList==null){
						TraderHandler.villagerList = new HashMap<String,Villager>();
					}
					TraderHandler.villagerList.put(args[1],village);

					p.sendMessage("Shop mit dem Namen " + args[1] + " hinzugefügt.");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("move")){
					try{
						ShopData shop = TraderHandler.shopList.get(args[1]);
						Villager village = villagerList.get(args[1]);
						Villager newVillage = VillagerShop.spawn(((Player)sender).getLocation(), args[1], profession);
						villagerList.replace(args[1], village, newVillage);				
						village.setProfession(TraderHandler.getProfession(profession));
						shop.setLocation(((Player)sender).getLocation());
						VillagerShop.despawn(village);
						TraderHandler.saveShop(shop);
					
						p.sendMessage("Shop " + args[1] + " moved");
					} catch ( Exception e) {
						e.printStackTrace();
						p.sendMessage("Error move shop " +args[1]+": " + e.getMessage()  + "!");
					}
					return true;
				}
				
				return false;
			}
			
		}
		return false;
	}
	
	
	private static Profession getProfession(Integer prof)
	{
		switch(prof){
		case 0:
			return Villager.Profession.FARMER;
		case 1:
			return Villager.Profession.LIBRARIAN;
		case 2:
			return Villager.Profession.PRIEST;
		case 3:
			return Villager.Profession.BLACKSMITH;
		case 4:
			return Villager.Profession.BUTCHER;
		default: 
			return Villager.Profession.FARMER;
		}
		
	}

	public static ShopData getShop(CraftVillager shop) {
		if(TraderHandler.shopList == null){
			TraderHandler.shopList = new HashMap<String,ShopData>();
		}
		if(!TraderHandler.shopList.containsKey(shop.getCustomName())){
=======

			if (args.length == 3) {

				int profession = Integer.parseInt(args[2]);

				if (args[0].equalsIgnoreCase("add")) {
					Villager village = VillagerShop.spawn(((Player) sender).getLocation(), args[1], profession);
					village.setProfession(TraderHandler.getProfession(profession));
					if (TraderHandler.villagerList == null) {
						TraderHandler.villagerList = new HashMap<String, Villager>();
					}
					TraderHandler.villagerList.put(args[1], village);
					ShopData shop = new ShopData();
					shop.setLocation(village.getLocation());
					shop.setName(args[1]);
					shop.setProfession(profession);
					TraderHandler.saveShop(shop);
					p.sendMessage("Shop mit dem Namen " + args[1] + " hinzugefï¿½gt.");
					return true;
				}

				if (args[0].equalsIgnoreCase("move")) {
					try {
						ShopData shop = TraderHandler.shopList.get(args[1]);
						Villager village = villagerList.get(args[1]);
						Villager newVillage = VillagerShop.spawn(((Player) sender).getLocation(), args[1], profession);
						villagerList.replace(args[1], village, newVillage);
						village.setProfession(TraderHandler.getProfession(profession));
						shop.setLocation(((Player) sender).getLocation());
						VillagerShop.despawn(village);
						TraderHandler.saveShop(shop);

						p.sendMessage("Shop " + args[1] + " moved");
					} catch (Exception e) {
						e.printStackTrace();
						p.sendMessage("Error move shop " + args[1] + ": " + e.getMessage() + "!");
					}
					return true;
				}

				return false;
			}

		}
		return false;
	}

	public static Profession getProfession(Integer prof) {
		switch (prof) {
			case 0:
				return Villager.Profession.ARMORER;
			case 1:
				return Villager.Profession.BUTCHER;
			case 2:
				return Villager.Profession.CARTOGRAPHER;
			case 3:
				return Villager.Profession.CLERIC;
			case 4:
				return Villager.Profession.FARMER;
			case 5:
				return Villager.Profession.FISHERMAN;
			case 6:
				return Villager.Profession.FLETCHER;
			case 7:
				return Villager.Profession.LEATHERWORKER;
			case 8:
				return Villager.Profession.LIBRARIAN;
			case 9:
				return Villager.Profession.MASON;
			case 10:
				return Villager.Profession.NITWIT;
			default:
				return Villager.Profession.NONE;
		}

	}

	public static ShopData getShop(CraftVillager shop) {
		if (TraderHandler.shopList == null) {
			TraderHandler.shopList = new HashMap<String, ShopData>();
		}
		if (!TraderHandler.shopList.containsKey(shop.getCustomName())) {
>>>>>>> b4ade11... add new directory
			TraderHandler.loadShop(shop.getCustomName());
		}
		return TraderHandler.shopList.get(shop.getCustomName());
	}
<<<<<<< HEAD
	
	private static String itemsToString(List<ItemStack> item) {
		if(item == null) return null;
		StringBuilder out = new StringBuilder();
		for (ItemStack o : item)
		{
		  out.append(o.getType().toString()+":"+o.getDurability());
		  out.append(",");
		}
		return out.toString();
	}
	
	static void removeShop(String shopName){

		String sql;
		
			sql = "DELETE FROM MCS_npcshop WHERE"
		        + " name = ?";
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			try {
				preparedStmt.setString (1, shopName);
				
				MySQL.insertDB(preparedStmt);								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		
	}
	
	static void saveShop(ShopData shop){

		
=======

	@SuppressWarnings("deprecation")
	private static String itemsToString(List<ItemStack> item) {
		if (item == null)
			return null;
		StringBuilder out = new StringBuilder();
		for (ItemStack o : item) {
			out.append(o.getType().toString() + ":" + o.getDurability());
			out.append(",");
		}
		return out.toString();
	}

	static void removeShop(String shopName) {

		String sql;

		sql = "DELETE FROM MCS_npcshop WHERE" + " name = ?";
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString(1, shopName);

			MySQL.insertDB(preparedStmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;

	}

	static void saveShop(ShopData shop) {

>>>>>>> b4ade11... add new directory
		String items = TraderHandler.itemsToString(shop.getItems());
		String sql;

		Bukkit.getLogger().info(items);
<<<<<<< HEAD
		
		if(items== null)
		{
			sql = "insert ignore into MCS_npcshop (name,items,location,profession)"
		        + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			try {
				preparedStmt.setString (1, shop.getName());
				preparedStmt.setString (2, items);
				preparedStmt.setString (3, shop.getLocation());
				preparedStmt.setInt(4, shop.getProfession());
				
				MySQL.insertDB(preparedStmt);								
=======

		if (items == null) {
			sql = "insert ignore into MCS_npcshop (name,items,location,profession)" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			try {
				preparedStmt.setString(1, shop.getName());
				preparedStmt.setString(2, items);
				preparedStmt.setString(3, shop.getLocation());
				preparedStmt.setInt(4, shop.getProfession());

				MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
<<<<<<< HEAD
		
		
		sql = "insert into MCS_npcshop (name,items,location,profession)"
		        + " values (?, ?, ?, ?)"
		        + " ON DUPLICATE KEY UPDATE items= ?,location = ?, profession=?";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString (1, shop.getName());
			preparedStmt.setString (2, items);
			preparedStmt.setString (3, shop.getLocation());
			preparedStmt.setInt(4, shop.getProfession());
			preparedStmt.setString (5, items);
			preparedStmt.setString (6, shop.getLocation());
			preparedStmt.setInt (7, shop.getProfession());
			
			MySQL.insertDB(preparedStmt);								
=======

		sql = "insert into MCS_npcshop (name,items,location,profession)" + " values (?, ?, ?, ?)"
				+ " ON DUPLICATE KEY UPDATE items= ?,location = ?, profession=?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString(1, shop.getName());
			preparedStmt.setString(2, items);
			preparedStmt.setString(3, shop.getLocation());
			preparedStmt.setInt(4, shop.getProfession());
			preparedStmt.setString(5, items);
			preparedStmt.setString(6, shop.getLocation());
			preparedStmt.setInt(7, shop.getProfession());

			MySQL.insertDB(preparedStmt);
>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	static void loadShop(String customName){
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT items,location,profession FROM MCS_npcshop WHERE name = ?");
=======

	static void loadShop(String customName) {
		PreparedStatement preparedStmt = MySQL
				.getPreStat("SELECT items,location,profession FROM MCS_npcshop WHERE name = ?");
>>>>>>> b4ade11... add new directory
		ResultSet result = null;
		try {
			preparedStmt.setString(1, customName);
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
			if(result == null) return;
			
			while(result.next()){
=======

			if (result == null)
				return;

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				TraderHandler.initShop(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	private static ShopData initShop(ResultSet result) throws SQLException
	{
		if(TraderHandler.shopList == null){
			TraderHandler.shopList = new HashMap<String,ShopData>();
		}
		
		String shopName = result.getString("name");
		
		Bukkit.getLogger().info(result.getString("name")+ " : " +result.getString("items"));
		
		if(shopName!=null){
			ShopData shop = new ShopData();
			shop.setName(shopName);
			String itemString = result.getString("items");
			if(itemString!=null){
				String[] items = itemString.split(",");
				List<ItemStack> itemStack = new ArrayList<ItemStack>();	
				for(String item: items){
					Material itemMaterial = Material.getMaterial(item.split(":")[0]);
					if(itemMaterial==null) continue;
					ItemStack generatetItem;
					generatetItem = new ItemStack(itemMaterial,1);
					if(item.split(":").length == 2){
						generatetItem = new ItemStack(itemMaterial,1,(short)Integer.parseInt(item.split(":")[1]));
					}
					
=======

	@SuppressWarnings("deprecation")
	private static ShopData initShop(ResultSet result) throws SQLException {
		if (TraderHandler.shopList == null) {
			TraderHandler.shopList = new HashMap<String, ShopData>();
		}

		String shopName = result.getString("name");

		Bukkit.getLogger().info(result.getString("name") + " : " + result.getString("items"));

		if (shopName != null) {
			ShopData shop = new ShopData();
			shop.setName(shopName);
			String itemString = result.getString("items");
			if (itemString != null) {
				String[] items = itemString.split(",");
				List<ItemStack> itemStack = new ArrayList<ItemStack>();
				for (String item : items) {
					Material itemMaterial = Material.getMaterial(item.split(":")[0]);
					if (itemMaterial == null)
						continue;
					ItemStack generatetItem;
					generatetItem = new ItemStack(itemMaterial, 1);
					if (item.split(":").length == 2) {
						generatetItem = new ItemStack(itemMaterial, 1, (short) Integer.parseInt(item.split(":")[1]));
					}

>>>>>>> b4ade11... add new directory
					itemStack.add(generatetItem);
				}
				shop.setItems(itemStack);
			}
<<<<<<< HEAD
	
			shop.setProfession(result.getInt("profession"));
			shop.setLocation(result.getString("location"));
			
=======

			shop.setProfession(result.getInt("profession"));
			shop.setLocation(result.getString("location"));

>>>>>>> b4ade11... add new directory
			initVillager(shop);
			TraderHandler.shopList.put(result.getString("name"), shop);
			return shop;

		}
		return null;
	}
<<<<<<< HEAD
	
	public static void loadShops(){
		TraderHandler.shopList = new HashMap<String,ShopData>();
=======

	public static void loadShops() {
		TraderHandler.shopList = new HashMap<String, ShopData>();
>>>>>>> b4ade11... add new directory
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT name,items,location,profession FROM MCS_npcshop");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);
<<<<<<< HEAD
			
			if(result == null) return;
			
			while(result.next()){
=======

			if (result == null)
				return;

			while (result.next()) {
>>>>>>> b4ade11... add new directory
				TraderHandler.initShop(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	public static void onDisable(){
		Iterator<Entry<String,Villager>> allShops = TraderHandler.villagerList.entrySet().iterator();
		while(allShops.hasNext()){	
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)allShops.next();
			((Villager)pair.getValue()).teleport(new Location(Bukkit.getWorld("world"),0,0,0));
			((Villager)pair.getValue()).setHealth(0.00);
		}
	}
		
	private static void initVillager(ShopData shop){
		String[]locdata = shop.getLocation().split(",");
		double x,z,y;
		x = Double.parseDouble(locdata[0]);
		y = Double.parseDouble(locdata[1]);
		z = Double.parseDouble(locdata[2]);
		Location loc = new Location(Bukkit.getWorld("world"),x,y,z);
		
		Villager village = VillagerShop.spawn(loc,shop.getName(),shop.getProfession());
		village.setProfession(TraderHandler.getProfession(shop.getProfession()));
		
		if(TraderHandler.villagerList==null){
			TraderHandler.villagerList = new HashMap<String,Villager>();
		}
		TraderHandler.villagerList.put(shop.getName(),village);
			
=======

	public static void onDisable() {
		Iterator<Entry<String, Villager>> allShops = TraderHandler.villagerList.entrySet().iterator();
		while (allShops.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) allShops.next();
			((Villager) pair.getValue()).teleport(new Location(Bukkit.getWorld("world"), 0, 0, 0));
			((Villager) pair.getValue()).setHealth(0.00);
		}
	}

	private static void initVillager(ShopData shop) {
		String[] locdata = shop.getLocation().split(",");
		double x, z, y;
		x = Double.parseDouble(locdata[0]);
		y = Double.parseDouble(locdata[1]);
		z = Double.parseDouble(locdata[2]);
		Location loc = new Location(Bukkit.getWorld("world"), x, y, z);

		Villager village = VillagerShop.spawn(loc, shop.getName(), shop.getProfession());
		village.setProfession(TraderHandler.getProfession(shop.getProfession()));

		if (TraderHandler.villagerList == null) {
			TraderHandler.villagerList = new HashMap<String, Villager>();
		}
		TraderHandler.villagerList.put(shop.getName(), village);

>>>>>>> b4ade11... add new directory
	}
}
