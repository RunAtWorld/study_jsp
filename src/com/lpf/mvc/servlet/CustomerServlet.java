package com.lpf.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lpf.mvc.dao.CriteriaCustomer;
import com.lpf.mvc.dao.CustomerDAO;
import com.lpf.mvc.dao.factory.CustomerDAOFactory;
import com.lpf.mvc.domain.Customer;
import com.lpf.mvc.impl.CustomerDAOJdbcImpl;
import com.lpf.mvc.impl.CustomerDAOXMLImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO	customerDAO=CustomerDAOFactory.getInstance().getCustomerDAO();
//	private CustomerDAO	customerDAO=new CustomerDAOXMLImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//	方法1
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method = request.getParameter("method");
//		switch(method){
//		case "add": add(request,response);break;
//		case "update": update(request,response);break;
//		case "delete": delete(request,response);break;
//		case "query": query(request,response);break;
//		}
//	}

	//方法2
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1, servletPath.length()-3);		
		req.setCharacterEncoding("UTF-8");
		try {
			//利用反射调用methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,req,resp);
		} catch(Exception e)
		{
			resp.sendRedirect("error.jsp");
		}
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行query操作：");
		List<Customer> customers = customerDAO.getAll();
		request.setAttribute("cuslist", customers);
		
		String path = "/queryCustomer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		
		//2.调用RequestDispatcher 的forward(request,response)进行请求的转发
		requestDispatcher.forward(request, response);
	}
	
	private void queryWithCriteria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行带条件query操作：");
		CriteriaCustomer cc=new CriteriaCustomer(request.getParameter("name"), request.getParameter("address"), request.getParameter("phone"));
		List<Customer> customers = customerDAO.getForListWithCriteria(cc);
		request.setAttribute("cuslist", customers);
		
		String path = "/queryCustomer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		
		//2.调用RequestDispatcher 的forward(request,response)进行请求的转发
		requestDispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("执行delete操作：");
		if(request.getParameter("id")==null){
			System.out.println("id 为空");
		}else{
			//try 。。。 catch 。。。 防止id 不能被转为int类型
			try{
				customerDAO.delete(Integer.parseInt(request.getParameter("id")));
			}catch(Exception e){
				System.out.println(e);
			}
		}
		response.sendRedirect("query.do");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("执行update操作：");
		//1.获取表单参数：id,name,address,phone
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldname = request.getParameter("oldname");
		//2.检验name是否可用
		//2.1比较name和oldname是否相同，若相同说明name可用
		if(!oldname.equalsIgnoreCase(name)){
			//2.2若不相同，调用customerDAO的getCountWithName(String name)获取name在数据库中是否存在
			long count = customerDAO.getCountWithName(name);
			//2.3若返回值大于0，则响应updateCustomer.jsp页面：通过转发的方式来响应newCusomer。jsp
			if(count>0){
				//2.3.1 要求在updateCustomer.jsp上显示一个错误消息：用户名已经被占用
				//在request中放入一个message:用户名已经 被占用，在页面上通过request.getAttribute("message")的方式显示
				request.setAttribute("message", "用户名"+name+"已经被占用,请重新选择。");
				//2.3.2updateCustomer.jsp的表单值可以回显:address,phone显示可以提交的信息，name显示oldName，而不是新的name
				//通过value="<%=request.getAttribute("name")==null? "":request.getAttribute("name")%>"
				
				System.out.println("/updateCustomer.jsp");
				request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
				return;
			}
		}
		//3.若验证通过，则把表单参数封装在一个Customer对象customer
		Customer customer = new Customer(name,address,phone);
		customer.setId(Integer.parseInt(id));
		//4.调用customerDAO.update(Customer customer)执行更新操作
		customerDAO.update(customer);
		//5.重定向到query.do页面：使用重定向可以避免表单重复提交的问题。
		response.sendRedirect("query.do");
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("执行edit操作：");
		String forwardPath="/error.jsp";
		//1.获取请求参数id
		String idstr = request.getParameter("id");
		int id=-1;
		
		//2.调用CustomerDAO的customerDAO.get(id)获取指定id对应的对象Customer
		try {
			Customer customer=customerDAO.get(Integer.parseInt(idstr));
			if(customer!=null){
				forwardPath="/updateCustomer.jsp";
				//3.将Customer放入request中
				request.setAttribute("customer", customer);
			}
		} catch (Exception e) {}		
		
		//4.响应updateCustomer.jsp,转发
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("执行add操作：");
		//1.获取表单参数
		String name =request.getParameter("name");
		String address =request.getParameter("address");
		String phone =request.getParameter("phone");
		//2.1检验name是否已经 被占用:调用CustomerDAO的getCountWithName(String Name)获取name在数据库中是否存在
		long count = customerDAO.getCountWithName(name);

		//2.2若返回值大于0，则响应newCustomer.jsp
		if(count>0){
			//2.2.1 要求在newCustomer.jsp上显示一个错误消息：用户名已经被占用
			//在request中放入一个message:用户名已经 被占用，在页面上通过request.getAttribute("message")的方式显示
			request.setAttribute("message", "用户名"+name+"已经被占用,请重新选择。");
			
			//2.2.2newCustomer.jsp的表单值可以回显
			//通过value="<%=request.getAttribute("name")==null? "":request.getAttribute("name")%>"
			
			//2.2.3结束方法：return
			request.getRequestDispatcher("/newCustomer.jsp").forward(request, response);
			return;
		}

		//3.调用CustomerDAO的save(Customer custoemer)执行保存操作
		Customer customer = new Customer(name,address,phone);
		customerDAO.save(customer);
		//4.重定向到success.jsp,使用重定向可以避免表单的重复提交
		response.sendRedirect("success.jsp");
	}

}
