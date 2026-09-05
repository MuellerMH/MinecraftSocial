package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.main.MySQL;

public class ShopHandler implements Listener {

	private HashMap<UUID, Chest> sellItem;
	private static HashMap<Sign, Shop> shops;
	private Block block;
	private Sign sign;
	private Shop shop;

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (ShopHandler.shops == null) {
			ShopHandler.shops = new HashMap<Sign, Shop>();
		}

		if (!e.getLine(0).toLowerCase().endsWith("shop")) {
			return;
		}

		int amount;
		double priceSell;
		double priceBuy = 0.00;
		try {
			amount = Integer.parseInt(e.getLine(2).split(":")[0]);
			String[] prices = e.getLine(3).split(":");
			priceSell = Double.parseDouble(prices[0]);
			if (prices.length > 1) {
				priceBuy = Double.parseDouble(prices[1]);
			}
		} catch (NumberFormatException ex) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("Shop-Schild: Menge und Preise müssen Zahlen sein.");
			return;
		}

		if (amount <= 0 || priceSell < 0 || priceBuy < 0) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("Shop-Schild: Menge und Preise müssen gültig sein.");
			return;
		}

		Shop shop = new Shop();
		shop.setOwner(e.getPlayer().getUniqueId());
		shop.setShopName(e.getPlayer().getName() + "'s Shop");
		shop.setIsAdmin(false);

		shop.setAmount(amount);
		if (e.getPlayer().isOp()) {
			shop.setIsAdmin(true);
		}
		shop.setBuyItem(priceBuy > 0);
		shop.setSignText(e.getLine(1));
		shop.setPriceBuy(priceBuy);
		shop.setPriceSell(priceSell);

		e.setLine(0, e.getPlayer().getName() + "'s Shop");
		e.setLine(1, "Makiere nun mit");
		e.setLine(2, "Redstone die");
		e.setLine(3, "Kiste");
		ShopHandler.shops.put((Sign) e.getBlock().getState(), shop);
		return;
	}

	public static Boolean isShop(Sign sign) {
		if (ShopHandler.shops == null) {
			ShopHandler.shops = new HashMap<Sign, Shop>();
		}

		return ShopHandler.shops.containsKey(sign);

	}

	@SuppressWarnings("deprecation")
	private Boolean setShopSign(PlayerInteractEvent e) {

		block = e.getClickedBlock();
		sign = (Sign) block.getState();

		shop = ShopHandler.shops.get(sign);
		if (e.getPlayer().getItemInHand().getType().equals(Material.GLOWSTONE_DUST) && e.getPlayer().isOp()) {
			if (shop.getChest() == null || shop.getItem() == null) {
				e.getPlayer().sendMessage("Dieser Shop wurde noch nicht eingerichtet.");
				return true;
			}
			e.getPlayer().sendMessage("---------------------------------");
			e.getPlayer().sendMessage("Shop Informationen");
			e.getPlayer().sendMessage("---------------------------------");

			e.getPlayer().sendMessage(shop.getShopName());
			e.getPlayer().sendMessage(Bukkit.getOfflinePlayer(shop.getOwner()).getName());
			e.getPlayer().sendMessage(Bukkit.getOfflinePlayer(shop.getOwner()).getName());
			e.getPlayer().sendMessage(shop.getChest().getLocation().toString());
			e.getPlayer().sendMessage(shop.getItem().getType().toString());

			e.getPlayer().sendMessage("---------------------------------");
			return true;
		}

		if (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE)) {
			e.getPlayer().sendMessage("Redstone okay");
			if (e.getPlayer().getUniqueId().equals(shop.getOwner())) {
				if (sellItem == null || !sellItem.containsKey(e.getPlayer().getUniqueId())) {
					e.getPlayer().sendMessage("Wähle zuerst eine Kiste mit Redstone aus.");
					return true;
				}
				shop.setChest(sellItem.get(e.getPlayer().getUniqueId()));
				e.getPlayer().sendMessage("Owner okay");
				ItemStack toSell = shop.getChest().getInventory().getContents()[0];

				if (toSell == null) {
					e.getPlayer().sendMessage("Die ausgewählte Kiste ist lerr");
					return true;
				}
				shop.setSign(sign);
				shop.setItem(toSell);
				sign.setLine(0, shop.getShopName());
				sign.setLine(1, shop.getSignText());
				sign.setLine(2, shop.getAmount() + "x " + toSell.getType());
				sign.setLine(3, "B: " + shop.getPriceSell() + " S: " + shop.getPriceBuy());
				sign.update();

				ShopHandler.shops.put(sign, shop);
				save(shop);

				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	private Boolean setupShopChest(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE)) {
			if (sellItem == null) {
				sellItem = new HashMap<UUID, Chest>();
			}

			Chest chest = (Chest) block.getState();
			ItemStack toSell = chest.getInventory().getContents()[0];
			if (toSell == null) {
				e.getPlayer().sendMessage("Die ausgewählte Kiste ist lerr");
				return true;
			}
			e.getPlayer().sendMessage("Verkauft wird " + toSell.getType());
			e.getPlayer().sendMessage("Klicke nun auf das Verkaufsschild.");
			sellItem.put(e.getPlayer().getUniqueId(), chest);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (ShopHandler.shops == null) {
			ShopHandler.shops = new HashMap<Sign, Shop>();
		}

		block = e.getClickedBlock();
		if (block == null)
			return;
		if (block.getType().equals(Material.LEGACY_SIGN) || block.getType().equals(Material.LEGACY_SIGN_POST)
				|| block.getType().equals(Material.LEGACY_WALL_SIGN)) {

			Sign sign = (Sign) block.getState();
			if (ShopHandler.shops.containsKey(sign)) {
				if (setShopSign(e)) {
					return;
				}
				if (buyAction(e)) {
					return;
				}
				if (sellAction(e)) {
					return;
				}
				return;
			}

		} else if (block.getType().equals(Material.CHEST) || block.getType().equals(Material.TRAPPED_CHEST)) {
			if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if (setupShopChest(e)) {
					return;
				}
			}
			return;
		}
		return;
	}

	private Shop getShop(PlayerInteractEvent e) {
		block = e.getClickedBlock();
		sign = (Sign) block.getState();
		return ShopHandler.shops.get(sign);
	}

	private boolean sellAction(PlayerInteractEvent e) {
		shop = getShop(e);
		if (shop == null)
			return false;
		if (shop.getChest() == null || shop.getItem() == null) {
			e.getPlayer().sendMessage("Dieser Shop wurde noch nicht eingerichtet.");
			return true;
		}
		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player owner = Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer();
			if (owner == null) {
				e.getPlayer().sendMessage("Der Shopbesitzer muss online sein.");
				return true;
			}
			int available = countItems(e.getPlayer().getInventory(), shop.getItem());
			int totalStack = e.getPlayer().isSneaking() ? available : shop.getAmount();
			if (shop.getPriceBuy() <= 0 || totalStack <= 0 || available < totalStack) {
				e.getPlayer().sendMessage("Du hast dieses Item nicht mehr.");
				return true;
			}
			double total = (shop.getPriceBuy() / shop.getAmount()) * totalStack;
			if (Account.getBalance(owner) < total) {
				e.getPlayer().sendMessage("Der Verkäufer kann zur Zeit keine Ware ankaufen.");
				return true;
			}
			if (!moveItems(e.getPlayer().getInventory(), shop.getChest().getInventory(), shop.getItem(), totalStack)) {
				e.getPlayer().sendMessage("Die Shopkiste ist voll.");
				return true;
			}
			Account.remove(owner, total);
			Account.add(e.getPlayer(), total);
			e.getPlayer().updateInventory();
			e.getPlayer().sendMessage("Verkauft für: " + total + " SD");
			return true;

		}
		return false;
	}

	private boolean buyAction(PlayerInteractEvent e) {
		shop = getShop(e);
		if (shop == null)
			return false;
		if (shop.getChest() == null || shop.getItem() == null) {
			e.getPlayer().sendMessage("Dieser Shop wurde noch nicht eingerichtet.");
			return true;
		}
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player owner = Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer();
			int available = countItems(shop.getChest().getInventory(), shop.getItem());
			int totalStack = e.getPlayer().isSneaking() ? available : shop.getAmount();
			if (shop.getPriceSell() <= 0 || totalStack <= 0 || available < totalStack) {
				e.getPlayer().sendMessage("Dieser Shop ist ausverkauft!.");
				return true;
			}
			double total = (shop.getPriceSell() / shop.getAmount()) * totalStack;
			if (Account.getBalance(e.getPlayer()) < total) {
				e.getPlayer().sendMessage("Du hast nicht genügend Geld.");
				return true;
			}
			if (owner == null || !moveItems(shop.getChest().getInventory(), e.getPlayer().getInventory(), shop.getItem(), totalStack)) {
				e.getPlayer().sendMessage("Dein Inventar ist voll oder der Shopbesitzer ist offline.");
				return true;
			}
			Account.add(owner, total);
			Account.remove(e.getPlayer(), total);
			e.getPlayer().updateInventory();
			e.getPlayer().sendMessage("Gekauft für: " + total + " SD");
			return true;
		}
		return false;
	}

	private int countItems(Inventory inventory, ItemStack item) {
		int amount = 0;
		for (ItemStack stack : inventory.getContents()) {
			if (stack != null && stack.isSimilar(item)) {
				amount += stack.getAmount();
			}
		}
		return amount;
	}

	private boolean moveItems(Inventory source, Inventory target, ItemStack item, int amount) {
		ItemStack[] sourceContents = cloneContents(source.getContents());
		ItemStack[] targetContents = cloneContents(target.getContents());
		List<ItemStack> moved = new ArrayList<ItemStack>();
		int remaining = amount;
		for (int slot = 0; slot < source.getContents().length && remaining > 0; slot++) {
			ItemStack stack = source.getItem(slot);
			if (stack == null || !stack.isSimilar(item)) {
				continue;
			}
			int take = Math.min(remaining, stack.getAmount());
			ItemStack part = stack.clone();
			part.setAmount(take);
			moved.add(part);
			remaining -= take;
			if (take == stack.getAmount()) {
				source.setItem(slot, null);
			} else {
				stack.setAmount(stack.getAmount() - take);
				source.setItem(slot, stack);
			}
		}
		if (remaining > 0) {
			source.setContents(sourceContents);
			return false;
		}
		for (ItemStack stack : moved) {
			if (!target.addItem(stack).isEmpty()) {
				source.setContents(sourceContents);
				target.setContents(targetContents);
				return false;
			}
		}
		return true;
	}

	private ItemStack[] cloneContents(ItemStack[] contents) {
		ItemStack[] copy = new ItemStack[contents.length];
		for (int i = 0; i < contents.length; i++) {
			copy[i] = contents[i] == null ? null : contents[i].clone();
		}
		return copy;
	}

	@SuppressWarnings("deprecation")
	private void save(Shop shop) {
		String sql = "INSERT INTO MCS_shop" + "(" + "shopName," + "owner," + "sign," + "chest," + "item," + "admin,"
				+ "amount," + "buyItems," + "signText," + "pricesell," + "pricebuy" + ")VALUES(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?" + ");";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, shop.getShopName());
			preparedStmt.setString(2, shop.getOwner().toString());
			preparedStmt.setString(3, shop.getSign().getLocation().getBlockX() + ","
					+ shop.getSign().getLocation().getBlockZ() + "," + shop.getSign().getLocation().getBlockY());
			preparedStmt.setString(4, shop.getChest().getLocation().getBlockX() + ","
					+ shop.getChest().getLocation().getBlockZ() + "," + shop.getChest().getLocation().getBlockY());
			preparedStmt.setString(5, shop.getItem().getType() + ":" + shop.getItem().getDurability());
			preparedStmt.setBoolean(6, shop.getIsAdmin());
			preparedStmt.setInt(7, shop.getAmount());
			preparedStmt.setBoolean(8, shop.getBuyItem());
			preparedStmt.setString(9, shop.getSignText());
			preparedStmt.setDouble(10, shop.getPriceSell());
			preparedStmt.setDouble(11, shop.getPriceBuy());
			MySQL.insertDB(preparedStmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void load() {
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT " + "shopName," + "owner," + "sign," + "chest," + "item,"
				+ "admin," + "amount," + "buyItems," + "signText," + "pricesell," + "pricebuy" + " FROM MCS_shop");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);
			if (result == null) {
				return;
			}
			if (ShopHandler.shops == null) {
				ShopHandler.shops = new HashMap<Sign, Shop>();
			}

			while (result.next()) {
				String[] position = result.getString("sign").split(",");
				int x, z, y;
				x = Integer.parseInt(position[0]);
				z = Integer.parseInt(position[1]);
				y = Integer.parseInt(position[2]);
				// System.out.println("Block suchen an Position "+x+" "+z+" "+y);
				Location locSign = new Location(Bukkit.getWorld("world"), x, y, z);
				Block block = locSign.getBlock();
				if (block.getType().equals(Material.LEGACY_SIGN) || block.getType().equals(Material.LEGACY_SIGN_POST)
						|| block.getType().equals(Material.LEGACY_WALL_SIGN)) {
					Sign sign = (Sign) block.getState();

					Location locChest = new Location(Bukkit.getWorld("world"),
							Integer.parseInt(result.getString("chest").split(",")[0]),
							Integer.parseInt(result.getString("chest").split(",")[2]),
							Integer.parseInt(result.getString("chest").split(",")[1]));
					Chest chest = (Chest) locChest.getBlock().getState();
					Material mat = Material.getMaterial(result.getString("item").split(":")[0]);
					ItemStack item = new ItemStack(mat, 1, (short) Integer.parseInt(result.getString("item").split(":")[1]));
					Shop shop = new Shop();
					shop.setChest(chest);
					shop.setSign(sign);
					shop.setItem(item);
					shop.setAmount(result.getInt("amount"));
					shop.setIsAdmin(result.getBoolean("admin"));
					shop.setOwner(UUID.fromString(result.getString("owner")));
					shop.setShopName(result.getString("shopName"));
					shop.setSignText(result.getString("signText"));
					shop.setBuyItem(result.getBoolean("buyItems"));
					shop.setPriceBuy(result.getDouble("pricebuy"));
					shop.setPriceSell(result.getDouble("pricesell"));
					ShopHandler.shops.put(sign, shop);
				} else {
					// System.out.println("Shop "+result.getString("shopName")+" auf position
					// "+result.getString("sign")+" konnte nicht geladen werden.");
					// System.out.println("Block an Position "+block.getLocation()+" ist ein "+
					// block.getType().toString());
					destroy(x + " " + z + " " + y);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void destroy(String string) {
		String sql = "DELETE FROM MCS_shop WHERE sign = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {

			preparedStmt.setString(1, string);
			MySQL.insertDB(preparedStmt);

			if (ShopHandler.shops == null) {
				return;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void destroy(Sign state) {
		String sql = "DELETE FROM MCS_shop WHERE sign = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {

			Location position = state.getLocation();
			double x, z, y;
			x = position.getBlockX();
			z = position.getBlockZ();
			y = position.getBlockY();

			preparedStmt.setString(1, x + "," + z + "," + y);
			MySQL.insertDB(preparedStmt);

			if (ShopHandler.shops == null) {
				return;
			}
			ShopHandler.shops.remove(state);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
