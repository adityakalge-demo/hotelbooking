package com.project.hotelBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBooking.Service.UserService;
import com.project.hotelBooking.model.User;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/create")
	@ApiResponses(value= {@ApiResponse (message = "User added Successfull", code =200),
	@ApiResponse(message = "Service not found ", code =404)})
	public User addUser(@RequestBody User user) {

		return userService.saveUser(user);
	}
	
	@GetMapping("/getUsers")
	@ApiResponses(value= {@ApiResponse (message = "User retrived Successfully", code =200),
			@ApiResponse(message = "Service not found ", code =404)})
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	
	
}
