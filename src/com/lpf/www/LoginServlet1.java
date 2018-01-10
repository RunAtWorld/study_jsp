package com.lpf.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet1 implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("请求来了...");
		System.out.println(request);
		
		//获取参数名
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		System.out.println(user +":"+ pwd);
		//获取参数名的一组值
		String[] insterests = request.getParameterValues("interest");
		for(String in:insterests)
			System.out.println(in);
		
		//遍历参数名，以Sting形式获取参数值
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "==>" + value);
		}
		
		//遍历参数名，以map形式获取参数值
		Map<String,String[]>  values = request.getParameterMap();
		for(Map.Entry<String, String[]> entry: values.entrySet()){
			System.out.println(entry.getKey() + "-->" + Arrays.asList(entry.getValue()));
		}
		
		//获取资源URI相关信息
		HttpServletRequest httpServletURI = (HttpServletRequest)request;
		String requestURI = httpServletURI.getRequestURI();
		System.out.println(requestURI);
		System.out.println(httpServletURI.getMethod());
		System.out.println(httpServletURI.getQueryString());
		String servletPath = httpServletURI.getServletPath();
		System.out.println(servletPath);
		
		//设置响应的内容类型
		response.setContentType("application/msword");
		//向浏览器打印输出
		PrintWriter out = response.getWriter();
		out.println("Welcome   "+user+"!");
		
		
	}

}
