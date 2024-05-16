package com.ebanking.entities;

import java.util.Date;

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
@Table(name = "transaction")
@Component
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;

	private String fromAccount;
	private String toAccount;
	private String mode;
	private long amount;
	private Date date;
	private String status;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	public Transaction() {
		super();

	}

	
	public Transaction(int tId, String fromAccount, String toAccount, String mode, long amount, Date date,
			String status, Customer customer) {
		super();
		this.tId = tId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.mode = mode;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.customer = customer;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
	   
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTId() {
		return tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
