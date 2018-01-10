<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
SessionID:<%= session.getId() %>
<br/>
<br/>
新的会话:<%= session.isNew() %>
<br/>
<br/>

最大不活动时间间隔(s):<%=session.getMaxInactiveInterval() %>
<br/>
<br/>
会话创建时间:<%=new Date(session.getCreationTime()) %>
<br/>
<br/>
上次访问时间:<%=new Date(session.getLastAccessedTime()) %>
<br/>
<br/>
<br/>
<br/>

<%
	Object username = session.getAttribute("username");
	if(username == null)
		username="";
%>
<form action="<%=response.encodeURL("hello.jsp")%>" method="post">
	username:<input type="text" name="username" value="<%=username%>"/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>