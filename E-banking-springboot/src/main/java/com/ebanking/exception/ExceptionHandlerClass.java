package com.ebanking.exception;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ebanking.entities.User;
import com.ebanking.service.UserService;

@ControllerAdvice
public class ExceptionHandlerClass extends RuntimeException implements ErrorController {


	@Autowired
	private UserService userService;
	
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ErrorMessage.class)
	public String dateFormatException(ErrorMessage e, Model model, HttpSession session) {
		User user = this.userService.getUser(e.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("e", e);
		return "normal/error_Board";
	}

}
