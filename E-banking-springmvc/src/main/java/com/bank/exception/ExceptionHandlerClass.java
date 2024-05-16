package com.bank.exception;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(value=SQLException.class)
	public String sqlExceptionHandler(Model model) {
		model.addAttribute("alert","Error due to sql Exception");
		return "redirect:errorBoard.jsp";
	}
	public String runtimeExceptionHandler(Model model) {
		model.addAttribute("alert","Error due to runtime Exception");
		return "redirect:errorBoard.jsp";
	}
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Model model) {
		model.addAttribute("alert","Error due to Exception");
		return "redirect:errorBoard.jsp";
	}
	
}
