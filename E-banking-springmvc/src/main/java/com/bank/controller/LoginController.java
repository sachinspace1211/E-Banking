package com.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dao.LoginDao;
import com.bank.model.Employee;

@Controller
public class LoginController {

	@Autowired
	LoginDao loginDao;

	@RequestMapping(path = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {
		Employee employee = new Employee(username, password);
		if (loginDao.checkLogin(employee) != null) {
			session.setAttribute("username", employee.getUsername());
			session.setAttribute("password", employee.getPassword());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("alert", "Invalid Credentials");
			return "redirect:index.jsp";
		}
	}
	@RequestMapping("/dashboard")
	public String loadDashboard(Model m) {  
		return "dashboard";
	}
	@RequestMapping("/success")
	public String loadSuccess(Model m) {  
		return "success";
	}
	@RequestMapping("/logout")
	public String loadLogout(Model m) {  
		return "logout";
	}
}
