package de.mcsocial.notification;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import de.mcsocial.notification.handler.WebChatHandler;
import de.mcsocial.notification.handler.WebUserHandler;
import de.mcsocial.notification.handler.WebVoteHandler;


public class WebListener {
	
	public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/api", new WebVoteHandler());
        server.createContext("/api/chat", new WebChatHandler());
        server.createContext("/api/user", new WebUserHandler());
        server.setExecutor(null); // creates a default executor        
        
        server.start();
    }
	
	
	
	
}
