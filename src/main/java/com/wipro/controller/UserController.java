package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.User;
import com.wipro.payload.RequestPayload;
import com.wipro.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(name="id") Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/person")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@PutMapping("/user")
	public User updateUser(@RequestBody RequestPayload requestPayload) {
		return userService.updateUser(requestPayload);
	}
	
}
