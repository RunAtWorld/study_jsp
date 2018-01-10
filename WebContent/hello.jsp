<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page import="java.util.Date"%>
<%@page isErrorPage="true"%>
<%@page import="com.lpf.www.Person"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>not found</h2>
	hello,你的名字：

	<% 
	Person p = new Person("LPF",23);
	System.out.println(p.toString());
	%>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		Date date = new Date();
		date.toString();
		
		System.out.println(request.getParameter("name"));
		
		Class clazz = response.getClass();
		System.out.println(clazz);
		
		System.out.println(session.getId());
		System.out.println(application.getInitParameter("driver"));
		
		System.out.println(config.getInitParameter("test"));
		
	%>


	<%=request.getParameter("name") %>

	<% 
		String strOld=request.getParameter("name");
		String strNew = new String(strOld.getBytes("UTF-8"),"UTF-8");
		out.print(strOld + "-->" + strNew);
	%>
</body>
</html>