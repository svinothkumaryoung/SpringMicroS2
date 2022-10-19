package com.traningon.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traningon.userservice.entity.User;
import com.traningon.userservice.service.UserService;

import VO.ResponseTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("insertUser")
	public User saveUser(@RequestBody User user)
	{

		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable ("id") Long userId)
	{
		return userService.getUserWithDepartment(userId);
	}
	

}
