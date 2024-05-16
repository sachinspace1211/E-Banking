<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h3 {
	text-decoration: none;
	color: #fff;
	font-size: 27Px;
}

.login-wrapper {
	display: flex;
	height: 40%;
	align-items: center;
	padding-left: 40%;
}

.col-1 {
	height: 60%;
	width: 76%;
}

.col {
	flex-basis: 70%;
}

#heading {
	margin-left: 30%;
	margin-top: 25px;
	margin-bottom: 20px;
}

table {
	margin-top: 20px;
	border-collapse: separate;
	border-spacing: 0 1em;
}

#submit {
	margin-left: 30%;
	margin-top: 10%;
	width: 5em;
	height: 2em;
}

#input {
	font-size: 12pt;
	height: 30px;
	width: 220px;
}

#cardIndex {
	width: 280px;
	height: 350px;
	display: inline-block;
	border-radius: 10px;
	padding: 15px 25px;
	box-sizing: border-box;
	cursor: pointer;
	margin: 10px 15px;
	background-color: rgb(130, 135, 137);
	background-position: center;
	background-size: cover;
	transition: transform 0.5s;
	border: none;
}
</style>
<link rel="stylesheet" href="resources/css/style1.css" type="text/css">
</head>
<body>
	<div class="container">
		<div class="navbar">
			<h3 class="logo">E-Banking</h3>
			<nav>
				<ul>
					<li><a href="">About</a></li>
					<li><a href="">Contact US</a></li>
				</ul>
			</nav>
		</div>
		<div>
			<h4>Welcome!</h4>
		</div>
		<div class="row">
			<div class="col-1">
				<h2>Banking</h2>
				<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.
					Illo illum aliquam Lorem ipsum dolor sit amet, consectetur
					adipisicing elit. Corporis, quo cupiditate, consequatur facere eos
					ut eveniet quis omnis ex pariatur minus. Illo minima aut tenetur
					laudantium impedit nemo odio. Quis.</p>
			</div>
			<div class="card" id="cardIndex">
				<form action="checkLogin" class="form" method="post">
					<div id="heading">
						<h2>Login</h2>
					</div>
					<table>
						<%
						if (request.getParameter("alert") != null) {
						%>
						<%=request.getParameter("alert")%>
						<%
						}
						%>
						<tr>
							<td>Username:<input type="text" id="input" name="username"
								required="required" /></td>
						</tr>
						<tr>
							<td>Password:<input type="password" id="input"
								name="password" required="required" /></td>
						</tr>
						<tr>
							<td><input type="submit" id="submit" value="login" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>