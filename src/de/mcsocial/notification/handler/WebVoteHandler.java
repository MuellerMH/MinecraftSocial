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
<<<<<<< HEAD
    private Headers requestHeaders;

	public void handle(HttpExchange exchange) throws IOException {
    	InputStream is=exchange.getRequestBody();
		BufferedReader in=new BufferedReader(new InputStreamReader(is));
		exchange.getRequestMethod();
		
		CharBuffer cb = CharBuffer.allocate(256);
		
		// read characters into a char buffer
		in.read(cb);
		
		// flip the char buffer
		
		// print the char buffer
		
		Headers responseHeaders=exchange.getResponseHeaders();
		responseHeaders.set("Content-Type","application/json");
		responseHeaders.set("Access-Control-Allow-Origin","http://minecraft-social.de");
		
		exchange.sendResponseHeaders(200,0);
		OutputStream responseBody=exchange.getResponseBody();
		setRequestHeaders(exchange.getRequestHeaders());
		String s="thx";
		
		responseBody.write(s.getBytes());
		responseBody.close();
    }
=======
	private Headers requestHeaders;

	public void handle(HttpExchange exchange) throws IOException {
		InputStream is = exchange.getRequestBody();
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		exchange.getRequestMethod();

		CharBuffer cb = CharBuffer.allocate(256);

		// read characters into a char buffer
		in.read(cb);

		// flip the char buffer

		// print the char buffer

		Headers responseHeaders = exchange.getResponseHeaders();
		responseHeaders.set("Content-Type", "application/json");
		responseHeaders.set("Access-Control-Allow-Origin", "*");

		exchange.sendResponseHeaders(200, 0);
		OutputStream responseBody = exchange.getResponseBody();
		setRequestHeaders(exchange.getRequestHeaders());
		String s = "thx";

		responseBody.write(s.getBytes());
		responseBody.close();
	}
>>>>>>> b4ade11... add new directory

	public Headers getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Headers requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
}