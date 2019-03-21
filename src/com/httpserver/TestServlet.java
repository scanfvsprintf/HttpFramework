package com.httpserver;

public class TestServlet implements Servlet{
	public void init() {
		
	}
	public void service(Request req,Response res) {
		res.print("ewfwefwef");
		res.send();
	}
}
