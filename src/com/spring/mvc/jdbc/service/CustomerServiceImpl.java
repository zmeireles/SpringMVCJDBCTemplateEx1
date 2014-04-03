package com.spring.mvc.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.jdbc.dao.CustomerDao;
import com.spring.mvc.jdbc.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao custDao;
	
	@Override
	public void insertCustomer(Customer cust) {
		custDao.insertCustomer(cust);
		
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return custDao.getCustomerList();
	}

	@Override
	public void deleteCustomer(String custId) {
		custDao.deleteCustomer(custId);
	}

	@Override
	public Customer getCustomerToEdit(String id) {
		
		return custDao.getCustomerToEdit(id);
	}

	@Override
	public void updateCustomer(Customer cust) {
		custDao.updateCustomer(cust);
		
	}
	
	

}
