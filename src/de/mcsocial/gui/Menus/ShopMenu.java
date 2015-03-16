package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Market;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.items.ShopBuyItem;
import de.mcsocial.gui.items.ShopItem;
import de.mcsocial.gui.items.ShopSellItem;
import de.mcsocial.trader.ShopData;
import de.mcsocial.trader.TraderHandler;

public class ShopMenu {
	public static Menu menu;
	public static Menu trademenu;
	private static Player p;
	
	public static void loadMenu(Menu menuAccount,Player p, CraftVillager shop) {
		ShopMenu.p = p;
		ShopMenu.menu = menuAccount;
		
		ShopData shopdata = TraderHandler.getShop(shop); 	
		if(shopdata==null) return;
		if(shopdata.getItems()==null) return;
		
		int row=1;
		int col=0;
		
		for(ItemStack item: shopdata.getItems()){
			ShopItem menuItem = new ShopItem(item.getType().toString(),item.getType());	
			menuItem.setMat(item.getType());
			List<String> menuItemlines = new LinkedList<String>();
			menuItemlines.add("Preise:");
			menuItemlines.add("------------");
			double price = Market.getPrice(item.getType());
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
	
	public static void loadShopMenu(Player p, Material mat) {
		
		Menu shopTradeMenu = new Menu(mat.toString(),4);
		ShopMenu.trademenu = shopTradeMenu;
		Gui.switchMenu(p, ShopMenu.menu, ShopMenu.trademenu);

		double price = Market.getPrice(mat);
		
		ShopBuyItem menuBuyItem = new ShopBuyItem(mat.toString(),mat);	
		List<String> menuBuyItemlines = new LinkedList<String>();
		menuBuyItemlines.add("Item kaufen 1x");
		menuBuyItemlines.add("Kaufpreis: "+ Math.round(price));
		menuBuyItem.setDescriptions(menuBuyItemlines);
		menuBuyItem.setMat(mat);
		menuBuyItem.setAmount(1);
		menuBuyItem.setBuy(Math.round(price));
		menuBuyItem.setSell(Math.round((price*0.6)));
		ShopMenu.trademenu.addMenuItem(menuBuyItem, 12);
		
		ShopSellItem menuSellItem = new ShopSellItem(mat.toString(),mat);	
		List<String> menuSellItemlines = new LinkedList<String>();	
		menuSellItemlines.add("Item verkaufen 1x");
		menuSellItemlines.add("Verkaufpreis: "+ Math.round((price*0.6)));
		menuSellItem.setDescriptions(menuSellItemlines);	
		menuSellItem.setMat(mat);
		menuSellItem.setAmount(1);
		menuSellItem.setBuy(Math.round(price));
		menuSellItem.setSell(Math.round((price*0.6)));
		ShopMenu.trademenu.addMenuItem(menuSellItem, 14);
		
		ShopBuyItem menuBuyItemStack = new ShopBuyItem(mat.toString(),mat);	
		List<String> menuBuyItemStacklines = new LinkedList<String>();	
		menuBuyItemStacklines.add("Item kaufen 64x");
		menuBuyItemStacklines.add("Kaufpreis: "+ Math.round(price*64));
		menuBuyItemStack.setDescriptions(menuBuyItemStacklines);	
		menuBuyItemStack.setMat(mat);
		menuBuyItemStack.setAmount(64);	
		menuBuyItemStack.setBuy(Math.round(price));
		menuBuyItemStack.setSell(Math.round((price*0.6)));
		ShopMenu.trademenu.addMenuItem(menuBuyItemStack, 21);
		
		ShopSellItem menuSellItemStack = new ShopSellItem(mat.toString(),mat);
		List<String> menuSellItemStacklines = new LinkedList<String>();		
		menuSellItemStacklines.add("Item verkaufen 64x");
		menuSellItemStacklines.add("Verkaufpreis: "+ Math.round((price*0.6)*64));
		menuSellItemStack.setDescriptions(menuSellItemStacklines);	
		menuSellItemStack.setMat(mat);
		menuSellItemStack.setAmount(64);
		menuSellItemStack.setBuy(Math.round(price));
		menuSellItemStack.setSell(Math.round((price*0.6)));
		ShopMenu.trademenu.addMenuItem(menuSellItemStack, 23);
		
		ShopBuyItem menuBack = new ShopBuyItem("zurück",Material.ENDER_PEARL);
		ShopMenu.trademenu.addMenuItem(menuBack, 35);
		

	}
}
