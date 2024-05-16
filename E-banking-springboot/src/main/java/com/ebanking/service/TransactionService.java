package com.ebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebanking.entities.Transaction;
import com.ebanking.repository.TransactionRepository;

@Component
@Service("transactionService")
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransactions(){
		return this.transactionRepository.findAll();
	}

}
