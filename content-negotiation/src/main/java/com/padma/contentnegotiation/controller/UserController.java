package com.padma.contentnegotiation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padma.contentnegotiation.model.User;

@RestController
public class UserController {
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		users.add(new User("Padma","Naresh",new Date()));
		users.add(new User("Kevin","Miller",new Date()));
		users.add(new User("Scoot","Johnson",new Date()));
		return users;
	}

}
