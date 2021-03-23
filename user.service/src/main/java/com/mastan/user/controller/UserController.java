package com.mastan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastan.user.entity.User;
import com.mastan.user.service.UserService;

import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {		
		log.info("inside user controller and save user");
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseTemplateVO getuserWithDepartment(@PathVariable int userId) {
		
		return userService.getUserWithDepartment(userId);
	}

}
