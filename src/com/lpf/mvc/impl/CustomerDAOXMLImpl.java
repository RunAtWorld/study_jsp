package com.lpf.mvc.impl;

import java.util.List;

import com.lpf.mvc.dao.CriteriaCustomer;
import com.lpf.mvc.dao.CustomerDAO;
import com.lpf.mvc.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getAll() {
		System.out.println("XML - getAll");
		return null;
	}

	@Override
	public List<Customer> getForListWithCriteria(CriteriaCustomer cc) {
		System.out.println("XML - getForListWithCriteria");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("XML - save");

	}

	@Override
	public Customer get(Integer id) {
		System.out.println("XML - get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("XML - delete");

	}

	@Override
	public void update(Customer cc) {
		System.out.println("XML - update");

	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("XML - getCountWithName");
		return 0;
	}

}
