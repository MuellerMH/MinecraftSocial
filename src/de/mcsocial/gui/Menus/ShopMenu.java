package de.mcsocial.gui.Menus;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftVillager;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
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

public class ShopMenu {
	public static Menu menu;
	public static Menu trademenu;
	private static Player p;

	@SuppressWarnings("deprecation")
	public static void loadMenu(Menu menuAccount, Player p, CraftVillager shop) {
		ShopMenu.setP(p);
		ShopMenu.menu = menuAccount;

		ShopData shopdata = TraderHandler.getShop(shop);
		if (shopdata == null)
			return;
		if (shopdata.getItems() == null)
			return;

		int col = 0;

		for (ItemStack item : shopdata.getItems()) {
			item.setAmount(1);
			String name = "";
			ItemMeta im = item.getItemMeta();
			name = im.getDisplayName();

			ShopItem menuItem = new ShopItem(name, item);
			List<String> menuItemlines = new LinkedList<String>();
			menuItemlines.add("Preise:");
			menuItemlines.add("------------");
			double price = Market.getPrice(item.getType().name() + ":" + item.getDurability());
			menuItemlines.add("Kaufpreis: " + Math.max(1, Math.round(price)));
			menuItemlines.add("Verkaufpreis: " + Math.max(1, Math.round(price * 0.6)));

			menuItem.setMat(item.getType());
			menuItem.setItem(item);
			menuItem.setDurability(item.getDurability());
			menuItem.setDescriptions(menuItemlines);

			ShopMenu.menu.addMenuItem(menuItem, (col++));
		}

	}

	@SuppressWarnings("deprecation")
	public static void loadShopMenu(Player p, ItemStack item) {

		String name = "";
		item.setAmount(1);
		ItemMeta im = item.getItemMeta();
		name = im.getDisplayName();

		if (name == null)
			name = item.getType().name();

		Menu shopTradeMenu = new Menu(name, 4);
		ShopMenu.trademenu = shopTradeMenu;
		Gui.switchMenu(p, ShopMenu.menu, ShopMenu.trademenu);
		double price = Math.max(1, Market.getPrice(item.getType().name() + ":" + item.getDurability()));
		ShopBuyItem menuBuyItem = new ShopBuyItem(name, item);
		List<String> menuBuyItemlines = new LinkedList<String>();
		menuBuyItemlines.add("Item kaufen 1x");
		menuBuyItemlines.add("Kaufpreis: " + Math.round(Math.max(1, price)));
		menuBuyItem.setDescriptions(menuBuyItemlines);
		menuBuyItem.setMat(item.getType());
		menuBuyItem.setItem(item);
		menuBuyItem.setAmount(1);
		menuBuyItem.setBuy(Math.max(1, price));
		menuBuyItem.setSell(Math.max(1, price * 0.6));
		ShopMenu.trademenu.addMenuItem(menuBuyItem, 12);

		ShopSellItem menuSellItem = new ShopSellItem(name, item);
		List<String> menuSellItemlines = new LinkedList<String>();
		menuSellItemlines.add("Item verkaufen 1x");
		menuSellItemlines.add("Verkaufspreis: " + Math.round(Math.max(1, price * 0.6)));
		menuSellItem.setDescriptions(menuSellItemlines);
		menuSellItem.setMat(item.getType());
		menuSellItem.setItem(item);
		menuSellItem.setAmount(1);
		menuSellItem.setBuy(Math.max(1, price));
		menuSellItem.setSell(Math.max(1, price * 0.6));
		ShopMenu.trademenu.addMenuItem(menuSellItem, 14);

		item.setAmount(item.getMaxStackSize());

		ShopBuyItem menuBuyItemStack = new ShopBuyItem(name, item);
		List<String> menuBuyItemStacklines = new LinkedList<String>();
		menuBuyItemStacklines.add("Item kaufen " + item.getMaxStackSize() + "x");
		menuBuyItemStacklines.add("Kaufpreis: " + Math.round(Math.max(1, price * item.getMaxStackSize())));
		menuBuyItemStack.setDescriptions(menuBuyItemStacklines);
		menuBuyItemStack.setMat(item.getType());
		menuBuyItemStack.setItem(item);
		menuBuyItemStack.setAmount(item.getMaxStackSize());
		menuBuyItemStack.setBuy(Math.max(1, price));
		menuBuyItemStack.setSell(Math.max(1, price * 0.6));
		ShopMenu.trademenu.addMenuItem(menuBuyItemStack, 21);

		ShopSellItem menuSellItemStack = new ShopSellItem(name, item);
		List<String> menuSellItemStacklines = new LinkedList<String>();
		menuSellItemStacklines.add("Item verkaufen " + item.getMaxStackSize() + "x");
		menuSellItemStacklines.add("Verkaufspreis: " + Math.round(Math.max(1, price * 0.6) * item.getMaxStackSize()));
		menuSellItemStack.setDescriptions(menuSellItemStacklines);
		menuSellItemStack.setMat(item.getType());
		menuSellItemStack.setItem(item);
		menuSellItemStack.setAmount(item.getMaxStackSize());
		menuSellItemStack.setBuy(Math.max(1, price));
		menuSellItemStack.setSell(Math.max(1, price * 0.6));
		ShopMenu.trademenu.addMenuItem(menuSellItemStack, 23);

		ShopBuyItem menuBack = new ShopBuyItem("Zurück", new ItemStack(Material.ENDER_PEARL));
		ShopMenu.trademenu.addMenuItem(menuBack, 35);
		ShopMenu.trademenu.updateMenu();
		ShopMenu.menu.updateMenu();

	}

	public static Player getP() {
		return p;
	}

	public static void setP(Player p) {
		ShopMenu.p = p;
	}
}
