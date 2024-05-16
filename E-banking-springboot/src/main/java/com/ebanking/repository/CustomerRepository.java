package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebanking.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "select max(id) from Customer") 
	public Integer max();
}
