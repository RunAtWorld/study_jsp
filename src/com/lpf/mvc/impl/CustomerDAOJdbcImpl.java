package com.lpf.mvc.impl;

import java.util.List;

import com.lpf.mvc.dao.CriteriaCustomer;
import com.lpf.mvc.dao.CustomerDAO;
import com.lpf.mvc.dao.DAO;
import com.lpf.mvc.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		System.out.println("JDBC - getAll");
		String sql = "SELECT id,name,address,phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		System.out.println("JDBC - save");
		String sql = "INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		System.out.println("JDBC - update");
		String sql = "SELECT id,name,address,phone FROM customers WHERE id=?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		System.out.println("JDBC - get");
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("JDBC - getCountWithName");
		String sql = "SELECT count(id) FROM customers WHERE name= ?";
		return getForValue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteria(CriteriaCustomer cc) {
		System.out.println("JDBC - getForListWithCriteria");
		String sql= "SELECT id,name,address,phone FROM customers " + 
					"WHERE name LIKE ? AND address LIKE ? AND phone LIKE ?";
		return getForList(sql, cc.getName(),cc.getAdress(),cc.getPhone());
	}

	@Override
	public void update(Customer cc) {
		System.out.println("JDBC - update");
		String sql= "UPDATE customers SET name=?,address=?,phone=? " + 
				"WHERE id=?";
		update(sql, cc.getName(),cc.getAddress(),cc.getPhone(),cc.getId());
	}

}
