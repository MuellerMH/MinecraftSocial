package de.mcsocial.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * MenuItem
 *
 * An item in a menu. Displays like an ItemStack in an inventory, and activates
 * the onClick method when it is selected.
 *
 * @author XHawk87
 */
public abstract class MenuItem {

    private Menu menu;
    private int number;
    private ItemStack iconItem;
    private String text;
    private List<String> descriptions = new ArrayList<>();

    /**
     * Create a new menu item with the given title text on mouse over
     *
     * iconItem defaults to a piece of paper, and no number is displayed.
     *
     * @param text The title text to display on mouse over
     */

    /**
     * Create a new menu item with the given title text on mouse over, and using
     * the given MaterialData as its iconItem
     *
     * @param text The title text to display on mouse over
     * @param iconItem The material to use as its iconItem
     */
    public MenuItem(String text, ItemStack iconItem) {
        this(text, iconItem, 1);
    }

    /**
     * Create a new menu item with the given title text on mouseover, using the
     * given MaterialData as its iconItem, and displaying the given number
     *
     * @param text The title text to display on mouse over
     * @param iconItem2 The material to use as its iconItem
     * @param number The number to display on the item (must be greater than 1)
     */
    public MenuItem(String text, ItemStack iconItem2, int number) {
        this.text = text;
        this.iconItem = iconItem2;
        this.number = number;
    }

    protected void addToMenu(Menu menu) {
        this.menu = menu;
    }

    protected void removeFromMenu(Menu menu) {
        if (this.menu == menu) {
            this.menu = null;
        }
    }

    /**
     * Get the menu on which this item resides
     *
     * @return The popup menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Get the number displayed on this item. 1 for no number displayed
     *
     * @return The number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the MaterialData used as the iconItem for this menu item
     *
     * @return The iconItem
     */
    public ItemStack geticonItem() {
        return iconItem;
    }

    /**
     * Get the title text used as the mouse over text for this menu item
     *
     * @return The title text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the detailed description of a menu item to display on mouse over.
     *
     * Note that this does not automatically wrap text, so you must separate the
     * strings into lines
     *
     * @param lines The lines of text to display as a description
     */
    public void setDescriptions(List<String> lines) {
    	ItemMeta itemMeta = this.iconItem.getItemMeta();
        itemMeta.setDisplayName(this.text);
        itemMeta.setLore(lines);
        this.iconItem.setItemMeta(itemMeta);
        
    }

    /**
     * Adds an extra line to the description of the menu item to display on
     * mouse over.
     *
     * Note that this does not automatically wrap text, so you must separate the
     * strings into multiple lines if they are too long.
     *
     * @param line The line to add to the display text description
     */
    public void addDescription(String line) {
        descriptions.add(line);
    }

    @SuppressWarnings("deprecation")
	protected ItemStack getItemStack() {
        
        return this.iconItem;
    }

    /**
     * Called when a player clicks this menu item
     * 
     * @param player The clicking player
     */
    public abstract void onClick(Player player);

}
