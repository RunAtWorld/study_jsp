<%@page import="com.lpf.mvc.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.lpf.mvc.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>queryCustomer</title>
<script type="text/javascript" src="./scripts/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag = confirm("确定是要删除  "+content+"   的信息吗");
			return flag;		
		});
		
	});
</script>
</head>
<body>
<h1 align="center">管理学生信息</h1>
<hr/>
<form action="queryWithCriteria.do" method="post">
输入姓名：<input type="text" name="name"/>
输入地址：<input type="text" name="address"/>
输入电话：<input type="text" name="phone"/>
<input type="submit"> 
 </form>
 
 <br/><a href="newCustomer.jsp">添加学生</a>
<div style="width:90%" >
<table width="90%" border=1>
<tr>
	<td width="5%"></td>
	<td width="5%">姓名</td>
	<td width="5%">地址</td>
	<td width="10%">电话</td>
	<td width="5%">修改</td>
	<td width="5%">删除</td>
</tr>
<% List<Customer> Customers=(List<Customer>) request.getAttribute("cuslist");
	int i=0;
	if(Customers!=null&&Customers.size()>0){
		for(Customer s:Customers){
%>
	<tr>
	<td><%=++i %></td>
	<td><%=s.getName() %></td>
	<td><%=s.getAddress() %></td>
	<td><%=s.getPhone() %></td>
	<td><a href="edit.do?id=<%=s.getId() %>" class="update">修改</a></td>
	<td><a href="delete.do?id=<%=s.getId() %>" class="delete">删除</a></td>
	</tr>
<%
			System.out.println(s.getName());
		}	
	}
	else{
		System.out.println("无数据");
	}
%>
</table>
</body>
</html>