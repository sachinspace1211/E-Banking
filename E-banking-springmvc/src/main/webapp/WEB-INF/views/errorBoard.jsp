<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.col-1 {
	height: 40%;
	width: 90%;
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
	%>
	<div class="container">
		<div class="navbar">
			<h3 id="logo">E-Banking</h3>
			<nav>
				<ul>
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
				<p>
					<%
					if (request.getParameter("alert") != null) {
					%>
					<%=request.getParameter("alert")%>
					<%
					}
					%>
				</p>
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