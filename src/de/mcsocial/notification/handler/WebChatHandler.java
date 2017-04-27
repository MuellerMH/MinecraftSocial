package de.mcsocial.notification.handler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import de.mcsocial.main.MySQL;

public class WebChatHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
    	InputStream is=exchange.getRequestBody();
		BufferedReader in=new BufferedReader(new InputStreamReader(is));
		exchange.getRequestMethod();
		
		CharBuffer cb = CharBuffer.allocate(256);
		// read characters into a char buffer
		in.read(cb);
		cb.flip();
		try {
			JSONParser parser = new JSONParser();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cb.limit(); i++)
	            sb.append(cb.get());
			Bukkit.getLogger().info(sb.toString());
			JSONObject json = (JSONObject) parser.parse(sb.toString());
			Bukkit.broadcastMessage(ChatColor.RED + " " +  json.toString());
			Bukkit.broadcastMessage(ChatColor.RED + " " +  sb.toString());
			Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[ http://discord.gg/E2ar23V ] [" + ChatColor.RED + json.get("player")+ "]: " + ChatColor.WHITE +json.get("msg"));
		} catch (ParseException e) {
			Bukkit.broadcastMessage(ChatColor.RED + " " +  e.getMessage());
			e.printStackTrace();
		}
		Headers responseHeaders=exchange.getResponseHeaders();
		responseHeaders.set("Content-Type","application/json");
		responseHeaders.set("Access-Control-Allow-Origin","*");
		
		exchange.sendResponseHeaders(200,0);
		OutputStream responseBody=exchange.getResponseBody();
		exchange.getRequestHeaders();
		
		responseBody.write(("{\"status\":\"OK\"}").getBytes());
		responseBody.close();
    }
    
    public static String executePost(String targetURL, String urlParameters) {
	  HttpURLConnection connection = null;
	
	  try {
	    //Create connection
	    URL url = new URL(targetURL);
	    connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", 
	        "application/json");
	
	    connection.setRequestProperty("Content-Length", 
	        Integer.toString(urlParameters.getBytes().length));
	
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	
	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	    connection.getOutputStream());
	    wr.writeBytes(urlParameters);
	    wr.close();
	
	    //Get Response  
	    InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
	    String line;
	    while ((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    return response.toString();
	  } catch (Exception e) {
	    e.printStackTrace();
	    return null;
	  } finally {
	    if (connection != null) {
	      connection.disconnect();
	    }
	  }
	}
    
    @SuppressWarnings("unused")
	private String getLastChatMessage(){
    	String returnString = "{ \"message\":[";
    	try {		
				ResultSet result = MySQL.callDB("SELECT * FROM MCS_chat ORDER BY chattime DESC LIMIT 0,20");	
			
			while(result.next()){				
				returnString += "{\"name\": \"" + result.getString("user")+"\",\"onlinetime\":\""+result.getTimestamp("chattime")+"\",\"message\":\""+result.getString("message")+"\"}";
				if(!result.isLast()){
					returnString +=",";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	returnString += "]}";
		return returnString;
    	
    }
}