package com.spring.mvc.jdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.jdbc.model.Customer;
import com.spring.mvc.jdbc.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@RequestMapping("/register")
	public ModelAndView registerCustomer(@ModelAttribute Customer customer){
		
		List<String> custTypeList = new ArrayList<String>();
		custTypeList.add("Permanent");
		custTypeList.add("Temporary");
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("London");
		cityList.add("Melborne");
		
		Map<String,List> custMappedVal = new HashMap<String, List>();
		custMappedVal.put("custTypeList", custTypeList);
		custMappedVal.put("cityList", cityList);
		
		return new ModelAndView("createCustomer","map",custMappedVal);
	}
	
	//code for form submission after filling all the required information for the customer
	
	@RequestMapping("/insertCustomer")
	public String insertData(@ModelAttribute Customer customer){
		if(customer!=null){
			custService.insertCustomer(customer);
		}
		return "redirect:/getList";
	}
	
	@RequestMapping("/getList")
	public ModelAndView getCustomerList(){
		List<Customer> custList=custService.getCustomerList();
		return new ModelAndView("custView","custList",custList);
	}
	
	@RequestMapping("/editCustomer")
	public ModelAndView editCustomer(@RequestParam String custId,@ModelAttribute Customer customer){
		customer=custService.getCustomerToEdit(custId);
		
		List<String> custTypeList = new ArrayList<String>();
		custTypeList.add("Permanent");
		custTypeList.add("Temporary");
		//custTypeList.add("Adhoc");
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("London");
		cityList.add("Melborne");
		
		Map<String,Object> custMappedVal = new HashMap<String, Object>();
		custMappedVal.put("custTypeList", custTypeList);
		custMappedVal.put("cityList", cityList);
		custMappedVal.put("customer",customer);
		
		return new ModelAndView("editCustomer","map",custMappedVal);
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute Customer customer){
		custService.updateCustomer(customer);
		return "redirect:/getList";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam String custId,@ModelAttribute Customer customer){
		custService.deleteCustomer(custId);
		return "redirect:/getList";
	}
}
