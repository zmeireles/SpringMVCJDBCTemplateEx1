package com.spring.mvc.jdbc.dao;

import java.util.List;

import com.spring.mvc.jdbc.model.Customer;

public interface CustomerDao {

	public void insertCustomer(Customer cust);
	
	public List<Customer> getCustomerList();
	
	public void updateCustomer(Customer cust);
	
	public Customer getCustomerToEdit(String custId);
	
	public void deleteCustomer(String custId);
}
