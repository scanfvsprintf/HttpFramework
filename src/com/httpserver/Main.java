package com.httpserver;
import java.io.*;
import java.net.*;

/**程序的运行入口，主要的作用是开启线程并建立连接
 * @author xyx
 *
 */
public class Main implements Runnable{
	public static Dispatcher dispatcher=null;
	public static ServerSocket server=null;
	private Request request=null;
	private Response response=null;
	//main方法，创建并初始化分发器对象，并开启线程
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		dispatcher=new Dispatcher();
		server=new ServerSocket(80);
		while(true) {
			Socket t=server.accept();
			System.out.println("新客户端");
			new Thread(new Main(t)).start();
		}

	}
	//构造方法，主要是用于初始化负责处理一个连接的request和response类
	Main(Socket client){
		request=new Request(client);
		response=new Response(client);
	}
	//利用分发器分发
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dispatcher.dispatch(request, response);
	}

}
