package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;
import de.mcsocial.economy.Market;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.ShopMenu;

public class ShopSellItem extends MenuItem {
	private Material mat;
	private int amount;
	private double sell;
	private double buy;
	private ItemStack item;
	public ShopSellItem(String text, ItemStack icon) {

		super(text, icon);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(Player player) {
		if (!player.getInventory().contains(mat)) {
			player.sendMessage("Du besitzt dieses Item nicht.");
			return;
		}

		ItemStack[] itemStackArray = player.getInventory().getContents();
		for (ItemStack itemStack : itemStackArray) {
			if (itemStack == null) {
				continue;
			}
			if (itemStack.getType().equals(mat)) {

				int totalStack = Math.min(this.amount, itemStack.getAmount());
				double total = Math.round(this.sell * totalStack);

				Account.add(player, total);

				player.getInventory().removeItem(itemStack);
				itemStack.setAmount(itemStack.getAmount() - totalStack);
				player.getInventory().addItem(itemStack);
				player.updateInventory();

				Market.setPrice(item.getType().toString() + ":" + item.getDurability(), this.buy - (this.buy * 0.14));
				this.sell = Math.max(1, Market.getPrice(item.getType().toString() + ":" + item.getDurability()) * 0.6);
				this.buy = Math.max(1, Market.getPrice(item.getType().toString() + ":" + item.getDurability()));
				player.sendMessage("Verkauft für: " + total + " SD");

				ShopMenu.trademenu.updateMenu();
				ShopMenu.menu.updateMenu();
				return;
			}
		}

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
