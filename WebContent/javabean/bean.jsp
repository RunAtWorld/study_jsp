<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean</title>
</head>
<body>
<jsp:useBean id="person" class="com.lpf.www.Person" scope="request"></jsp:useBean>
<jsp:setProperty property="age" name="person" value="10"/>
age:<jsp:getProperty property="age" name="person"/>

</body>
</html>