package com.ebanking.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.entities.Account;
import com.ebanking.entities.Customer;

@SpringBootTest
class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	Customer customer;
	Account account;

	@BeforeEach
	void setUp() throws Exception {

		customer = new Customer();
		customer.setId(1);
		customer.setAccountType("Saving");
		account = new Account();
		account.setCustomer(customer);
		account.setAccountNumber(100000000);
	}

	@AfterEach
	void setDown() throws Exception {
		account = null;
	}

	@Test
	@Transactional
	@Rollback(true)
	void addTest() {
		Account returnedAccount = this.accountService.add(account);
		assertNotEquals(null, returnedAccount);
	}
}
