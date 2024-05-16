package com.bank.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.dao.CustomerDao;
import com.bank.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao customerDao;

	@RequestMapping(path = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer, Model model) throws SQLException {
		customer.setCreditCard();
		if (customerDao.addCustomer(customer) > 0) {
			model.addAttribute("message", "Customer added successfully!");
			return "redirect:/success";
		} else {
			model.addAttribute("alert", "Customer addition unsuccessful!");
			return "errorBoard";
		}

	}

	@RequestMapping(path = "/modifyCustomer", method = RequestMethod.POST)
	public String modifyCustomer(@ModelAttribute Customer customer, Model model) {
		customer.setCreditCard();
		if (customerDao.modifyCustomer(customer) > 0) {
			model.addAttribute("message", "Customer modified successfully!");
			return "redirect:/success";
		} else {
			model.addAttribute("alert", "Customer modification unsuccessful!");
			return "redirect:/errorBoard";
		}
	}
	@RequestMapping("/addCustomer")
	public String loadAddCustomer(Model m) {  
		return "addCustomer";
	}
	@RequestMapping("/modifyCustomerJsp")
	public String loadModifyCustomerJsp(Model m) {  
		return "modifyCustomerJsp";
	}
	@RequestMapping("/viewTransaction")
	public String loadViewTransaction(Model m) {  
		return "viewTransaction";
	}
	@RequestMapping("/errorBoard")
	public String loadErrorBoard(Model m) {  
		return "errorBoard";
	}
}
