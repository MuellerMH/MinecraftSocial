package de.mcsocial.notification.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.CharBuffer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WebUserHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
    	InputStream is=exchange.getRequestBody();
		BufferedReader in=new BufferedReader(new InputStreamReader(is));
		String requestMethod=exchange.getRequestMethod();
		
		CharBuffer cb = CharBuffer.allocate(256);
		
		// read characters into a char buffer
		in.read(cb);
		
		// flip the char buffer
		cb.flip();
		
		// print the char buffer
		
		Headers responseHeaders=exchange.getResponseHeaders();
		responseHeaders.set("Content-Type","application/json");
		responseHeaders.set("Access-Control-Allow-Origin","http://minecraft-social.de");
		
		exchange.sendResponseHeaders(200,0);
		OutputStream responseBody=exchange.getResponseBody();
		Headers requestHeaders=exchange.getRequestHeaders();
		
		responseBody.write(getOnlineUser().getBytes());
		responseBody.close();
    }
    
    private String getOnlineUser(){
    	String s="{\"player\":[";

		Player[] players = Bukkit.getOnlinePlayers();
		int count = 1;
		for(Player player: players){
			s += "{\"name\": \"" + player.getName()+"\",\"onlinetime\":\""+player.getPlayerTime()+"\",\"level\":\""+player.getLevel()+"\"}";
			if(count++ < players.length){
				s += ",";
			}
		}
		s += "]}";
		
		return s;
    }
}
