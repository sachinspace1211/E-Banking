<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
    <% session = request.getSession(); %>
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
        <div >
              <h4>Welcome!</h4>
        </div>
        <div class="row">
            <div class="col-1"  >
               <h2>Banking</h2>
               <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Illo illum aliquam Lorem ipsum
                 dolor sit amet, consectetur adipisicing elit. Corporis, quo cupiditate, consequatur 
                facere eos ut eveniet quis omnis ex pariatur minus. Illo minima aut tenetur laudantium impedit nemo odio. Quis.</p>
            </div>
            <div class="card">
              <form action="EmployeeLogin" class="form" method="post">
               <div id="heading"><h2>Login</h2></div>
               <table>
                  <%if(session.getAttribute("alert")!=null){%>
                	  <%=session.getAttribute("alert")%>
                  <%}%>
                  <tr><td>Username:<input type="text" id="input" name="username" required="required"/></td></tr>
                  <tr><td>Password:<input type="password" id="input" name="password" required="required"/></td></tr>
                  <tr><td ><input type="submit" id="submit" value="login"/></td></tr>
              </table>
           </form>
          </div> 
          </div>
    </div>
</body>
</html>