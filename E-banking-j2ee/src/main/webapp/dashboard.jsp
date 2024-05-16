<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/dashboard.css">
</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
	if (session.getAttribute("username") ==null) {
     		response.sendRedirect("index.jsp");
     }%>
    <div class="container">
       <div class="navbar">
           <h3 id="logo">E-Banking</h3>
           <nav>
               <ul>
                 <li><a href="logout.jsp">LOGOUT</a></li>
                </ul>
            </nav>
        </div>
        <div>
             <h4>Welcome!  <%=session.getAttribute("username")%></h4>
        </div>
        <div class="row">
            <div class="col-1"  >
               <h2>Banking</h2>
               <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Illo illum aliquam Lorem ipsum
                 dolor sit amet, consectetur adipisicing elit. Corporis, quo cupiditate, consequatur 
                facere eos ut eveniet quis omnis ex pariatur minus. Illo minima aut tenetur laudantium impedit nemo odio. Quis.</p>
            </div>
            <div class="col">
               <a href="createCustomer.jsp"><button class="card"><h4>Create Customer</h4></button></a>
                <a href="modifyCustomer.jsp"><button class="card"><h4>Modify Customer</h4></button></a>
                <a href="addAccount.jsp"><button class="card"><h4>Add Account</h4></button></a>
                <a href="viewTransaction.jsp"><button class="card"><h4>View Transaction</h4></button></a>
            </div>
         </div> 
    </div>
</body>
</html>