package com.spring.mvc.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.mvc.jdbc.model.Customer;

public class CustomerExtractor implements ResultSetExtractor<Customer>{

	@Override
	public Customer extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		
		Customer cust=new Customer();
		cust.setCustId(rs.getInt(1));
		cust.setFirstName(rs.getString(2));
		cust.setLastName(rs.getString(3));
		cust.setCustType(rs.getString(4));
		cust.setAddress(rs.getString(5));
		cust.setCity(rs.getString(6));
		return cust;
	}

	
}
