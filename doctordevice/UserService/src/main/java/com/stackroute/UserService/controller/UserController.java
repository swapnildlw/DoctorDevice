package com.stackroute.UserService.controller;

import com.stackroute.UserService.model.CreateUserRequest;
import com.stackroute.UserService.service.UserMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.UserService.model.User;
import com.stackroute.UserService.service.UserRegistrationService;

import java.util.*;

@RestController
@RequestMapping("/api/messages")
public class UserController {
	@Autowired
	private UserMessageSender userMessageSender;
	@Autowired
	private UserRegistrationService us;


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable UUID id) {
		User user = us.findById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = us.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		User user = us.findByEmail(email);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@PostMapping("/createUser")
	public Map<String, Object> createUser(@RequestBody CreateUserRequest createUserRequest) {
		User user = new User();

		user.setId(UUID.randomUUID());
		user.setUserName(createUserRequest.getUserName());
		user.setEmail(createUserRequest.getEmail());
		user.setPassword(createUserRequest.getPassword());
		user.setAddress(createUserRequest.getAddress());
		user.setGadgetList(createUserRequest.getGadgetList());

		us.save(user);

		Map<String, Object> response = new HashMap<>();
		response.put("id", user.getId());
		response.put("email", user.getEmail());
		response.put("username", user.getUserName());

		return response;
	}
	@PutMapping("/updateUser/{id}")

	public User updateUser(@PathVariable UUID id, @RequestBody User userUpdates) {
		User existingUser = us.findById(id);

		if (userUpdates.getUserName() != null) {
			existingUser.setUserName(userUpdates.getUserName());
		}
		if (userUpdates.getEmail() != null) {
			existingUser.setEmail(userUpdates.getEmail());
		}
		if (userUpdates.getAddress() != null) {
			existingUser.setAddress(userUpdates.getAddress());
		}
		if (userUpdates.getGadgetList() != null) {
			existingUser.setGadgetList(userUpdates.getGadgetList());
		}
		return us.save(existingUser);
	}
}



