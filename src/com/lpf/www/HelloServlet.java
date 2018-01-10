package com.lpf.www;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	public HelloServlet() {
		System.out.println("HelloServlet  constructor");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig servconfig) throws ServletException {
		System.out.println("init");
		
		//获取这个类对应的Servlet的配置
		String user = servconfig.getInitParameter("user");
		System.out.println("user:"+user);
		System.out.println();
		Enumeration<String> names = servconfig.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = servconfig.getInitParameter(name);
			System.out.println("^_^"+name +":"+ value );		
		}
		
		System.out.println(servconfig.getServletName());
		System.out.println(servconfig.getServletContext());
		
		//获取Context
		ServletContext servContext = servconfig.getServletContext();
		String driver = servContext.getInitParameter("driver");
		System.out.println("driver:"+ driver);
		
		Enumeration<String> contexts = servContext.getInitParameterNames();
		while(contexts.hasMoreElements()){
			String name = contexts.nextElement();
			String value = servContext.getInitParameter(name);
			System.out.println("-->"+name +":"+ value );		
		}
		
		//获取虚拟路径所映射的本地路径(绝对路径)
		String realpath=servContext.getRealPath("/index.jsp");
		System.out.println(realpath);		
		//相对路径
		String contextpath=servContext.getContextPath();
		System.out.println(contextpath);
		
		//获取上下文中的文件流
		try {
			ClassLoader classloader = getClass().getClassLoader();
			InputStream is = classloader.getResourceAsStream("jdbc.properties");
			System.out.println("1."+ is);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			InputStream is2 = servContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("2."+ is2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}

}
