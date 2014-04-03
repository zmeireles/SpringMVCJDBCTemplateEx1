package com.spring.mvc.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.mvc.jdbc.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void insertCustomer(Customer cust) {
		// implementation of JDBC template
		String sql = "INSERT INTO customer_spring_jdbc (first_name,last_name,cust_type,address,city) "
				+ "values(?,?,?,?,?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(
				sql,
				new Object[] { cust.getFirstName(), cust.getLastName(),
						cust.getCustType(), cust.getAddress(), cust.getCity() });
	}

	@Override
	public List<Customer> getCustomerList() {
		List custList = new ArrayList();
		String sql = "select * from customer_spring_jdbc";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		custList = jdbcTemp.query(sql, new CustomerRowMapper());
		return custList;
	}

	@Override
	public void updateCustomer(Customer cust) {
		String sql = "update customer_spring_jdbc set first_name=?,last_name=?,cust_type=?,address=?,city=? "
				+ "where custid=?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql, cust.getFirstName(), cust.getLastName(),
				cust.getCustType(), cust.getAddress(), cust.getCity(),
				cust.getCustId());
		System.out.println("Customer "+cust.getFirstName() + " updated!");

	}

	@Override
	public Customer getCustomerToEdit(String custId) {
		List<Customer> custList = new ArrayList<Customer>();
		String sql = "select * from customer_spring_jdbc where custid="
				+ custId;

		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		custList = jdbcTemp.query(sql, new CustomerRowMapper());
		return custList.get(0);
	}

	@Override
	public void deleteCustomer(String custId) {

		String sql = "delete from customer_spring_jdbc where custid=" + custId;
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql);
	}

}
