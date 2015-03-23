package de.mcsocial.admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import de.mcsocial.main.MySQL;

public class AdminLogger {

	public static void writeLog(Player admin, Player player, String action, String argument){
		String sql = "insert into MCS_adminlog (admin,player,action,argument) "
				+ "VALUES ( ?,?,?,? )";
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString (1, admin.getName());
			if(player != null)preparedStmt.setString (2, player.getName());
			else preparedStmt.setString (2, null);
			preparedStmt.setString (3, action);
			if(argument != null)preparedStmt.setString (4, argument);
			else preparedStmt.setString (4, null);
			
			MySQL.insertDB(preparedStmt);								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
