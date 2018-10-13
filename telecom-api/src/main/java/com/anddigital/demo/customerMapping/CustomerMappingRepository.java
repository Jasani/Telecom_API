package com.anddigital.demo.customerMapping;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CustomerMappingRepository extends CrudRepository<CustomerMapping,String>{

	public List<CustomerMapping> findByCustomerId(String customerId);
	@Query("SELECT c FROM CustomerMapping c WHERE " +
            "c.phoneNumber = :searchTerm ")
    public List<CustomerMapping> findBySearchTerm(@Param("searchTerm") Long searchTerm);
	
}
