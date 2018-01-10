<%@page import="com.lpf.mvc.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户</title>
</head>
<body>
<% Object msg = request.getAttribute("message");
	if(msg!=null){
	%>
	<br/><font color="red"><%=msg %></font><br/>
	<%
	}
	String id =null;
	String name =null;
	String address =null;
	String phone =null;
	String oldname = null;
	Customer customer =(Customer) request.getAttribute("customer");
	if(customer==null){ //如果为null，来源是update.do
		id = request.getParameter("id");
		oldname = request.getParameter("oldname");
		name = request.getParameter("oldname");
		address = request.getParameter("address");
		phone = request.getParameter("phone");
	}else{ //如果不为null,来源是edit.do
		id = customer.getId() + "";
		oldname = customer.getName();
		name = customer.getName();
		address = customer.getAddress();
		phone = customer.getPhone();
	}
%>
<form action="update.do" method="post">
<input type="hidden" name="id" value="<%=id%>"/>
<input type="hidden" name="oldname" value="<%=oldname%>"/>
输入姓名：<input type="text" name="name" value="<%=name%>"/><br/>
输入地址：<input type="text" name="address" value="<%=address%>"/><br/>
输入电话：<input type="text" name="phone" value="<%=phone%>"/><br/>
<input type="submit" value="确认修改">
 </form>
</body>
</html>