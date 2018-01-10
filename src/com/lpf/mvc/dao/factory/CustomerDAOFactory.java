package com.lpf.mvc.dao.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lpf.mvc.dao.CriteriaCustomer;
import com.lpf.mvc.dao.CustomerDAO;
import com.lpf.mvc.domain.Customer;
import com.lpf.mvc.impl.CustomerDAOJdbcImpl;
import com.lpf.mvc.impl.CustomerDAOXMLImpl;

public class CustomerDAOFactory {
	private static CustomerDAOFactory instance =new CustomerDAOFactory();
	private String type = null;
	private Map<String,CustomerDAO> daos = new HashMap<String,CustomerDAO>();
	
	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXMLImpl());
	}
	
	public static CustomerDAOFactory getInstance(){
		return instance;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	
	public CustomerDAO getCustomerDAO(){
		return daos.get(type);
	}
	
	
}
