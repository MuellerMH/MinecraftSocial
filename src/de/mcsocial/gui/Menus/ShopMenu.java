package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.mcsocial.economy.Market;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.ShopBuyItem;
import de.mcsocial.gui.items.ShopItem;
import de.mcsocial.gui.items.ShopSellItem;
import de.mcsocial.trader.ShopData;
import de.mcsocial.trader.TraderHandler;

public class  ShopMenu {
	public static Menu menu;
	public static Menu trademenu;
	private static Player p;
	
	public static void loadMenu(Menu menuAccount,Player p, CraftVillager shop) {
		ShopMenu.setP(p);
		ShopMenu.menu = menuAccount;
		
		ShopData shopdata = TraderHandler.getShop(shop); 	
		if(shopdata==null) return;
		if(shopdata.getItems()==null) return;
		
		int row=1;
		int col=0;
		
		for(ItemStack item: shopdata.getItems()){
			String name = "";
	        ItemMeta im = item.getItemMeta();
	        name = im.getDisplayName();
	        
			ShopItem menuItem = new ShopItem(name,item);	
			menuItem.setMat(item.getType());
			menuItem.setItem(item);
			menuItem.setDurability(item.getDurability());			
			List<String> menuItemlines = new LinkedList<String>();
			menuItemlines.add("Preise:");
			menuItemlines.add("------------");
			double price = Market.getPrice(item.getType().name()+":"+item.getDurability());
			menuItemlines.add("Kaufpreis: "+ Math.round(price));
			menuItemlines.add("Verkaufpreis: "+ Math.round(price*0.6));
			menuItem.setDescriptions(menuItemlines);
			ShopMenu.menu.addMenuItem(menuItem, row*col++);
			if(col==8){
				col=0;
				row++;
			}
		}		

	}
	
	public static void loadShopMenu(Player p, ItemStack item) {
		
		String name = "";
        ItemMeta im = item.getItemMeta();
        name = im.getDisplayName();
        if(name == null)
        	name = item.getType().name();
		
		Menu shopTradeMenu = new Menu(name,4);
		ShopMenu.trademenu = shopTradeMenu;
		Gui.switchMenu(p, ShopMenu.menu, ShopMenu.trademenu);
		double price = Market.getPrice(item.getType().name()+":"+item.getDurability());
		ShopBuyItem menuBuyItem = new ShopBuyItem(item.getType().toString(),item.getType());	
		List<String> menuBuyItemlines = new LinkedList<String>();
		menuBuyItemlines.add("Item kaufen 1x");
		menuBuyItemlines.add("Kaufpreis: " + price);
		menuBuyItem.setDescriptions(menuBuyItemlines);
		menuBuyItem.setMat(item.getType());
		menuBuyItem.setItem(item);
		menuBuyItem.setAmount(1);
		menuBuyItem.setBuy(price);	
		menuBuyItem.setSell(price*0.6);	
		ShopMenu.trademenu.addMenuItem(menuBuyItem, 12);
		
		ShopSellItem menuSellItem = new ShopSellItem(name,item.getType());	
		List<String> menuSellItemlines = new LinkedList<String>();	
		menuSellItemlines.add("Item verkaufen 1x");
		menuSellItemlines.add("Kaufpreis: " + price*64);
		menuSellItem.setDescriptions(menuSellItemlines);	
		menuSellItem.setMat(item.getType());
		menuSellItem.setItem(item);
		menuSellItem.setAmount(1);
		menuSellItem.setBuy(price);	
		menuSellItem.setSell(price*0.6);	
		ShopMenu.trademenu.addMenuItem(menuSellItem, 14);
		
		ShopBuyItem menuBuyItemStack = new ShopBuyItem(name,item.getType());	
		List<String> menuBuyItemStacklines = new LinkedList<String>();	
		menuBuyItemStacklines.add("Item kaufen 64x");
		menuBuyItemStacklines.add("Verkaufspreis: " + (price*0.6));
		menuBuyItemStack.setDescriptions(menuBuyItemStacklines);	
		menuBuyItemStack.setMat(item.getType());
		menuBuyItemStack.setItem(item);
		menuBuyItemStack.setAmount(64);	
		menuBuyItemStack.setBuy(price);	
		menuBuyItemStack.setSell(price*0.6);	
		ShopMenu.trademenu.addMenuItem(menuBuyItemStack, 21);
		
		ShopSellItem menuSellItemStack = new ShopSellItem(name,item.getType());
		List<String> menuSellItemStacklines = new LinkedList<String>();		
		menuSellItemStacklines.add("Item verkaufen 64x");
		menuSellItemStacklines.add("Verkaufspreis: " + (price*0.6)*64);
		menuSellItemStack.setDescriptions(menuSellItemStacklines);	
		menuSellItemStack.setMat(item.getType());
		menuSellItemStack.setItem(item);
		menuSellItemStack.setAmount(64);
		menuSellItemStack.setBuy(price);	
		menuSellItemStack.setSell(price*0.6);	
		ShopMenu.trademenu.addMenuItem(menuSellItemStack, 23);
		
		ShopBuyItem menuBack = new ShopBuyItem("zurück",Material.ENDER_PEARL);
		ShopMenu.trademenu.addMenuItem(menuBack, 35);
		

	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		ShopMenu.p = p;
	}
}
