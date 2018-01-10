<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
	pageContext.setAttribute("pageContextAttr", "pageContextValue");
	request.setAttribute("requestAttr", "requestValue");
	session.setAttribute("sessionAttr", "sessionValue");
	application.setAttribute("applicationAttr", "applicationValue");
%>
	<h1><%= new Date()	%></h1>

	pageContext:<%	out.print(pageContext.getAttribute("pageContextAttr").toString());%><br />
	<br /> request:<%	out.print(request.getAttribute("requestAttr").toString());%><br />
	<br /> session:<%	out.print(session.getAttribute("sessionAttr").toString());%><br />
	<br /> application:<%	out.print(application.getAttribute("applicationAttr").toString());%><br />
	<a href="attr2.jsp">attr2.jsp</a>
</body>
</html>