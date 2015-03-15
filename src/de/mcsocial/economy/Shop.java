package de.mcsocial.economy;

import java.util.UUID;

import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.inventory.ItemStack;

public class Shop {
	
	private String shopName,signText;
	private UUID owner;
	private Sign sign;
	private Chest chest;
	private ItemStack item;
	private Double priceBuy,priceSell;
	private Integer amount;
	private Boolean isAdmin,buyItem;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public UUID getOwner() {
		return owner;
	}
	public void setOwner(UUID owner) {
		this.owner = owner;
	}
	public Sign getSign() {
		return sign;
	}
	public void setSign(Sign sign) {
		this.sign = sign;
	}
	public Chest getChest() {
		return chest;
	}
	public void setChest(Chest chest) {
		this.chest = chest;
	}
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public Double getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(Double priceBuy) {
		this.priceBuy = priceBuy;
	}
	public Double getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(Double priceSell) {
		this.priceSell = priceSell;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Boolean getBuyItem() {
		return buyItem;
	}
	public void setBuyItem(Boolean buyItem) {
		this.buyItem = buyItem;
	}
	public String getSignText() {
		return signText;
	}
	public void setSignText(String signText) {
		this.signText = signText;
	}

}
