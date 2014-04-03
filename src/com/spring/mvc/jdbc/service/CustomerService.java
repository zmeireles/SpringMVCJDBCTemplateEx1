package com.spring.mvc.jdbc.service;

import java.util.List;

import com.spring.mvc.jdbc.model.Customer;

public interface CustomerService {

	public void insertCustomer(Customer cust);
	public List<Customer> getCustomerList();
	public void deleteCustomer(String custId);
	public Customer getCustomerToEdit(String id);
	public void updateCustomer(Customer cust);
}
