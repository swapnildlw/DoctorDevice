package com.stackroute.UserService.service;
import com.stackroute.UserService.model.CreateUserRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.UserService.repository.UserRepository;
import com.stackroute.UserService.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRegistrationService implements IUserRegistrationService {


	@Autowired
	private UserRepository ur;


	@Override
	public User createUser(User user, CreateUserRequest createUserRequest) {
		if (createUserRequest != null) {
			user.setAddress(createUserRequest.getAddress());
			user.setGadgetList(createUserRequest.getGadgetList());
		}
		return ur.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User findById(UUID id) {
		return ur.findById(id).orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		return ur.findByEmail(email).orElse(null);
	}

	@Override
	public User save(User user) {
		return ur.save(user);
	}

	@Override
	public User updateUser(User user) {
		if (!ur.existsById(user.getId())) {
			throw new RuntimeException("User not found with ID: " + user.getId());
		}
		return ur.save(user);
	}

}
