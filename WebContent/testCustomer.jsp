<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>testCustomer</title>
</head>
<body>
	<a href="customerServlet?method=add">add</a>
	<br />
	<a href="customerServlet?method=update">update</a>
	<br />
	<a href="customerServlet?method=delete">delete</a>
	<br />
	<a href="customerServlet?method=query">query</a>
	<br />

	<hr />
	<a href="add.do">add</a>
	<br />
	<a href="update.do">update</a>
	<br />
	<a href="delete.do">delete</a>
	<br />
	<a href="query.do">query</a>
	<br />
</body>
</html>