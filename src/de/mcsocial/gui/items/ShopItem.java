package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.ShopMenu;

public class ShopItem extends MenuItem {
	private Material mat;
	
	public ShopItem(String text) {
		super(text, new MaterialData(Material.MAP));
		// TODO Auto-generated constructor stub
	}

	public ShopItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub		
		ShopMenu.loadShopMenu(player, this.mat);

	}

	public void setMat(Material type) {
		this.mat = type;
		
	}
	

}
