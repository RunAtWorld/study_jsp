<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.lpf.com/mytag/core"  prefix="lpf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<lpf:hello value="${param.name}"  count="3"/>
	
	<lpf:max num2="${param.a }" num1="${param.b }"/>
	
	<lpf:readFile src="/WEB-INF/note.txt"/>
</body>
</html>