package de.mcsocial.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	private static String host = 	(String) MCSocial.config.getString("mysqlHost");
	private static int port = 		(int) MCSocial.config.getInt("mysqlPort");
	private static String name = 	(String) MCSocial.config.getString("mysqlDatabase");
	private static String user = 	(String) MCSocial.config.getString("mysqlUser");
	private static String pass = 	(String) MCSocial.config.getString("mysqlPassword");
	
	private static Connection connection = null;
	
	public MySQL ()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			MySQL.connection = DriverManager.getConnection("jdbc:mysql://"+MySQL.host+":"+MySQL.port+"/"+MySQL.name+"?user="+MySQL.user+"&password="+MySQL.pass);
		} catch( ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private static Connection getInstance(){
	    if(MySQL.connection == null)
	        new MySQL();
	    return MySQL.connection;
	}
	
	public static PreparedStatement getPreStat(String sql){
		MySQL.connection = getInstance();
		if(MySQL.connection == null){
			return null;
		}
		try {
			return MySQL.connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void insertDB (PreparedStatement sql){
		MySQL.connection = getInstance();
		
		try {
			sql.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet callDB (PreparedStatement sql) {
		MySQL.connection = getInstance();
		if(MySQL.connection == null){
			return null;
		}
		
		try{
			return sql.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();			
		}
		return null;
		
	}
	
	
	public static ResultSet callDB (String sql) {
		MySQL.connection = getInstance();
		if(MySQL.connection == null){
			return null;
		}
		
		Statement query = null;		
		try{
			query = MySQL.connection.createStatement();
			ResultSet result = query.executeQuery(sql);
			return result;
		}catch(SQLException e){
			e.printStackTrace();			
		}
		return null;
		
	}
	

	
	
	public static int callDBUpdate (String sql) {
		MySQL.connection = getInstance();
		if(MySQL.connection == null){
			return 0;
		}
		
		Statement query = null;		
		try{
			query = MySQL.connection.createStatement();
			int result = query.executeUpdate(sql);
			return result;
		}catch(SQLException e){
			e.printStackTrace();			
		}
		return 0;
		
	}
	
}
