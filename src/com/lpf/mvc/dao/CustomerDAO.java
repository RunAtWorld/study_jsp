package com.lpf.mvc.dao;

import java.util.List;

import com.lpf.mvc.domain.Customer;

public interface CustomerDAO {

	public List<Customer> getAll();
	
	public List<Customer> getForListWithCriteria(CriteriaCustomer cc);
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Customer cc);
	
	/**
	 * 返回和name相等的记录数
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
