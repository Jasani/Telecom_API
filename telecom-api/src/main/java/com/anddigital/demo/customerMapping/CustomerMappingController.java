package com.anddigital.demo.customerMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anddigital.demo.customer.Customer;

@RestController
public class CustomerMappingController {

	@Autowired
	private CustomerMappingService customerMappingservice;
	
	
	//get all the phone numbers present with customer details.
	//Example URL to be used-http://localhost:8080/customerMapping
	@RequestMapping("/customerMapping")
	public List<CustomerMapping> getAllNumbers()
	{
		return customerMappingservice.getAllNumbers();
	}
	
	//get all the phone numbers present for a particular customer.CustomerId needs to be passed in the URL.
	//Example URL to be used-http://localhost:8080/customer/customerId/customerMapping
	@RequestMapping("/customer/{id}/customerMapping")
	public List<CustomerMapping> getAllNumbersOfCustomer(@PathVariable String id)
	{
		return customerMappingservice.getAllNumbersByCustomerId(id);
		
	}
	
	//This method is for testing purpose only to save data.
	@RequestMapping(method=RequestMethod.POST,value="/customer/{customerId}/customerMapping")
	public void addCustomerMapping(@RequestBody CustomerMapping customerMapping,@PathVariable String customerId)
	{
		customerMapping.setCustomer(new Customer(customerId, "", ""));
		customerMappingservice.addCustomerMapping(customerMapping);
		
	}
	
	//Activate a particular phone number.
	//Example URL to be used-http://localhost:8080/customerMapping/phoneNumber
	
	@RequestMapping(method=RequestMethod.PUT,value="customerMapping/{phoneNumber}")
	public String deactivateCustomerMapping(@PathVariable Long phoneNumber)
	{
		
		char flag=customerMappingservice.activatePhoneNumber(phoneNumber);
		if (flag=='Y')
		{
			return "Phone number ativated successfully!!";
		}
		else if(flag=='N')
		{
			return "Phone number does not exist in the repository.";
		}
		else
		{
			return "Phone number is already active.";
		}
	}
	
}
