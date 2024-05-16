<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	session.invalidate();
	%>
	<%
	HttpSession nsession = request.getSession(false);
	response.sendRedirect("index.jsp");
	%>
</body>
</html>