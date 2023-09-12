package com.stackroute.UserService.service;

import com.stackroute.UserService.model.CreateUserRequest;
import com.stackroute.UserService.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserRegistrationService {
	User createUser(User user, CreateUserRequest createUserRequest);

	List<User> getAllUsers();
	User findById(UUID id);
	User findByEmail(String email);
	User save(User user);
	User updateUser(User user);
}
