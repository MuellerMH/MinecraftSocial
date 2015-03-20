package de.mcsocial.notification.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.CharBuffer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WebVoteHandler implements HttpHandler {
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
		responseHeaders.set("Content-Type","application/json");
		responseHeaders.set("Access-Control-Allow-Origin","http://minecraft-social.de");
		
		exchange.sendResponseHeaders(200,0);
		OutputStream responseBody=exchange.getResponseBody();
		Headers requestHeaders=exchange.getRequestHeaders();
		String s="thx";
		
		responseBody.write(s.getBytes());
		responseBody.close();
    }
}