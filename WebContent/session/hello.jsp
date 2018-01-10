<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>

SessionID:<%= session.getId() %>
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
Hello:<%=request.getParameter("username") %>
<br/>

<% session.setAttribute("username", request.getParameter("username")); %>
<a href="<%=response.encodeURL("login.jsp")%>">重新登录</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=response.encodeURL("logout.jsp")%>">注销</a>
</body>
</html>