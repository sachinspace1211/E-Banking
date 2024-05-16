<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<link rel="stylesheet" href="assets/css/modifyCustomer.css">
</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
	if (session.getAttribute("username") ==null) {
     		response.sendRedirect("index.jsp");
    }%>
    <sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/bank" user="root"
		password="Sachin@1205" />

	<sql:query dataSource="${dbsource}" var="result1">
            SELECT * from customer;
	</sql:query>
	<sql:query dataSource="${dbsource}" var="result">
            SELECT * from customer where id=?;
            <sql:param value="${param.id}" />
	</sql:query>
	<div class="container">
		<div class="navbar">
			<h3 id="logo">E-Banking</h3>
			<nav>
				<ul>
					<li><a href="dashboard.jsp">HOME</a></li>
					<li><a href="logout.jsp">LOGOUT</a></li>
				</ul>
			</nav>
		</div>
		<div>
			 <h4>Welcome!  <%=session.getAttribute("username")%></h4>
		</div>
		<div class="row">
			<div class="col-1">
				<form action="modifyCustomer.jsp" method="post" id="form1">
					<table>
						<tr>
							<td>Select ID:</td>
							<td><select name="id" style="width:100px" required="required">
								<c:forEach var="row1" items="${result1.rows}">
									<option>${row1.id}</option>
							    </c:forEach>
							</select></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="submit"
								value="Select" /></td>
						</tr>
					</table>
				</form>
				<form action="EmployeeServlet" method="post">
					<table>
						<c:forEach var="row" items="${result.rows}">
							<h3 id="details-heading">Enter the modified details</h3>
							<input type="hidden" value="${row.id}" name="id" />
							<tr>
							<td>First Name:</td>
							<td><input type="text" maxlength="32" pattern="[A-Za-z]{1,32}" name="firstName"
							 value="${row.firstName}" required="required" /></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><input type="text" maxlength="32" pattern="[A-Za-z]{1,32}"" name="lastName" 
							value="${row.lastName}" required="required"/></td>
						</tr>
						<tr>
							<td>Age:</td>
							<td><input type="number" min="18" max="120" name="age" 
							value="${row.age}" required="required" /></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td><input type="radio" name="gender" value="male" />Male <input
								type="radio" name="gender" value="female" />Female</td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" pattern="[A-Za-z]{1,32}" value="${row.city}" name="city" /></td>
						</tr>
						<tr>
							<td>Occupation:</td>
							<td><input type="text"  pattern="[A-Za-z]{1,32}" value="${row.occupation}" name="occupation" /></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="email"  value="${row.email}" name="email" /></td>
						</tr>
						<tr>
							<td>Contact Number:</td>
							<td><input type="text" name="contact" title="Enter 10 digit number" 
							 value="${row.contact}" pattern="[1-9]{1}[0-9]{9}" required="required"/></td>
						</tr>
						<tr>
							<td>Annual Income:</td>
							<td><input type="number" min="0" max="9223372036854775807" name="annualIncome" 
							 value="${row.annualIncome}" required="required" /></td>
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
						</c:forEach>
					</table>
					<input type="hidden" name="action" value="update" />
				</form>
			</div>
			<div class="col">
				     <a href="createCustomer.jsp"><button class="card">
						<h4>Create Customer</h4>
					</button></a> <a href="modifyCustomer.jsp"><button class="card">
						<h4>Modify Customer</h4>
					</button></a> <a href="addAccount.jsp"><button class="card">
						<h4>Add Account</h4>
					</button></a> <a href="viewTransaction.jsp"><button class="card">
						<h4>View Transaction</h4>
					</button></a>
			</div>
		</div>
	</div>
</body>
</html>