package com.anddigital.demo.customerMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.anddigital.demo.customer.Customer;

@Entity
public class CustomerMapping 
{
	@Id
	private String id;
	private Long phoneNumber;
	private Integer activeFlag;
	@ManyToOne
	private Customer customer;
	
	public CustomerMapping() {
		
	}
	
	public CustomerMapping(String id, Long phoneNumber, Integer activeFlag,String customerId) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.activeFlag = activeFlag;
		this.customer=new Customer(customerId,"","");
	}
	public String getId() {
		return id;
	}
	public void setMpgId(String id) {
		this.id = id;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
