package com.ebanking.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.entities.Transaction;

@SpringBootTest
class TransactionServiceTest {
	
	@Autowired
	private TransactionService transactionService;
	

	@BeforeEach
	void setUp() throws Exception {
	
	}

	@Test
	void  getAllTransactionsTest(){
		List<Transaction> returnedAllTransaction = this.transactionService.getAllTransactions();
		assertNotEquals(null, returnedAllTransaction);
	}

}
