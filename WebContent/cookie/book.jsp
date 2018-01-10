<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Detail</title>
</head>
<body>
<h2>Book Detail Page</h2>

Book:<%= request.getParameter("book") %>

<br/>
<a href="books.jsp">Return</a>
<%
	String book = request.getParameter("book");
	//把书的信息以Cookie方式传回，删除一个Cookiee
	//1.确定要删除Cookie:以BOOK_开头Cookie数量大于等于5
	Cookie[] cookies = request.getCookies();
	List<Cookie> bookcookies = new ArrayList<Cookie>();
	Cookie tmpCookie = null;
	if(cookies!=null && cookies.length>0){
		for(Cookie c:cookies){
			String cookieName = c.getName();
			if(cookieName.startsWith("BOOK_")){
				bookcookies.add(c);
				if(c.getValue().equals(book)){
					tmpCookie = c; //tmpCookie!=null 表示在数组里
				}
			}
		}
	}
	//1.1若从books.jsp传过来的Book不在BOOK_的Cookie数组中，则删除较早的一个
	if(bookcookies.size()>=5 && tmpCookie == null){
		tmpCookie = bookcookies.get(0);
	}
	//1.2若从books.jsp传过来的Book在BOOK_的Cookie数组中,则将其放到数组最后
	if(tmpCookie != null){
		tmpCookie.setMaxAge(0);
		response.addCookie(tmpCookie);
	}
	
	//2.把从books.jsp传入的book作为一个Cookie返回
	Cookie cookie = new Cookie("BOOK_"+book,book);
	response.addCookie(cookie);
%>
</body>
</html>