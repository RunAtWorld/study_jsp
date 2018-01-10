<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	hello
	<%
		String logincode = request.getParameter("logincode");
		if(logincode!=null && !logincode.trim().equals("")){
			Cookie cookie = new Cookie("logincode",logincode);
			cookie.setMaxAge(30);
			response.addCookie(cookie);
		}else{
			//从Cookie中读取用户信息
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0){
				for(Cookie ckie:cookies){
					if("logincode".equals(ckie.getName())){
						logincode = ckie.getValue();
					}
				}
			}
		}
		if(logincode != null && !logincode.trim().equals("")){
			out.print("》》你的登录代码为：" + logincode);
		}else{
			response.sendRedirect("login.html");
		}
	%>
	
	
	
<br/>

<a href="query.do">查询学生</a>
<a href="newCustomer.jsp">添加学生</a>
</body>
</html>