package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;
import de.mcsocial.economy.Market;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.ShopMenu;

public class ShopBuyItem extends MenuItem {
	private Material mat;
	private int amount;
	private double sell;
	private double buy;
	private ItemStack item;
	public ShopBuyItem(String text, ItemStack icon) {

		super(text, icon);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(Player player) {

		if (this.getText().equalsIgnoreCase("zurück")) {
			Gui.switchMenu(player, ShopMenu.trademenu, ShopMenu.menu);
			return;
		}

		int totalStack = this.amount;
		double total = Math.round(this.buy * totalStack);

		if (Account.getBalance(player) < total) {
			player.sendMessage("Du hast nicht genügend Geld.");
			return;
		}

		Account.remove(player, total);
		ItemStack item = getItem();

		ItemStack sellItem = new ItemStack(item.getType(), 1, item.getDurability());
		sellItem.setAmount(this.amount);
		player.getInventory().addItem(sellItem);
		player.updateInventory();

		Market.setPrice(item.getType().toString() + ":" + item.getDurability(), this.buy + (this.buy * 0.10));
		this.sell = Math.max(1, Market.getPrice(item.getType().toString() + ":" + item.getDurability()) * 0.6);
		this.buy = Math.max(1, Market.getPrice(item.getType().toString() + ":" + item.getDurability()));
		player.sendMessage("Gekauft für: " + total + " SD");

		ShopMenu.trademenu.updateMenu();
		ShopMenu.menu.updateMenu();
		return;

	}

	public ItemStack getItem() {
		return this.item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double d) {
		this.sell = d;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double price) {
		this.buy = price;
	}

	public void setMat(Material mat) {

		this.mat = mat;
	}

	public Material getMat() {

		return this.mat;
	}

	public void setItem(ItemStack item) {

		this.item = item;
	}

}
