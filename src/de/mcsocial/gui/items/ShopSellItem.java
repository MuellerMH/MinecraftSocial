package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;
import de.mcsocial.economy.Market;
import de.mcsocial.gui.MenuItem;

public class ShopSellItem extends MenuItem {
	private Material mat;
	private int amount;
	private double sell;
	private double buy;
	private ItemStack item;
	
	public ShopSellItem(String text, ItemStack icon) {
		// TODO Auto-generated constructor stub
		super(text, icon);
	}
	
	@Override
	public void onClick(Player player) {
		if(!player.getInventory().contains(mat)) {
			player.sendMessage("Du besitzt dieses Item nicht.");
			return;
		}
		
		ItemStack[] itemStackArray = player.getInventory().getContents();
		for(ItemStack itemStack: itemStackArray){
			if(itemStack == null){
				continue;
			}
			if(itemStack.getType().equals(mat)){	
				
				int totalStack = Math.min(this.amount,itemStack.getAmount());				
				double total = this.sell*totalStack;
						
				Account.add(player, total);
				
				player.getInventory().removeItem(itemStack);
				itemStack.setAmount(itemStack.getAmount()-totalStack);
				player.getInventory().addItem(itemStack);				
				player.updateInventory();
		
				player.sendMessage("Verkauft für: "+total+" SD");
				Market.setPrice(itemStack.getType().toString()+":"+itemStack.getDurability(), this.buy+(this.buy*0.01));
				return;
			}
		}

	}
	
	public ItemStack getItem(){
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
		// TODO Auto-generated method stub
		this.mat = mat;
	}

	public Material getMat() {
		// TODO Auto-generated method stub
		return this.mat;
	}

	public void setItem(ItemStack item) {
		// TODO Auto-generated method stub
		this.item = item;
	}
	

}
