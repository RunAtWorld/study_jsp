package com.lpf.mvc.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.lpf.mvc.dao.CriteriaCustomer;
import com.lpf.mvc.dao.CustomerDAO;
import com.lpf.mvc.domain.Customer;
import com.lpf.mvc.impl.CustomerDAOJdbcImpl;

public class CustomerDAOJdbcImplTest {

	private CustomerDAO	customerDAO=new CustomerDAOJdbcImpl();
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}
	
	@Test
	public void testgetForListWithCriteria(){
		CriteriaCustomer cc = new CriteriaCustomer("z", null, null);
		List<Customer> customers = customerDAO.getForListWithCriteria(cc);
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setAddress("shanghai");
		customer.setName("lin");
		customer.setPhone("13475441725");
		
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
		customerDAO.delete(2);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("lin");
		System.out.println(count);
		
	}
	


}
