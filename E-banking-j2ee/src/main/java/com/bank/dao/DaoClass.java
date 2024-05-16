package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Employee;

public class DaoClass {

	public boolean checkLogin(Employee login) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String user = login.getUsername();
		String pass = login.getPassword();

		con = MySqlConn.getConn();
		String query = "select * from Employee where username=? and password=?";

		stmt = con.prepareStatement(query);
		stmt.setString(1, user);
		stmt.setString(2, pass);

		rs = stmt.executeQuery();

		if (rs.next())
			return true;

		return false;
	}

	public int addCustomer(Customer u) {
		int status = 0;
		try {
			Connection con = MySqlConn.getConn();
			PreparedStatement ps = con.prepareStatement("insert into customer(firstName,lastName,age,gender,city,"
					+ "occupation,email,contact,annualIncome,creditCard,id) values(?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement psa = con
					.prepareStatement("insert into account(accountType,accountNumber,id)values(?,?,?)");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, String.valueOf(u.getAge()));
			ps.setString(4, u.getGender());
			ps.setString(5, u.getCity());
			ps.setString(6, u.getOccupation());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getContact());
			ps.setString(9, String.valueOf(u.getAnnualIncome()));
			ps.setString(10, u.getCreditCard());
			int id = getAutoId();
			ps.setString(11, String.valueOf(id));
			psa.setString(1, u.getAccountType());
			psa.setString(2, String.valueOf(getAutoAccountNumber()));
			psa.setString(3, String.valueOf(id));
			status = ps.executeUpdate();
			if (status > 0)
				psa.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int update(Customer u, int id) {
		int status = 0;
		try {
			Connection con = MySqlConn.getConn();
			PreparedStatement ps = con.prepareStatement("update customer set firstName=?,lastName=?,age=?,gender=?,"
					+ "city=?,occupation=?,email=?,contact=?,annualIncome=?,creditCard=? where id=?");
			System.out.println("modifydao");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, String.valueOf(u.getAge()));
			ps.setString(4, u.getGender());
			ps.setString(5, u.getCity());
			ps.setString(6, u.getOccupation());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getContact());
			ps.setString(9, String.valueOf(u.getAnnualIncome()));
			ps.setString(10, u.getCreditCard());
			ps.setString(11, Integer.toString(id));
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int addAccount(Account account) {
		int status = 0;
		try {
			Connection con = MySqlConn.getConn();
			PreparedStatement ps = con
					.prepareStatement("insert into account(id,accountType,accountNumber)values(?,?,?)");
			ps.setString(1, String.valueOf(account.getId()));
			ps.setString(2, account.getAccountType());
			ps.setString(3, String.valueOf(getAutoAccountNumber()));
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int getAutoId() {
		try {
			Connection con = MySqlConn.getConn();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select Max(id)from customer");
			rs.next();
			rs.getString("Max(id)");
			if (rs.getString("Max(id)") == null) {
				return 1000000;
			} else {
				return Integer.parseInt(rs.getString("Max(id)")) + 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

	public long getAutoAccountNumber() {
		try {
			Connection con = MySqlConn.getConn();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select Max(accountNumber)from account");
			rs.next();
			rs.getString("Max(accountNumber)");
			if (rs.getString("Max(accountNumber)") == null) {
				return 20000055500120l;
			} else {
				return (Long.parseLong(rs.getString("Max(accountNumber)"))) + 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
}
