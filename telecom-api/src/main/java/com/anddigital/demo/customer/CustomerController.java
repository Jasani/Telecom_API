package com.anddigital.demo.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	//These methods are for testing purpose only to store data.
	
	@RequestMapping("/customer")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomer();
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/customer")
	public void addCustomer(@RequestBody Customer customer)
	{ 
		customerService.addCustomer(customer);
	}
}
