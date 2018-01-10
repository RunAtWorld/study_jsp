<%@page import="com.lpf.www.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test tag</title>
</head>
<body>

<% 
	List<Person> ps = (List<Person>)request.getAttribute("people");
	if(ps!=null){
		for(Person p:ps)
			out.print(p.toString()+"<br/>");
	} 
%>


<br/>
<br/>
标签库获取：<br/>
	<c:forEach items="${requestScope.people }" var="p">
		${p.name} , ${p.age} ,${p.dog }<br>
	</c:forEach>
</body>
</html>