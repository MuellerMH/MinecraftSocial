package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.ShopMenu;

public class ShopItem extends MenuItem {
	private ItemStack item;
	public ShopItem(String text, Material icon) {

		super(text, new ItemStack(icon,1));
	}


	public ShopItem(String text, ItemStack item) {

		super(text, item);
	}

	@Override
	public void onClick(Player player) {

		ShopMenu.loadShopMenu(player, this.item);

	}

	public void setItem(ItemStack item) {
		this.item = item;

	}

	public void setMat(Material type) {

	}

	public void setDurability(short durability) {

	}


}
