package com.anddigital.demo.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  
  public List<Customer> getAllCustomer()
  {
	  List<Customer> customer= new ArrayList<Customer>();
	  customerRepository.findAll().forEach(customer :: add);
	  return customer;
  }
  
  public void addCustomer(Customer customer)
  {
	  customerRepository.save(customer);
  }
}
