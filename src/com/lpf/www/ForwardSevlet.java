package com.lpf.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardSevlet
 */
@WebServlet("/forwardServlet")
public class ForwardSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath() + "    ForwardSevlet's doGet方法");
		request.setAttribute("name","first");
		System.out.println("ForwardSevlet's name : " +request.getAttribute("name"));
		//请求转发
		//1.调用HttpServletRequest的getRequestDispatcher()方法获取RequestDispatcher对象,调用getRequestDispatcher()需要传入要转发的地址
		String path = "testServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
		
		//2.调用RequestDispatcher 的forward(request,response)进行请求的转发
		requestDispatcher.forward(request, response);
	}
}
