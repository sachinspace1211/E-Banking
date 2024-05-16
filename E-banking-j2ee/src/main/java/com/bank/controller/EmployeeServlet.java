package com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.DaoClass;
import com.bank.model.Account;
import com.bank.model.Customer;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	DaoClass obj=new DaoClass();
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		System.out.println(action);
		switch(action)
		{
		  case "add":
			addCustomer(request,response);
		    break;
		  case "update":
			 update(request,response);
			 break;
		  case "addAccount":
		     addAccount(request,response);
		     break;
		}
	}
	protected void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();

		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setAge(Integer.parseInt(request.getParameter("age")));
		customer.setGender(request.getParameter("gender"));
		customer.setCity(request.getParameter("city"));
		customer.setOccupation(request.getParameter("occupation"));
		customer.setEmail(request.getParameter("email"));
		customer.setContact(request.getParameter("contact"));
		customer.setAnnualIncome(Long.parseLong(request.getParameter("annualIncome")));
		customer.setAccountType(request.getParameter("accountType"));
		customer.setCreditCard();
		int i=obj.addCustomer(customer);
		if(i>0){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
	    }
		else{
			RequestDispatcher rd=request.getRequestDispatcher("errorBoard.jsp");
			rd.forward(request, response);
	    }
   }
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();

		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setAge(Integer.parseInt(request.getParameter("age")));
		customer.setGender(request.getParameter("gender"));
		customer.setCity(request.getParameter("city"));
		customer.setOccupation(request.getParameter("occupation"));
		customer.setEmail(request.getParameter("email"));
		customer.setContact(request.getParameter("contact"));
		customer.setAnnualIncome(Long.parseLong(request.getParameter("annualIncome")));
		customer.setCreditCard();

		int i=obj.update(customer,Integer.parseInt(request.getParameter("id")));
		if(i>0){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
	    }
		else{
			RequestDispatcher rd=request.getRequestDispatcher("errorBoard.jsp");
			rd.forward(request, response);
	    }
	}
	protected void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = new Account(Integer.parseInt(request.getParameter("id")),request.getParameter("accountType"));
		int i=obj.addAccount(account);
		if(i>0){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
	    }
		else{
			RequestDispatcher rd=request.getRequestDispatcher("errorBoard.jsp");
			rd.forward(request, response);
	    }
   }
}
