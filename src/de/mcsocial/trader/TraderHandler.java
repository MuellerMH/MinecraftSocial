package de.mcsocial.trader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.gui.Menus.ShopMenu;
import de.mcsocial.main.MySQL;

public class TraderHandler implements Listener, CommandExecutor{
	
	private static HashMap<String,ShopData>shopList;
	
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
					// display all Shops
					p.sendMessage("Noch nicht implementiert");
					return true;
				}
				return false;
			}
			
			if(args.length >= 3){
				if(args[0].equalsIgnoreCase("add")){
					Villager village = VillagerShop.spawn(((Player)sender).getLocation(), args[1]);
					
					if(args[2]!=null){
						switch(args[2]){
						case"0":
							village.setProfession(Villager.Profession.FARMER);
							break;
						case"1":
							village.setProfession(Villager.Profession.LIBRARIAN);
							break;
						case"2":
							village.setProfession(Villager.Profession.PRIEST);
							break;
						case"3":
							village.setProfession(Villager.Profession.BLACKSMITH);
							break;
						case"4":
							village.setProfession(Villager.Profession.BUTCHER);
							break;
						}
					}

					p.sendMessage("Shop mit dem Namen " + args[1] + " hinzugefügt.");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("remove")){
					//TODO: entfernen ? VillagerShop.spawn(((Player)sender).getLocation(), args[2]);
					p.sendMessage("Shop mit dem Namen " + args[1] + " entfernt.");
					p.sendMessage("TODO: geht noch nicht... ");
					return true;
				}
				return false;
			}
			
		}
		return false;
	}
	
	
	
/*
 * 
 * VillagerShop villShop = new VillagerShop((World) Bukkit.getWorld("world"));
		Location loc = new Location(Bukkit.getWorld("world"),29.50,63.50,44.50);
		// x Y z
		villShop.setPosition(-240.50, 65.50, 236.50 );
		
		0 = Villager
		1 = Librarian
		2 = Priest
		3 = Blacksmith
		4 = Butcher
		 
		VillagerShop villager = (VillagerShop)Bukkit.getWorld("world").spawnCreature(loc, CreatureType.VILLAGER);	
 */
	

	public static ShopData getShop(CraftVillager shop) {
		if(TraderHandler.shopList == null){
			TraderHandler.shopList = new HashMap<String,ShopData>();
		}
		if(!TraderHandler.shopList.containsKey(shop.getCustomName())){
			TraderHandler.loadShop(shop.getCustomName());
		}
		return TraderHandler.shopList.get(shop.getCustomName());
	}
	private static String itemToString(List<ItemStack> item) {
		if(item == null) return null;
		StringBuilder out = new StringBuilder();
		for (ItemStack o : item)
		{
		  out.append(o.getType().toString()+":"+o.getDurability());
		  out.append(",");
		}
		return out.toString();
	}
	
	static void saveShop(ShopData shop){

		String items = TraderHandler.itemToString(shop.getItems());
		String sql;
		
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		sql = "insert into MCS_npcshop (name,items,location,profession)"
		        + " values (?, ?, ?, ?)"
		        + " ON DUPLICATE KEY UPDATE items= ?";
		
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString (1, shop.getName());
			preparedStmt.setString (2, items);
			preparedStmt.setString (3, shop.getLocation());
			preparedStmt.setInt(4, shop.getProfession());
			preparedStmt.setString (5, items);
			
			MySQL.insertDB(preparedStmt);								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void loadShop(String customName){
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT items,location,profession FROM MCS_npcshop WHERE name = ?");
		ResultSet result = null;
		try {
			preparedStmt.setString(1, customName);
			result = MySQL.callDB(preparedStmt);
			
			if(result == null) return;
			
			while(result.next()){
				ShopData shop = new ShopData();
				shop.setName(customName);
				String itemString = result.getString("items");
				if(itemString!=null){
					String[] items = itemString.split(",");
					List<ItemStack> itemStack = new ArrayList<ItemStack>();	
					for(String item: items){
						Material itemMaterial = Material.getMaterial(item.split(":")[0]);
						ItemStack generatetItem;
						generatetItem = new ItemStack(itemMaterial,1);
						if(item.split(":").length == 2){
							generatetItem = new ItemStack(itemMaterial,1,(short)Integer.parseInt(item.split(":")[1]));
						}
						
						itemStack.add(generatetItem);
						
					}
					shop.setItems(itemStack);
				}
				shop.setProfession(result.getInt("profession"));
				shop.setLocation(result.getString("location"));
				initVillager(shop);
				TraderHandler.shopList.put(customName, shop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadShops(){
		if(TraderHandler.shopList == null)
			TraderHandler.shopList = new HashMap<String,ShopData>();
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT name,items,location,profession FROM MCS_npcshop");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);
			
			if(result == null) return;
			
			while(result.next()){
				ShopData shop = new ShopData();
				shop.setName(result.getString("name"));
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
						
						itemStack.add(generatetItem);
					}
					shop.setItems(itemStack);
				}

				shop.setProfession(result.getInt("profession"));
				shop.setLocation(result.getString("location"));
				
				initVillager(shop);
				TraderHandler.shopList.put(result.getString("name"), shop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private static void initVillager(ShopData shop){
		String[]locdata = shop.getLocation().split(",");
		double x,z,y;
		x = Double.parseDouble(locdata[0]);
		y = Double.parseDouble(locdata[1]);
		z = Double.parseDouble(locdata[2]);
		Location loc = new Location(Bukkit.getWorld("world"),x,y,z);
		
		Villager village = VillagerShop.spawn(loc,shop.getName());
		
			switch(shop.getProfession()){
			case 0:
				village.setProfession(Villager.Profession.FARMER);
				break;
			case 1:
				village.setProfession(Villager.Profession.LIBRARIAN);
				break;
			case 2:
				village.setProfession(Villager.Profession.PRIEST);
				break;
			case 3:
				village.setProfession(Villager.Profession.BLACKSMITH);
				break;
			case 4:
				village.setProfession(Villager.Profession.BUTCHER);
				break;
			default:
				village.setProfession(Villager.Profession.FARMER);
				break;
			}
		System.out.println("Shop mit dem Namen " + shop.getName() + " hinzugefügt." + loc.toString());
	}
}
