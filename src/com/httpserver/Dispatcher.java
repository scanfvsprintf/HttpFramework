package com.httpserver;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**分发器类，主要的功能是根据url地址，选择合适的Servlet去处理这个请求
 * @author xyx
 *
 */
public class Dispatcher {
	private HashMap<String,String> configs=null;
	private HashMap<String,String> servletConfigs=null;
	private HashMap<String,Servlet> servlets=null;
	private Config config=null;
	private Request req;
	private Response res;
	public Dispatcher() {
		config=Config.getInstance();
		configs=config.getCofings();
		servletConfigs=config.getServletCofings();
		servlets=new HashMap<String,Servlet>();
	}
	public void dispatch(Request req, Response res) {
		this.req = req;
		this.res = res;
		String address=req.getAddress();
		if(servlets.containsKey(address)) {
			Servlet t=servlets.get(address);
			t.service(req, res);
		}
		else if(servletConfigs.containsKey(address)){
			try {
				Class<?> clazz=Class.forName(servletConfigs.get(address));
				Servlet t=(Servlet)clazz.getConstructor(null).newInstance(null);
				servlets.put(address, t);
				t.init();
				t.service(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else if(address.trim().length()==0) {
			try {
				System.out.println("address:"+address);
				res.setCode(404);
				res.printfile("index.html");
				res.send();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(new File(address).exists()) {
			try {
				res.printfile(address);
				res.send();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			res.setCode(404);
			res.send();
		}
	}
}
