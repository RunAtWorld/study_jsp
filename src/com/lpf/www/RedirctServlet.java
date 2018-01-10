package com.lpf.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirctServlet
 */
@WebServlet("/redirctServlet")
public class RedirctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath() + "   RedirctServlet's doGet方法");
		
		request.setAttribute("name","second");
		System.out.println("RedirctServlet's name : " +request.getAttribute("name"));
		//请求转发
		//1.调用HttpServletResponse的sendRedirect(location),location为 重定向的地址
		String location="testServlet";
		response.sendRedirect(location);
	}
}
