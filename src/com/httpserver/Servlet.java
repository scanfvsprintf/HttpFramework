package com.httpserver;

public interface Servlet {
	public void init();
	public void service(Request req,Response res);
}
