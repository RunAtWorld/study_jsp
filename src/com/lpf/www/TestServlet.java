package com.lpf.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(displayName = "This is Login Action",name="testServlet",urlPatterns={"/testServlet"},loadOnStartup=-1)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath() + "   TestServlet's doGet方法");
		System.out.println("TestServlet's doGet方法");
		System.out.println("TestServlet's name : " +request.getAttribute("name"));
	}
}
