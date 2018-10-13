package com.anddigital.demo.customerMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerMappingService {

  @Autowired
  private CustomerMappingRepository customerMappingRepository;
  
  public List<CustomerMapping> getAllNumbers()
  {
	  List<CustomerMapping> customerMappingList= new ArrayList<CustomerMapping>();
	  customerMappingRepository.findAll().forEach(customerMappingList :: add);
	  return customerMappingList;
  }
  
  public List<CustomerMapping> getAllNumbersByCustomerId(String customerId)
  {
	  List<CustomerMapping> customerMappingList= new ArrayList<CustomerMapping>();
	  customerMappingRepository.findByCustomerId(customerId).forEach(customerMappingList :: add);
	  return customerMappingList;
  }
  
  public void addCustomerMapping(CustomerMapping customerMapping)
  {
	  customerMappingRepository.save(customerMapping);
  }
  public char activatePhoneNumber(Long phoneNumber)
  {
	  char flag='Y';
	  List<CustomerMapping> customerMappingList= new ArrayList<CustomerMapping>();
	  customerMappingRepository.findBySearchTerm(phoneNumber).forEach(customerMappingList :: add);
	  if(customerMappingList!=null && customerMappingList.size()>0)
	  {
		  CustomerMapping c=customerMappingList.get(0);
		  if(c.getActiveFlag()==0)
		  {
			  c.setActiveFlag(1);
			  customerMappingRepository.save(c);
		  }
		  else
		  {
			  flag='U';
		  }
	  }
	  else
	  {
		  flag='N';
	  }
	  return flag;
  }
  
}
