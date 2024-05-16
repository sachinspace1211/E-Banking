package com.ebanking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebanking.entities.Message;
import com.ebanking.entities.User;
import com.ebanking.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	// home
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home : E - Banking");
		return "home";
	}

	// about
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About : E - Banking");
		return "about";
	}

	@RequestMapping("/signin")
	public String customerLogin(Model model) {
		model.addAttribute("title", "Login : E - Banking");
		return "signin";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, BindingResult result1,
			 Model model,
			HttpSession session) {

		try {

			if (result1.hasErrors()) {
				model.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));


			this.userRepository.save(user);

			model.addAttribute("user", new User());

			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "signup";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went wrong !! " + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}

}
