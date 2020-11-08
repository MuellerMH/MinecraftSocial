package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.main.MCSocial;
import de.mcsocial.main.MySQL;

public class Account {
<<<<<<< HEAD
	
	public static void  show(Player player){
=======

	public static void show(Player player) {
>>>>>>> b4ade11... add new directory
		double money = 0;
		money = player.getMetadata("account").get(0).asDouble();
		player.sendMessage("--------------------------------");
		player.sendMessage("Konto Information");
		player.sendMessage("--------------------------------");
<<<<<<< HEAD
		player.sendMessage("Dein Aktuelles Guthaben beträgt:");
		player.sendMessage( money + "Social Dollar");
		player.sendMessage("--------------------------------");
	}
	
	public static Double getBalance(Player player){
		return player.getMetadata("account").get(0).asDouble();
	}

	public static void  add(Player player, Double amount){
		double money = 0;
		if(!player.hasMetadata("account")){
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, 4000.00));
		}
			
		money = player.getMetadata("account").get(0).asDouble();
		money =money+amount;
		player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));
		Account.create(player);
	}
	
	public static void  remove(Player player, Double amount){
		double money = 0;
		if(!player.hasMetadata("account")){
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, 4000.00));
		}
		money = player.getMetadata("account").get(0).asDouble();
		money =money-amount;
		player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));
		Account.create(player);
	}
	
	public static void  trans(Player sender, Player reciver, Double amount){
		Account.remove(sender,amount);
		Account.add(reciver,amount);
		sender.sendMessage( amount + " wurde an " +reciver.getName() + " überwiesen");
		reciver.sendMessage("Neuer Geldeingang von " + sender.getName() + ": "+ amount);
	}
	
	public static void  delete(){
		
=======
		player.sendMessage("Dein Aktuelles Guthaben betrï¿½gt:");
		player.sendMessage(money + "Social Dollar");
		player.sendMessage("--------------------------------");
	}

	public static Double getBalance(Player player) {
		return player.getMetadata("account").get(0).asDouble();
	}

	public static void add(Player player, Double amount) {
		double money = 0;
		if (!player.hasMetadata("account")) {
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, 4000.00));
		}

		money = player.getMetadata("account").get(0).asDouble();
		money = money + amount;
		player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));
		Account.create(player);
	}

	public static void remove(Player player, Double amount) {
		double money = 0;
		if (!player.hasMetadata("account")) {
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, 4000.00));
		}
		money = player.getMetadata("account").get(0).asDouble();
		money = money - amount;
		player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));
		Account.create(player);
	}

	public static void trans(Player sender, Player reciver, Double amount) {
		Account.remove(sender, amount);
		Account.add(reciver, amount);
		sender.sendMessage(amount + " wurde an " + reciver.getName() + " ï¿½berwiesen");
		reciver.sendMessage("Neuer Geldeingang von " + sender.getName() + ": " + amount);
	}

	public static void delete() {

>>>>>>> b4ade11... add new directory
	}

	public static void create(Player player) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		String sql = "insert into MCS_account (player, balance)"
		        + " values (?, ?) ON DUPLICATE KEY UPDATE  balance = ?";
		Double money = 4000.00;
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		if(player.hasMetadata("account")){
			money = player.getMetadata("account").get(0).asDouble();
		}
		try {
			preparedStmt.setString (1, player.getUniqueId().toString());
			preparedStmt.setDouble (2, money);	
			preparedStmt.setDouble (3, money);					
			MySQL.insertDB(preparedStmt);			
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));
			
=======
		String sql = "insert into MCS_account (player, balance)" + " values (?, ?) ON DUPLICATE KEY UPDATE  balance = ?";
		Double money = 4000.00;
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		if (player.hasMetadata("account")) {
			money = player.getMetadata("account").get(0).asDouble();
		}
		try {
			preparedStmt.setString(1, player.getUniqueId().toString());
			preparedStmt.setDouble(2, money);
			preparedStmt.setDouble(3, money);
			MySQL.insertDB(preparedStmt);
			player.setMetadata("account", new FixedMetadataValue(MCSocial.instance, money));

>>>>>>> b4ade11... add new directory
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
