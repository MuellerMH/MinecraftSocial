package de.mcsocial.chat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import de.mcsocial.main.MySQL;

public class ChatLogger {
	public static void writeLog(Player player, String message){
		String sql = "insert into MCS_chat (user,message) "
				+ "VALUES ( ?,? )";
		PreparedStatement preparedStmt = MySQL.getPreStat(sql);
		try {
			preparedStmt.setString (1, player.getName());
			preparedStmt.setString (2, message);
			
			MySQL.insertDB(preparedStmt);								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
