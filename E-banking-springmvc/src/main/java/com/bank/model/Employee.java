package com.bank.model;

public class Employee {

	private String username;
	private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;

		if (emp.getUsername().equals(this.username) && emp.getPassword().equals(this.password))
			return true;
		else
			return false;
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
