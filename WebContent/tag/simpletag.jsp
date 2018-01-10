<%@page import="java.util.ArrayList"%>
<%@page import="com.lpf.www.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简单标签</title>
</head>
<body>
<%
	List<Person> ps = new ArrayList<Person>();
	ps.add(new Person("BAbA",32,"wang"));
	ps.add(new Person("siin",32,"sd"));
	ps.add(new Person("BAsabA",32,"sdds"));
	ps.add(new Person("223isnd",32,"sad"));
	
	request.setAttribute("people", ps);
%>
<!-- 在页面上对ps的属性进行遍历 -->
<jsp:forward page="testtag.jsp"></jsp:forward>
</body>
</html>