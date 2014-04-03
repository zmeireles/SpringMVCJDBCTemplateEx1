package com.spring.mvc.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.jdbc.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int line) throws SQLException {
		CustomerExtractor custExtract=new CustomerExtractor();
		
		return custExtract.extractData(rs);
	}
	
	

}
