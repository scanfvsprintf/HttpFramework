package com.httpserver;
import java.io.*;
import java.net.*;

/**�����������ڣ���Ҫ�������ǿ����̲߳���������
 * @author xyx
 *
 */
public class Main implements Runnable{
	public static Dispatcher dispatcher=null;
	public static ServerSocket server=null;
	private Request request=null;
	private Response response=null;
	//main��������������ʼ���ַ������󣬲������߳�
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		dispatcher=new Dispatcher();
		server=new ServerSocket(80);
		while(true) {
			Socket t=server.accept();
			System.out.println("�¿ͻ���");
			new Thread(new Main(t)).start();
		}

	}
	//���췽������Ҫ�����ڳ�ʼ��������һ�����ӵ�request��response��
	Main(Socket client){
		request=new Request(client);
		response=new Response(client);
	}
	//���÷ַ����ַ�
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dispatcher.dispatch(request, response);
	}

}
