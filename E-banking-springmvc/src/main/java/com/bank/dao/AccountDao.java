package com.bank.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bank.model.Account;

public class AccountDao {
	JdbcTemplate jdbcTemplate;

	public AccountDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addAccount(Account account) {
		long accountNumber = (getAutoAccountNumber().longValue()) + 1;
		return jdbcTemplate.update("insert into account(id,accountType,accountNumber)values(?,?,?)", account.getId(),
				account.getAccountType(), accountNumber);
	}

	public Long getAutoAccountNumber() {
		Long maxAccountNumber = (Long) jdbcTemplate.queryForObject("select Max(accountNumber)from account", Long.class);
		if (maxAccountNumber == null)
			return 20000055500119l;
		else
			return maxAccountNumber;
	}

}
