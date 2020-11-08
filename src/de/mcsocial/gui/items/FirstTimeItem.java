package de.mcsocial.gui.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.city.Resident;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.FirstTimeMenu;

<<<<<<< HEAD
public class FirstTimeItem  extends MenuItem {
	
	
	public FirstTimeItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
=======
public class FirstTimeItem extends MenuItem {

	public FirstTimeItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon, 1));
>>>>>>> b4ade11... add new directory
	}

	@Override
	public void onClick(Player player) {
		// TODO Auto-generated method stub
		Resident.addFolk(player, this.getText());
		player.sendMessage("Du bist nun ein " + this.getText() + "!");
<<<<<<< HEAD
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
	
=======
		player.sendMessage("Wï¿½hle als nï¿½chstes dein Beruf!");
		player.sendMessage("Du findest alle Berufe im Spieler Menu. Tippe dafï¿½r einfach /m in den Chat");
		player.sendMessage("Dann solltest du dich zu dem Land deines Volkes gehen.");
		player.sendMessage("Und nun viel Spass " + this.getText() + " hab viele Erfolge!");

		ItemStack woodPickaxe = new ItemStack(Material.WOODEN_PICKAXE, 1);
		player.getInventory().addItem(woodPickaxe);
		ItemStack woodAxe = new ItemStack(Material.WOODEN_AXE, 1);
		player.getInventory().addItem(woodAxe);
		ItemStack woodHOE = new ItemStack(Material.WOODEN_HOE, 1);
		player.getInventory().addItem(woodHOE);
		ItemStack cookies = new ItemStack(Material.COOKIE, 10);
		player.getInventory().addItem(cookies);

		FirstTimeMenu.menu.closeMenu(player);
	}

>>>>>>> b4ade11... add new directory
}
