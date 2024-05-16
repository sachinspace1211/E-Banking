package com.bank.model;
import java.util.Date;
public class Transaction {
	private String fromAccount;
	private String toAccount;
	private String mode;
	private long amount;
	private Date date;
	private String status;

	public Transaction(String fromAccount, String toAccount, String mode, long amount, Date date, String status) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.mode = mode;
		this.amount = amount;
		this.date = date;
		this.status = status;
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

}
