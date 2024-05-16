package com.ebanking.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

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
class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	Customer customer;
	Account account;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer();
		customer.setId(1000);
		customer.setFirstName("test");
		customer.setLastName("test");
		customer.setAge(22);
		customer.setGender("Male");
		customer.setCity("Indore");
		customer.setOccupation("Engineer");
		customer.setEmail("sachin@gmail.com");
		customer.setContact("7225866143");
		customer.setAnnualIncome(10000000l);
		customer.setCreditCard();
		customer.setAccountType("Saving");

		List<Account> list = new ArrayList<Account>();
		Account account = new Account();
		account.setAccountType(customer.getAccountType());
		account.setAccountNumber(10000000);

		list.add(account);
		customer.setAccounts(list);
	}

	@AfterEach
	void setDown() throws Exception {
		customer = null;
		account = null;
	}

	@Test
	@Transactional
	@Rollback(true)
	void addTest() {
		Customer returnedCustomer = customerService.add(customer);
		assertNotEquals(null, returnedCustomer);
	}

	@Test
	@Transactional
	@Rollback(true)
	void updateTest() {
		Customer returnedCustomer = customerService.update(customer);
		assertNotEquals(null, returnedCustomer);
	}

	@Test
	void getAllCustomer() {
		List<Customer> customer = customerService.getAllCustomer();
		assertNotEquals(null, customer);
	}

	@Test
	void getCustomerById() {
		Customer returnedcustomer = customerService.getCustomerById(1000);
		assertNotEquals(null, returnedcustomer);
	}

}
