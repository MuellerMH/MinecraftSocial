package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.mcsocial.economy.Account;
import de.mcsocial.economy.Market;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.ShopMenu;

public class ShopBuyItem extends MenuItem {
	private Material mat;
	private int amount;
	private float sell;
	private float buy;
	
	public ShopBuyItem(String text) {
		super(text, new MaterialData(Material.MAP));
		// TODO Auto-generated constructor stub
	}

	public ShopBuyItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub		
		if(this.getText().equalsIgnoreCase("zurück")){
			Gui.switchMenu(player, ShopMenu.trademenu, ShopMenu.menu);
			return;
		}

		
		int totalStack = this.amount;				
		double total = this.sell*totalStack;
		
		if(Account.getBalance(player) < total){
			player.sendMessage("Du hast nicht genügend Geld.");
			return;
		}

				
		Account.remove(player, total);
		ItemStack item = getItem();
		item.setAmount(this.amount);
		player.getInventory().addItem(item);				
		player.updateInventory();
		
		Market.setPrice(this.mat, this.buy-(this.buy*0.01));

		player.sendMessage("Gekauft für: "+total+" SD");
		return;

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
