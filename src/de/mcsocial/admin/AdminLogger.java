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
			preparedStmt.setString (2, player.getName());
			preparedStmt.setString (3, action);
			preparedStmt.setString (4, argument);
			
			MySQL.insertDB(preparedStmt);								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
