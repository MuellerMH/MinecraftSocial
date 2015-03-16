package de.mcsocial.gui;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.main.MCSocial;

public class Gui implements Listener, CommandExecutor {

	
	private static Plugin instance = MCSocial.instance;
	public String title = "";
	public int rows = 3;
	
	public Gui (String title, int rows)
	{
		this.rows = rows;
		this.title = title;
	}

    /**
     * Create a new pop-up menu and stores it for later use
     *
     * @param title The menu title
     * @param rows The number of rows on the menu
     * @return The menu
     */
    public static Menu createMenu(String title, int rows) {
        return new Menu(title, rows);
    }

    /**
     * Creates an exact copy of an existing pop-up menu. This is intended to be
     * used for creating dynamic pop-up menus for individual players. Be sure to
     * call destroyMenu for menus that are no longer needed.
     *
     * @param menu The menu to clone
     * @return The cloned copy
     */
    public static Menu cloneMenu(Menu menu) {
        return menu.clone();
    }

    /**
     * Destroys an existing menu, and closes it for any viewers
     *
     * Please note: you should not store any references to destroyed menus
     *
     * @param menu The menu to destroy
     */
    public static void removeMenu(Menu menu) {
        for (HumanEntity viewer : menu.getInventory().getViewers()) {
            if (viewer instanceof Player) {
                menu.closeMenu((Player) viewer);
            } else {
                viewer.closeInventory();
            }
        }
    }

    /**
     * Due to a bug with inventories, switching from one menu to another in the
     * same tick causes glitchiness. In order to prevent this, the opening must
     * be done in the next tick. This is a convenience method to perform this
     * task for you.
     *
     * @param player The player switching menus
     * @param fromMenu The menu the player is currently viewing
     * @param toMenu The menu the player is switching to
     */
    public static void switchMenu(final Player player, Menu fromMenu, final Menu toMenu) {
        fromMenu.closeMenu(player);
        new BukkitRunnable() {
            @Override
            public void run() {
                toMenu.openMenu(player);
            }
        }.runTask(instance);
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onMenuItemClicked(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getHolder() instanceof Menu) {
            Menu menu = (Menu) inventory.getHolder();
            if (event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                if (event.getSlotType() == InventoryType.SlotType.OUTSIDE) {
                    // Quick exit for a menu, click outside of it
                    if (menu.exitOnClickOutside()) {
                        menu.closeMenu(player);
                    }
                } else {
                    int index = event.getRawSlot();
                    if (index < inventory.getSize()) {
                        menu.selectMenuItem(player, index);
                    } else {
                        // If they want to mess with their inventory they don't need to do so in a menu
                        if (menu.exitOnClickOutside()) {
                            menu.closeMenu(player);
                        }
                    }
                }
            }
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onMenuClosed(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player) {
            Inventory inventory = event.getInventory();
            if (inventory.getHolder() instanceof Menu) {
                Menu menu = (Menu) inventory.getHolder();
                MenuCloseBehaviour menuCloseBehaviour = menu.getMenuCloseBehaviour();
                if (menuCloseBehaviour != null) {
                    menuCloseBehaviour.onClose((Player) event.getPlayer());
                }
            }
        }
    }
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("Menu")) {
			Menu menu = createMenu(title,rows);
			Hauptmenu.loadMenu(menu,p);
			menu.openMenu(p);
			return true;
		}
		return false;
	}
}
