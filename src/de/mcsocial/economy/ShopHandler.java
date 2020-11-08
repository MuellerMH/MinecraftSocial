package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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

		e.getPlayer().sendMessage(e.getLine(0));
		if (!e.getLine(0).endsWith("Shop")) {
			e.getPlayer().sendMessage("Nur ein Schild");
			return;
		}

		Boolean buyItems = false;

		Shop shop = new Shop();
		shop.setOwner(e.getPlayer().getUniqueId());
		shop.setShopName(e.getPlayer().getName() + "'s Shop");
		shop.setIsAdmin(false);

		shop.setAmount(Integer.parseInt(e.getLine(2).replace("ï¿½0", "")));
		if (e.getPlayer().isOp()) {
			shop.setIsAdmin(true);
		}
		if (e.getLine(3).contains(":")) {
			buyItems = true;
		}
		shop.setBuyItem(true);
		shop.setSignText(e.getLine(1));

		if (buyItems) {
			shop.setPriceBuy(Double.parseDouble(e.getLine(3).split(":")[1].replace("ï¿½0", "")));
			shop.setPriceSell(Double.parseDouble(e.getLine(3).split(":")[0].replace("ï¿½0", "")));
		} else {
			shop.setPriceBuy(0.00);
			shop.setPriceSell(Double.parseDouble(e.getLine(3).replace("ï¿½0", "")));
		}

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
				shop.setChest(sellItem.get(e.getPlayer().getUniqueId()));
				e.getPlayer().sendMessage("Owner okay");
				ItemStack toSell = shop.getChest().getInventory().getContents()[0];

				if (toSell == null) {
					e.getPlayer().sendMessage("Die ausgewï¿½hlte Kiste ist lerr");
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
				e.getPlayer().sendMessage("Die ausgewï¿½hlte Kiste ist lerr");
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
		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (e.getPlayer().getInventory().contains(shop.getItem().getType())) {
				ItemStack[] itemStackArray = e.getPlayer().getInventory().getContents();
				for (ItemStack itemStack : itemStackArray) {
					if (itemStack == null) {
						e.getPlayer().sendMessage("itemStack ist null.");
						continue;
					}
					if (itemStack.getType().equals(shop.getItem().getType())) {
						if (e.getPlayer().isSneaking()) {
							int totalStack = itemStack.getAmount();
							double total = (shop.getPriceBuy() / shop.getAmount()) * totalStack;

							if (Account.getBalance(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer()) < total) {
								e.getPlayer().sendMessage("Verkï¿½ufer kann zur Zeit keine Ware ankaufen.");
								return true;
							}

							Account.remove(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer(), total);
							Account.add(e.getPlayer(), total);

							ItemStack giveAway = itemStack.clone();
							e.getPlayer().getInventory().removeItem(itemStack);
							itemStack.setAmount(itemStack.getAmount() - totalStack);
							e.getPlayer().getInventory().addItem(itemStack);
							giveAway.setAmount(totalStack);

							shop.getChest().getInventory().addItem(giveAway);

							e.getPlayer().updateInventory();

							e.getPlayer().sendMessage("Verkauft fï¿½r: " + total + " SD");

							return true;
						} else {
							int totalStack = shop.getAmount();
							double total = shop.getPriceBuy();

							if (Account.getBalance(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer()) < total) {
								e.getPlayer().sendMessage("Verkï¿½ufer kann zur Zeit keine Ware ankaufen.");
								return true;
							}

							Account.remove(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer(), total);
							Account.add(e.getPlayer(), total);

							ItemStack giveAway = itemStack.clone();
							e.getPlayer().getInventory().removeItem(itemStack);
							itemStack.setAmount(itemStack.getAmount() - totalStack);
							e.getPlayer().getInventory().addItem(itemStack);
							giveAway.setAmount(totalStack);

							shop.getChest().getInventory().addItem(giveAway);

							e.getPlayer().updateInventory();

							Account.remove(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer(), total);
							Account.add(e.getPlayer(), total);

							e.getPlayer().sendMessage("Verkauft fï¿½r: " + total + " SD");

							return true;
						}

					}
				}
			}
			e.getPlayer().sendMessage("Du hast dieses Item nicht mehr.");
			return true;

		}
		return false;
	}

	private boolean buyAction(PlayerInteractEvent e) {
		shop = getShop(e);
		if (shop == null)
			return false;
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			e.getPlayer().sendMessage("Kaufe: " + shop.getItem().toString());
			if (shop.getChest().getInventory().contains(shop.getItem().getType())) {
				ItemStack[] itemStackArray = shop.getChest().getInventory().getContents();
				for (ItemStack itemStack : itemStackArray) {
					if (itemStack == null) {
						e.getPlayer().sendMessage("itemStack ist null.");
						continue;
					}
					if (itemStack.getType().equals(shop.getItem().getType())) {
						if (e.getPlayer().isSneaking()) {

							int totalStack = itemStack.getAmount();
							double total = (shop.getPriceSell() / shop.getAmount()) * totalStack;

							if (Account.getBalance(e.getPlayer()) < total) {
								e.getPlayer().sendMessage("Du hast nicht genï¿½gend Geld.");
								return true;
							}

							Account.add(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer(), total);
							Account.remove(e.getPlayer(), total);

							ItemStack giveAway = itemStack.clone();
							shop.getChest().getInventory().removeItem(itemStack);
							itemStack.setAmount(itemStack.getAmount() - totalStack);
							shop.getChest().getInventory().addItem(itemStack);
							giveAway.setAmount(totalStack);

							e.getPlayer().getInventory().addItem(giveAway);
							e.getPlayer().updateInventory();

							e.getPlayer().sendMessage("Gekauft fï¿½r: " + total + " SD");

							return true;
						} else {
							int totalStack = shop.getAmount();
							double total = shop.getPriceSell();

							if (Account.getBalance(e.getPlayer()) < total) {
								e.getPlayer().sendMessage("Du hast nicht genï¿½gend Geld.");
								return true;
							}

							Account.add(Bukkit.getOfflinePlayer(shop.getOwner()).getPlayer(), total);
							Account.remove(e.getPlayer(), total);

							ItemStack giveAway = itemStack.clone();
							shop.getChest().getInventory().removeItem(itemStack);
							itemStack.setAmount(itemStack.getAmount() - totalStack);
							shop.getChest().getInventory().addItem(itemStack);
							giveAway.setAmount(totalStack);

							e.getPlayer().getInventory().addItem(giveAway);
							e.getPlayer().updateInventory();

							e.getPlayer().sendMessage("Gekauft fï¿½r: " + total + " SD");

							return true;
						}

					}
				}
			}

			e.getPlayer().sendMessage("Dieser Shop ist ausverkauft!.");
			return true;
		}
		return false;
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void destroy(String string) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM MCS_shop WHERE sign = ? ";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {

			preparedStmt.setString(1, string);
			MySQL.insertDB(preparedStmt);
			// System.out.println("Lï¿½sche " + string);

			if (ShopHandler.shops == null) {
				return;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void destroy(Sign state) {
		// TODO Auto-generated method stub

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
			// System.out.println("Lï¿½sche "+x +","+z+","+y);

			if (ShopHandler.shops == null) {
				return;
			}
			ShopHandler.shops.remove(state);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
