package com.ebanking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "account")
@Component
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String accountType;
	
	private int accountNumber;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	public Account() {
		super();
	}

	public Account(int aId, String accountType, int accountNumber, Customer customer) {
		super();
		this.aId = aId;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.customer = customer;
	}

	public int getAId() {
		return aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
