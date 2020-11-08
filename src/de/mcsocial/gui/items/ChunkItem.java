package de.mcsocial.gui.items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.CityMenu;
import de.mcsocial.gui.Menus.Hauptmenu;

public class ChunkItem extends MenuItem {

	private Location loc;
	private ConversationFactory conversationFactory;
	public static String cityName = null;




	public ChunkItem(String text, Material icon) {

		super(text, new ItemStack(icon,1));
	}

	public void setLocation(Location loc){
		this.setLoc(loc);
	}

	@Override
	public void onClick(Player p) {

		switch(this.getText()){

			case "Hauptmenu":

				Gui.switchMenu(p, CityMenu.menu, Hauptmenu.menu);
				break;
		   default:
			   p.sendMessage("In Arbeit");
			   break;
		}

	}

	public ConversationFactory getConversationFactory() {
		return conversationFactory;
	}

	public void setConversationFactory(ConversationFactory conversationFactory) {
		this.conversationFactory = conversationFactory;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

}

