package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import de.mcsocial.main.MySQL;

public class Market {

	private static HashMap<String,Double> allItems;
	
	public static Double getPrice(String item){
		if(!item.contains(":")) item = item+":0";
		if(Market.allItems == null)
			Market.allItems = new HashMap<String,Double>();
		
		if(!Market.allItems.containsKey(item))
			Market.allItems.put(item,500.00);
		
		return Market.allItems.get(item);

	}

	public static void setPrice(String item, Double price){
		if(!item.contains(":")) item = item+":0";
		if(Market.allItems == null)
			Market.allItems = new HashMap<String,Double>();
		
		if(!Market.allItems.containsKey(item))
			Market.allItems.put(item,500.00);
		
		Market.allItems.put(item,price);
	}
	


	public static void updatePrice(String item, Double price){
		if(!item.contains(":")) item = item+":0";
		if(Market.allItems == null)
			Market.allItems = new HashMap<String,Double>();
		
		if(!Market.allItems.containsKey(item))
			Market.allItems.put(item,500.00);
		
		Market.allItems.put(item,Market.getPrice(item)+price);
	}

	@SuppressWarnings("rawtypes")
	public static void savePrices(){
		Iterator it = Market.allItems.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        String sql = "insert into MCS_market (material, price)"
			        + " values (?, ?)"
			        + " ON DUPLICATE KEY UPDATE price = ?";
			
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			
			try {
				preparedStmt.setString (1, (String) pair.getKey());
				preparedStmt.setDouble (2, (double) pair.getValue());	
				preparedStmt.setDouble (3, (double) pair.getValue());			
				MySQL.insertDB(preparedStmt);								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

	public static void loadPrices(){
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT material,price FROM MCS_market");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);
			
			while(result.next()){
				Market.setPrice(result.getString("material"),result.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
