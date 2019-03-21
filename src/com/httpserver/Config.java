package com.httpserver;

import java.util.HashMap;

public class Config {
	private HashMap<String,String> Configs=null;
	private HashMap<String,String> ServletConfigs=null;
	//��ȡ����������Ϣ
	public HashMap<String,String> getCofings(){
		return Configs;		
	}
	//��ȡServlet������Ϣ
	public HashMap<String,String> getServletCofings(){
		ServletConfigs.put("test", "com.httpserver.TestServlet");
		return ServletConfigs;		
	}
	//˽�л��Ĺ�����
	private Config() {
		Configs=new HashMap<String,String>();
		ServletConfigs=new HashMap<String,String>();
	}
	
	//��̬�ڲ���ʵ�ֵ���ģʽ
	private static class Single{
		private static Config instance=new Config();
	}
	//��ȡ��������
	public static Config getInstance() {
		return Single.instance;
	}
	
	
}
