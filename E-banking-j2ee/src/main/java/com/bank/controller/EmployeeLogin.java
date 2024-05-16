package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.DaoClass;
import com.bank.model.Employee;

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	DaoClass obj=new DaoClass();
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean result=false;

		String username=request.getParameter("username");
		String password =request.getParameter("password");

		Employee login = new Employee(username,password);

	    DaoClass obj=new DaoClass();
		try {
			 result=obj.checkLogin(login);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		if(result){
			 request.getSession().setAttribute("username",username);
			 request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else{
			 request.getSession().setAttribute("alert","Invalid Credentials");
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
