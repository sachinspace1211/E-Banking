package com.ebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebanking.entities.Account;
import com.ebanking.repository.AccountRepository;

@Component
@Service

public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerService customerService;

	public Account add(Account account) {

		this.accountRepository.save(account);
		return account;

	}
	public Integer getAccountNumber() {
	    Integer maxAccountNumber = this.accountRepository.max();
	    if( maxAccountNumber==null)
	    	return 1000000;
		return maxAccountNumber+1;
	}

}
