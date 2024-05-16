package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.dao.AccountDao;
import com.bank.model.Account;

@Controller
public class AccountController {
	@Autowired
	AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@RequestMapping(path = "/addAccount", method = RequestMethod.POST)
	public String addAccount(@ModelAttribute Account account, Model model) {
		if (accountDao.addAccount(account) > 0) {
			model.addAttribute("message", "Account added successfully!");
			return "redirect:/success";
		} else {
			model.addAttribute("alert", "Account addition unsuccessful!");
			return "redirect:/errorBoard";
		}
	}
	@RequestMapping("/addAccount")
	public String loadAddAccount(Model m) {  
		return "addAccount";
	}
}
