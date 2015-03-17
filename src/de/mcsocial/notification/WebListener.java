package de.mcsocial.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.CharBuffer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WebListener {
	
	public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/", new WebVoteHandler());
        server.createContext("/chat", new WebChatHandler());
        server.createContext("/user", new WebUserHandler());
        server.setExecutor(null); // creates a default executor
        
        
        server.start();
    }
	
	static class WebVoteHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
        	InputStream is=exchange.getRequestBody();
			BufferedReader in=new BufferedReader(new InputStreamReader(is));
			String requestMethod=exchange.getRequestMethod();
			
			System.out.println("[MCSocialWeb] " +requestMethod);
			CharBuffer cb = CharBuffer.allocate(256);
			
			// read characters into a char buffer
			in.read(cb);
			
			// flip the char buffer
			cb.flip();
			
			// print the char buffer
			System.out.println("[MCSocialWeb] " +cb.toString());
			
			Headers responseHeaders=exchange.getResponseHeaders();
			responseHeaders.set("Content-Type","text/plain");
			
			exchange.sendResponseHeaders(200,0);
			OutputStream responseBody=exchange.getResponseBody();
			Headers requestHeaders=exchange.getRequestHeaders();
			String s="thx";
			
			responseBody.write(s.getBytes());
			responseBody.close();
        }
    }
	static class WebChatHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
        	InputStream is=exchange.getRequestBody();
			BufferedReader in=new BufferedReader(new InputStreamReader(is));
			String requestMethod=exchange.getRequestMethod();
			
			System.out.println("[MCSocialWeb] " +requestMethod);
			CharBuffer cb = CharBuffer.allocate(256);
			
			// read characters into a char buffer
			in.read(cb);
			
			// flip the char buffer
			cb.flip();
			
			// print the char buffer
			System.out.println("[MCSocialWeb] " +cb.toString());
			
			Headers responseHeaders=exchange.getResponseHeaders();
			responseHeaders.set("Content-Type","text/plain");
			
			exchange.sendResponseHeaders(200,0);
			OutputStream responseBody=exchange.getResponseBody();
			Headers requestHeaders=exchange.getRequestHeaders();
			String s="thx";
			
			responseBody.write(s.getBytes());
			responseBody.close();
        }
    }
	static class WebUserHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "thx";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
