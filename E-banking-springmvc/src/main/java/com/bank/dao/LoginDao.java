package com.bank.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bank.model.Employee;

public class LoginDao {
	JdbcTemplate jdbcTemplate;

	public LoginDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Employee checkLogin(Employee employee) {
		try {
			return jdbcTemplate.queryForObject("select * from Employee where username=? and password=?",
					new BeanPropertyRowMapper<Employee>(Employee.class), employee.getUsername(),
					employee.getPassword());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
