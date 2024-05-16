package com.ebanking.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.entities.User;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void getUserTest() {
		User returnedUser = this.userService.getUser("sachin");
		assertNotEquals(null, returnedUser);
	}

}
