package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.mcsocial.city.Resident;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.FirstTimeMenu;

public class FirstTimeItem  extends MenuItem {
	
	public FirstTimeItem(String text) {
		super(text, new MaterialData(Material.MAP));
		// TODO Auto-generated constructor stub
	}

	public FirstTimeItem(String text, Material materialData) {
		// TODO Auto-generated constructor stub
		super(text, new MaterialData( materialData));
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub
		Resident.addFolk(player, this.getText());
		player.sendMessage("Du bist nun ein " + this.getText() + "!");
		player.sendMessage("Wähle als nächstes dein Beruf!");
		player.sendMessage("Du findest alle Berufe im Spieler Menu. Tippe dafür einfach /m in den Chat");
		player.sendMessage("Dann solltest du dich zu dem Land deines Volkes gehen.");		
		player.sendMessage("Und nun viel Spass " + this.getText() + " hab viele Erfolge!" );	
		
		ItemStack woodPickaxe = new ItemStack(Material.WOOD_PICKAXE,1);
		player.getInventory().addItem(woodPickaxe);
		ItemStack woodAxe = new ItemStack(Material.WOOD_AXE,1);
		player.getInventory().addItem(woodAxe);
		ItemStack woodHOE = new ItemStack(Material.WOOD_HOE,1);
		player.getInventory().addItem(woodHOE);
		ItemStack cookies = new ItemStack(Material.COOKIE,10);
		player.getInventory().addItem(cookies);
		
		FirstTimeMenu.menu.closeMenu(player);
	}
	
}
