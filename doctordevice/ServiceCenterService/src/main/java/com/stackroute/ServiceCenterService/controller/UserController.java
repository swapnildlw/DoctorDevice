package com.stackroute.ServiceCenterService.controller;

import com.stackroute.ServiceCenterService.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.stackroute.ServiceCenterService.model.User;

import java.util.UUID;


@RestController
public class UserController {

	@Autowired
	ServiceCenterService us;
	
	@PostMapping("/ScRegistration")
    User createUser(@RequestBody User user) {
		user.setId(UUID.randomUUID().toString());
		return us.saveUser(user);
    }
}
