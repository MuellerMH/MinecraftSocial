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
	
	public ShopBuyItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
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
		
		Market.setPrice(item.getType().toString()+":"+item.getDurability(), this.buy-(this.buy*0.01));

		player.sendMessage("Gekauft für: "+total+" SD");
		return;

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
