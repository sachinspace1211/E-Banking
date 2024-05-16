<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
				<h3 id="details-heading">Enter the details</h3>
				<form action="addCustomer" method="post">
					<table>
						<tr>
							<td>First Name:</td>
							<td><input type="text" maxlength="32"
								pattern="[A-Za-z]{1,32}" name="firstName" required="required" /></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><input type="text" maxlength="32"
								pattern="[A-Za-z]{1,32}" name="lastName" required="required" /></td>
						</tr>
						<tr>
							<td>Age:</td>
							<td><input type="number" min="18" max="120" name="age"
								required="required" /></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td><input type="radio" name="gender" value="male" />Male <input
								type="radio" name="gender" value="female" />Female</td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" pattern="[A-Za-z]{1,32}" name="city" /></td>
						</tr>
						<tr>
							<td>Occupation:</td>
							<td><input type="text" pattern="[A-Za-z]{1,32}"
								name="occupation" /></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" /></td>
						</tr>
						<tr>
							<td>Contact Number:</td>
							<td><input type="text" name="contact"
								title="Enter 10 digit number" pattern="[1-9]{1}[0-9]{9}"
								required="required" /></td>
						</tr>
						<tr>
							<td>Annual Income:</td>
							<td><input type="number" min="0" max="9223372036854775807"
								name="annualIncome" required="required" /></td>
						</tr>
						<tr>
							<td>Account Type:</td>
							<td><select name="accountType">
									<option value="saving">Saving</option>
									<option value="current">Current</option>
									<option value="recurring">Recurring</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="submit" value="Add" /></td>
						</tr>
					</table>
					<input type="hidden" name="action" value="add" />
				</form>
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