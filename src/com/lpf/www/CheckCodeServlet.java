package com.lpf.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求参数CHECK_CODE_PARAM_NAME
		System.out.println(request.getParameter("name"));
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		
		//2获取session中的CHECK_CODE_KEY
		Object sessionCode = request.getSession().getAttribute("CHECK_CODE_KEY");
		
		//3.比对，一致则说明验证码正确；不一致，验证码错我
		System.out.println("paramCode:"+paramCode);
		System.out.println("sessionCode:"+sessionCode);
		System.out.println(paramCode!=null && paramCode.equalsIgnoreCase(sessionCode.toString()));
		if(!(paramCode!=null && paramCode.equalsIgnoreCase(sessionCode.toString()))){
			request.getSession().setAttribute("message", "验证码不一致");
			response.sendRedirect(request.getContextPath()+"/check/index.jsp");
			return;
		}
		System.out.println("受理请求");
		request.getRequestDispatcher("/check/success.jsp").forward(request, response);
	}

}
