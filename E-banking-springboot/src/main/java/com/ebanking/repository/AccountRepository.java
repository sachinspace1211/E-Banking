package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebanking.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value = "select max(accountNumber) from Account") 
	public Integer max();
}

