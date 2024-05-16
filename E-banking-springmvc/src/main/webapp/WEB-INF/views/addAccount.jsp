<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<style>
.col-1 {
	height: 80%;
	width: 81.7%;
	margin-left: 50px;
}

#details-heading {
	margin-left: 70px;
}

table {
	margin-top: 10px;
	border-collapse: separate;
	border-spacing: 0 0.5em;
}

#submit {
	margin-left: 30%;
	margin-top: 5%;
	width: 5em;
	height: 2em;
}
</style>
<link rel="stylesheet" href="resources/css/style1.css" type="text/css" />
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	}

	try {
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sachin@1205");
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("select * from customer");
	%>
	<div class="container">
		<div class="navbar">
			<h3 id="logo">E-Banking</h3>
			<nav>
				<ul>
					<li><a href="dashboard">HOME</a></li>
					<li><a href="logout">LOGOUT</a></li>
				</ul>
			</nav>
		</div>
		<div>
			<h4>
				Welcome!
				<%=session.getAttribute("username")%></h4>
		</div>
		<div class="row">
			<div class="col-1">
				<form action="addAccount" method="post">
					<table>
						<tr>
							<td>Select ID:</td>
							<td><select name="id" style="width: 100px"
								required="required">
									<%
									while (resultset.next()) {
									%>
									<option><%=resultset.getString(1)%></option>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<td>Account Type:</td>
							<td><select name="accountType" required="required">
									<option value="saving">Saving</option>
									<option value="current">Current</option>
									<option value="recurring">Recurring</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="submit" value="Add" /></td>
						</tr>
					</table>
					<input type="hidden" name="action" value="addAccount" />
				</form>
				<%
				} catch (Exception e) {
				out.println("wrong entry" + e);
				}
				%>
			</div>
			<div class="col">
				<a href="addCustomer"><button class="card">
						<h4>Create Customer</h4>
					</button></a> <a href="modifyCustomerJsp"><button class="card">
						<h4>Modify Customer</h4>
					</button></a> <a href="addAccount"><button class="card">
						<h4>Add Account</h4>
					</button></a> <a href="viewTransaction"><button class="card">
						<h4>View Transaction</h4>
					</button></a>
			</div>
		</div>
	</div>
</body>
</html>