package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.mcsocial.economy.Account;
import de.mcsocial.economy.Market;
import de.mcsocial.gui.MenuItem;

public class ShopSellItem extends MenuItem {
	private Material mat;
	private int amount;
	private float sell;
	private float buy;
	
	public ShopSellItem(String text) {
		super(text, new MaterialData(Material.MAP));
		// TODO Auto-generated constructor stub
	}

	public ShopSellItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
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
				Market.setPrice(this.mat, this.buy+(this.buy*0.01));
				return;
			}
		}

	}
	
	public ItemStack getItem(){
		return new ItemStack(this.mat);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getSell() {
		return sell;
	}

	public void setSell(float sell) {
		this.sell = sell;
	}

	public float getBuy() {
		return buy;
	}

	public void setBuy(float buy) {
		this.buy = buy;
	}

	public void setMat(Material mat) {
		// TODO Auto-generated method stub
		this.mat = mat;
	}

	public Material getMat() {
		// TODO Auto-generated method stub
		return this.mat;
	}
	

}
