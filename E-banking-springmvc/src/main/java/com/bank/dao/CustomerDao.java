package com.bank.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bank.model.Account;
import com.bank.model.Customer;

public class CustomerDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addCustomer(Customer customer) {
		int id = (getAutoId().intValue()) + 1;
		int status = jdbcTemplate.update(
				"insert into customer(firstName,lastName,age,gender,city,"
						+ "occupation,email,contact,annualIncome,creditCard,id) values(?,?,?,?,?,?,?,?,?,?,?)",
				customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getGender(),
				customer.getCity(), customer.getOccupation(), customer.getEmail(), customer.getContact(),
				customer.getAnnualIncome(), customer.getCreditCard(), id);
		if (status > 0)
			new AccountDao(jdbcTemplate).addAccount(new Account(id, customer.getAccountType()));
		return status;
	}

	public int modifyCustomer(Customer customer) {
		return jdbcTemplate.update(
				"update customer set firstName=?,lastName=?,age=?,gender=?,"
						+ "city=?,occupation=?,email=?,contact=?,annualIncome=?,creditCard=? where id=?",
				customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getGender(),
				customer.getCity(), customer.getOccupation(), customer.getEmail(), customer.getContact(),
				customer.getAnnualIncome(), customer.getCreditCard(), customer.getId());
	}

	public Integer getAutoId() {
		return (Integer) jdbcTemplate.queryForObject("select Max(id)from customer", Integer.class);
	}
}
