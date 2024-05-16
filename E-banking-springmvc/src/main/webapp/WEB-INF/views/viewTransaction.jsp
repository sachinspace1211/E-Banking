<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String form_date = request.getParameter("form_date");
String to_date = request.getParameter("to_date");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "bank";
String userid = "root";
String password = "Sachin@1205";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<head>
<style>
h3{
  text-decoration:none;
  color:#fff;
  font-size:27Px;
}
.col-1 {
	height: 80%;
	width: 95%;
}
#form-transaction {
	margin-left: 50px;
}
table{
    margin-top:10px;
    border-collapse:separate;    
}
#submit{
	margin-left:30%;
	margin-top:5%;
    width: 5em;  
    height: 2em;
}

#t2{
	border:1px solid;
    border-collapse: collapse;
}
#f1{
	margin-left:50px;
}
</style>
<link rel="stylesheet" href="resources/css/style1.css"
	type="text/css" />
<script>
	let Fecha_end_input = document.getElementById("date")
	let n = new Date();
	let y = n.getFullYear();
	let m = n.getMonth() + 1;
	let d = n.getDate();
	if (m < 10)
		m = '0' + m.toString();
	else if (d < 10)
		d = '0' + d.toString();

	let minDate = y + '-' + m + '-' + d
	let maxDate = y + '-' + "0" + (parseFloat(0 + m) + 1) + '-' + d

	Fecha_end_input.setAttribute("min", minDate)
	Fecha_end_input.setAttribute("max", maxDate)
</script>
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
	<%
	try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		Statement statement1 = connection.createStatement();
		ResultSet resultset1 = statement1.executeQuery("select * from customer");
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
				<div class="form-transaction">
					<form method="post" action="viewTransaction.jsp" id="f1">
						<table id="t1">
							<tr>
								<td>Select ID:</td>
								<td><select name="id" style="width: 100px"
									required="required">
										<%
										while (resultset1.next()) {
										%>
										<option><%=resultset1.getString(1)%></option>
										<%
										}
										%>
								</select></td>
							<tr>
								<td>From Date:</td>
								<td><input type="date" max="2022-08-09"
									class="disableFuturedate" name="form_date" required="required"></td>
							</tr>
							<tr>
								<td>To Date:</td>
								<td><input type="date" max="2022-08-09"
									class="disableFuturedate" name="to_date" required="required"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" id="submit"
									value="Submit"></td>
							</tr>
						</table>
					</form>
					<%
					} catch (Exception e) {
					out.println("wrong entry" + e);
					}
					%>
				</div>
				<div>
					<%
					if (id != null) {
					%>
					<table id="t2">
						<tr>
							<td id="t2">S No.</td>
							<td id="t2">From Account</td>
							<td id="t2">To Account</td>
							<td id="t2">Mode</td>
							<td id="t2">Amount</td>
							<td id="t2">Date</td>
							<td id="t2">Status</td>
						</tr>
						<%
						try {
							statement = connection.createStatement();
							String sql = "select * from transaction where transactionDate between '" + form_date + "' and '" + to_date
							+ "' and id='" + id + "'";
							resultSet = statement.executeQuery(sql);
							while (resultSet.next()) {
								int i = 1;
						%>
						<tr id="t2">
							<td id="t2"><%=i%></td>
							<td id="t2"><%=resultSet.getString("fromAccount")%></td>
							<td id="t2"><%=resultSet.getString("toAccount")%></td>
							<td id="t2"><%=resultSet.getString("mode")%></td>
							<td id="t2"><%=resultSet.getString("amount")%></td>
							<td id="t2"><%=resultSet.getString("transactionDate")%></td>
							<td id="t2"><%=resultSet.getString("status")%></td>
						</tr>
						<%
						i++;
						%>
						<%
						}
						connection.close();
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>
						<%
						}
						%>
					</table>
				</div>
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
	<script>
		$(document).ready(function() {
			var currentDate = new Date();
			$('.disableFuturedate').datepicker({
				format : 'dd/mm/yyyy',
				autoclose : true,
				endDate : "currentDate",
				maxDate : currentDate
			}).on('changeDate', function(ev) {
				$(this).datepicker('hide');
			});
			$('.disableFuturedate').keyup(function() {
				if (this.value.match(/[^0-9]/g)) {
					this.value = this.value.replace(/[^0-9^-]/g, '');
				}
			});
		});
	</script>
</body>
</html>