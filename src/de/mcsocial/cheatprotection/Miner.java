package de.mcsocial.cheatprotection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.main.MySQL;

public class Miner implements Listener, CommandExecutor {
	public static HashMap<UUID, Integer> counterDias;
	public static HashMap<UUID, Integer> counterGold;
	public static HashMap<UUID, Integer> counterIron;
	public static HashMap<UUID, Integer> counterRedstone;
	public static HashMap<UUID, Integer> counterCoal;
	public static HashMap<UUID, Integer> counterLapis;
	public static HashMap<UUID, Integer> counterAll;

	public Miner() {
		Miner.counterDias = new HashMap<UUID, Integer>();
		Miner.counterGold = new HashMap<UUID, Integer>();
		Miner.counterIron = new HashMap<UUID, Integer>();
		Miner.counterRedstone = new HashMap<UUID, Integer>();
		Miner.counterCoal = new HashMap<UUID, Integer>();
		Miner.counterLapis = new HashMap<UUID, Integer>();
		Miner.counterAll = new HashMap<UUID, Integer>();

	}

	public static void loadMinerData() {
		Miner.counterDias = new HashMap<UUID, Integer>();
		Miner.counterGold = new HashMap<UUID, Integer>();
		Miner.counterIron = new HashMap<UUID, Integer>();
		Miner.counterRedstone = new HashMap<UUID, Integer>();
		Miner.counterCoal = new HashMap<UUID, Integer>();
		Miner.counterLapis = new HashMap<UUID, Integer>();
		Miner.counterAll = new HashMap<UUID, Integer>();
		try {
			ResultSet result = null;

			ResultSet result11 = null;
			PreparedStatement preparedStmt11 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt11.setString(1, "lapis");
			result11 = MySQL.callDB(preparedStmt11);

			while (result11.next()) {
				Miner.counterLapis.put(UUID.fromString(result11.getString("player")), result11.getInt("count"));
			}

			ResultSet result111 = null;
			PreparedStatement preparedStmt111 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt111.setString(1, "coal");
			result111 = MySQL.callDB(preparedStmt111);

			while (result111.next()) {
				Miner.counterCoal.put(UUID.fromString(result111.getString("player")), result111.getInt("count"));
			}

			ResultSet result1111 = null;
			PreparedStatement preparedStmt1111 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt1111.setString(1, "redstone");
			result1111 = MySQL.callDB(preparedStmt1111);

			while (result1111.next()) {
				Miner.counterRedstone.put(UUID.fromString(result1111.getString("player")), result1111.getInt("count"));
			}

			PreparedStatement preparedStmt = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt.setString(1, "diamant");
			result = MySQL.callDB(preparedStmt);

			while (result.next()) {
				Miner.counterDias.put(UUID.fromString(result.getString("player")), result.getInt("count"));
			}

			ResultSet result1 = null;
			PreparedStatement preparedStmt1 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt1.setString(1, "gold");
			result1 = MySQL.callDB(preparedStmt1);

			while (result1.next()) {
				Miner.counterGold.put(UUID.fromString(result1.getString("player")), result1.getInt("count"));
			}

			ResultSet result11111 = null;
			PreparedStatement preparedStmt11111 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt11111.setString(1, "iron");
			result11111 = MySQL.callDB(preparedStmt11111);

			while (result11111.next()) {
				Miner.counterIron.put(UUID.fromString(result11111.getString("player")), result11111.getInt("count"));
			}

			ResultSet result111111 = null;
			PreparedStatement preparedStmt111111 = MySQL.getPreStat("SELECT player,count FROM MCS_miner WHERE type = ?");
			preparedStmt111111.setString(1, "all");
			result111111 = MySQL.callDB(preparedStmt111111);

			while (result111111.next()) {
				Miner.counterAll.put(UUID.fromString(result111111.getString("player")), result111111.getInt("count"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void saveMinerData() {
		// TODO Auto-generated method stub
		Iterator it = Miner.counterDias.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry miner = (Map.Entry) it.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "diamant");
		}

		Iterator it1 = Miner.counterGold.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry miner = (Map.Entry) it1.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "gold");
		}

		Iterator it11 = Miner.counterIron.entrySet().iterator();
		while (it11.hasNext()) {
			Map.Entry miner = (Map.Entry) it11.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "iron");
		}

		Iterator it111 = Miner.counterRedstone.entrySet().iterator();
		while (it111.hasNext()) {
			Map.Entry miner = (Map.Entry) it111.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "redstone");
		}

		Iterator it1111 = Miner.counterCoal.entrySet().iterator();
		while (it1111.hasNext()) {
			Map.Entry miner = (Map.Entry) it1111.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "coal");
		}

		Iterator it11111 = Miner.counterLapis.entrySet().iterator();
		while (it11111.hasNext()) {
			Map.Entry miner = (Map.Entry) it11111.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "lapis");
		}

		Iterator it111111 = Miner.counterAll.entrySet().iterator();
		while (it111111.hasNext()) {
			Map.Entry miner = (Map.Entry) it111111.next();
			inserData((UUID) miner.getKey(), (Integer) miner.getValue(), "all");
		}
	}

	private static void inserData(UUID player, Integer count, String type) {
		String sql = "insert into MCS_miner (player, type, count)" + " values (?, ?, ?) ON DUPLICATE KEY UPDATE count = ?";

		PreparedStatement preparedStmt = MySQL.getPreStat(sql);

		try {
			preparedStmt.setString(1, player.toString());
			preparedStmt.setString(2, type);
			preparedStmt.setInt(3, count);
			preparedStmt.setInt(4, count);
			MySQL.insertDB(preparedStmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@EventHandler
	public void onPlayerBreakBlock(BlockBreakEvent event) {
		if (Miner.counterDias == null)
			Miner.counterDias = new HashMap<UUID, Integer>();
		if (Miner.counterGold == null)
			Miner.counterGold = new HashMap<UUID, Integer>();
		if (Miner.counterIron == null)
			Miner.counterIron = new HashMap<UUID, Integer>();
		if (Miner.counterRedstone == null)
			Miner.counterRedstone = new HashMap<UUID, Integer>();
		if (Miner.counterCoal == null)
			Miner.counterCoal = new HashMap<UUID, Integer>();
		if (Miner.counterLapis == null)
			Miner.counterLapis = new HashMap<UUID, Integer>();
		if (Miner.counterAll == null)
			Miner.counterAll = new HashMap<UUID, Integer>();

		Material destroyedBlock = event.getBlock().getType();
		Integer CountPlayer = 0;
		switch (destroyedBlock) {
			case DIAMOND_ORE:
				if (!Miner.counterDias.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterDias.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterDias.get(event.getPlayer().getUniqueId());
				Miner.counterDias.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case GOLD_ORE:
				if (!Miner.counterGold.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterGold.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterGold.get(event.getPlayer().getUniqueId());
				Miner.counterGold.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case IRON_ORE:
				if (!Miner.counterIron.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterIron.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterIron.get(event.getPlayer().getUniqueId());
				Miner.counterIron.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case REDSTONE_ORE:
				if (!Miner.counterRedstone.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterRedstone.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterRedstone.get(event.getPlayer().getUniqueId());
				Miner.counterRedstone.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case COAL_ORE:
				if (!Miner.counterCoal.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterCoal.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterCoal.get(event.getPlayer().getUniqueId());
				Miner.counterCoal.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case LAPIS_ORE:
				if (!Miner.counterLapis.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterLapis.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterLapis.get(event.getPlayer().getUniqueId());
				Miner.counterLapis.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
			case DIRT:
				break;
			default:
				if (!Miner.counterAll.containsKey(event.getPlayer().getUniqueId())) {
					Miner.counterAll.put(event.getPlayer().getUniqueId(), 1);
				}
				CountPlayer = Miner.counterAll.get(event.getPlayer().getUniqueId());
				Miner.counterAll.put(event.getPlayer().getUniqueId(), ++CountPlayer);
				break;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("[MCSocial] Dieser Befehl kann nur von einem Spieler ausgefï¿½hrt werden!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("infoitem")) {
			ItemStack item = p.getItemInHand();
			p.sendMessage("ï¿½6ItemIDï¿½7: ï¿½a" + item.getType());
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("miner")) {

			if (args.length < 1) {
				p.sendMessage("ï¿½6MCSocialï¿½7: ï¿½cBitte gebe einen Spielernamen an.");
				return true;
			}

			Player oP;
			try {
				oP = (Player) Bukkit.getPlayer(args[0]);
			} catch (NullPointerException e) {
				oP = (Player) Bukkit.getOfflinePlayer(args[0]);
			}
			if (oP == null) {
				p.sendMessage("ï¿½6MCSocialï¿½7: ï¿½cDer Spieler konnte nicht gefunden werden.");
				return true;
			}

			p.sendMessage("--------------------------------");
			p.sendMessage("Das Mining verhalten von " + oP.getDisplayName() + ":");
			p.sendMessage("--------------------------------");

			if (!Miner.counterAll.containsKey(oP.getUniqueId())) {
				p.sendMessage("Keine abgebauten Blï¿½cke vorhanden");
				p.sendMessage("--------------------------------");
				return true;
			}

			if (Miner.counterDias.containsKey(oP.getUniqueId()))
				p.sendMessage("Diamanten: " + Miner.counterDias.get(oP.getUniqueId()));
			if (Miner.counterGold.containsKey(oP.getUniqueId()))
				p.sendMessage("Gold: " + Miner.counterGold.get(oP.getUniqueId()));
			if (Miner.counterIron.containsKey(oP.getUniqueId()))
				p.sendMessage("Eisen: " + Miner.counterIron.get(oP.getUniqueId()));
			if (Miner.counterRedstone.containsKey(oP.getUniqueId()))
				p.sendMessage("Redstone: " + Miner.counterRedstone.get(oP.getUniqueId()));
			if (Miner.counterCoal.containsKey(oP.getUniqueId()))
				p.sendMessage("Kohle: " + Miner.counterCoal.get(oP.getUniqueId()));
			if (Miner.counterLapis.containsKey(oP.getUniqueId()))
				p.sendMessage("Lapis: " + Miner.counterLapis.get(oP.getUniqueId()));
			p.sendMessage("Gesamt abgebaute Blï¿½cke: " + Miner.counterAll.get(oP.getUniqueId()));
			p.sendMessage("--------------------------------");
			return true;
		}
		return false;
	}

}
