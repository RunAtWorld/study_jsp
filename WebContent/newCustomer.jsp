<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加一个新客户</title>
</head>
<body>
<% Object msg = request.getAttribute("message");
	if(msg!=null){
	%>
	<br/><font color="red"><%=msg %></font><br/>
	<%
	}
%>
<form action="add.do" method="post">
输入姓名：<input type="text" name="name" value="<%=request.getAttribute("name")==null? "":request.getAttribute("name")%>"/><br/>
输入地址：<input type="text" name="address" value="<%=request.getAttribute("address")==null? "":request.getAttribute("address")%>"/><br/>
输入电话：<input type="text" name="phone" value="<%=request.getAttribute("phone")==null? "":request.getAttribute("phone")%>"/><br/>
<input type="submit" value="确认添加">
 </form>
</body>
</html>