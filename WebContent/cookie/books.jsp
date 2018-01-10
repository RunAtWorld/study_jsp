<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>books</title>
</head>
<body>
<ol>
<li><a href="book.jsp?book=Java">Java</a></li>
<li><a href="book.jsp?book=JavaWeb">Java Web</a></li>
<li><a href="book.jsp?book=Oracle">Oracle</a></li>
<li><a href="book.jsp?book=Ajax">Ajax</a></li>
<li><a href="book.jsp?book=Android">Android</a></li>
<li><a href="book.jsp?book=IOS">IOS</a></li>
<li><a href="book.jsp?book=MySQL">MySQL</a></li>
<li><a href="book.jsp?book=HTML">HTML</a></li>
<li><a href="book.jsp?book=JavaScript">JavaScript</a></li>
<li><a href="book.jsp?book=Jbpm">Jbpm</a></li>
<li><a href="book.jsp?book=Struts">Struts</a></li>
<li><a href="book.jsp?book=Hibernate">Hibernate</a></li>
<li><a href="book.jsp?book=Mybatis">Mybatis</a></li>
<li><a href="book.jsp?book=DataMining">Data Mining</a></li>
<li><a href="book.jsp?book=MachineLearning">Machine Learning</a></li>
<li><a href="book.jsp?book=Data_Structure">Data Structure</a></li>
<li><a href="book.jsp?book=Introduction_to_Algorithms">Introduction to Algorithms</a></li>
<li><a href="book.jsp?book=OperatingSystem">Operating System</a></li>
<li><a href="book.jsp?book=ComputerNetwork">Computer Network</a></li>
<li><a href="book.jsp?book=Probability_and_Statistics">Probability and Statistics</a></li>
</ol>

<br/>
最近浏览:<br/>
<%
	//显示最近浏览的5本书
	//获取所有的cookie
	Cookie[] cookies = request.getCookies();

	//筛选出带Book_的cookie
	if(cookies != null && cookies.length>0){
		for(int i=cookies.length-1;i>=0;i--){
			String cookieName = cookies[i].getName();
			if(cookieName.startsWith("BOOK_")){
				out.println(cookies[i].getValue()+"<br/>");
			}
		}
	}
%>
</body>
</html>