package com.bank.model;

public class Account {

	private int id;
	private String accountType;
	private String accountNumber;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String accountType) {
		super();
		this.id = id;
		this.accountType = accountType;
	}

	public Account(int id, String accountType, String accountNumber) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
