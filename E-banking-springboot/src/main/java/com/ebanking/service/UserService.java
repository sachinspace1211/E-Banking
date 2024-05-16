package com.ebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebanking.entities.User;
import com.ebanking.repository.UserRepository;

@Component
@Service("userService")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String username) {
		return this.userRepository.getUserByUserName(username);	
	}

}
