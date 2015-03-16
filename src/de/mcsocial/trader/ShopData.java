package de.mcsocial.trader;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class ShopData {
	
	private List<ItemStack> shopItems;
	private String name;
	
	public List<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return shopItems;
	}
	public void setItems(List<ItemStack> itemStack) {
		// TODO Auto-generated method stub
		shopItems = itemStack;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
