package com.lpf.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 155676728932L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		System.out.println(username + ":" + pwd);
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet rs =null;
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///test";
			String user = "root";
			String password = "lipengfei2015";
			connection = DriverManager.getConnection(url,user,password);
			
			String sql = "SELECT count(id) FROM users WHERE username = ? AND password = ?"; 
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, pwd);
			rs = statement.executeQuery();
			if(rs.next()){
				int count = rs.getInt(1);
				if(count>0){
					System.out.println("hello:" + username);
					out.println("hello:" + username);
				}else{
					System.out.println("sorry:" + username);
					System.out.println(statement);
					out.println("sorry:" + username);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
}


