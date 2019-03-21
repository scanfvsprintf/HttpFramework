package com.httpserver;

import java.util.HashMap;

public class Config {
	private HashMap<String,String> Configs=null;
	private HashMap<String,String> ServletConfigs=null;
	//获取基本配置信息
	public HashMap<String,String> getCofings(){
		return Configs;		
	}
	//获取Servlet配置信息
	public HashMap<String,String> getServletCofings(){
		ServletConfigs.put("test", "com.httpserver.TestServlet");
		return ServletConfigs;		
	}
	//私有化的构造器
	private Config() {
		Configs=new HashMap<String,String>();
		ServletConfigs=new HashMap<String,String>();
	}
	
	//静态内部类实现单例模式
	private static class Single{
		private static Config instance=new Config();
	}
	//获取单例对象
	public static Config getInstance() {
		return Single.instance;
	}
	
	
}
