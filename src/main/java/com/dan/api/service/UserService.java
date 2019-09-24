package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getAll(){
		return repo.findAll();
	}

	public User getUser(long userId) throws UserNotFoundException {
		Optional<User> result = repo.findById(userId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException(userId);
	}
	
	public String createUser(User user) {
		User result = repo.save(user);
		if(result != null) {
			return "{\"message\":\"User Successfully Created.\"}";
		}
		return "{\"error\":true, \"message\":\"Failed to Create User.\"}";
	}
	
	public User updateUser(long userId, User newUser) throws UserNotFoundException {
		User oldUser = getUser(userId);
		if(newUser.getEmail() != null) oldUser.setEmail(newUser.getEmail());
		if(newUser.getPassword() != null) oldUser.setPassword(newUser.getPassword());
		if(newUser.getFirstName() != null) oldUser.setFirstName(newUser.getFirstName());
		if(newUser.getLastName() != null) oldUser.setLastName(newUser.getLastName());
		repo.save(oldUser);
		return oldUser;
	}
	
	public User deleteUser(long userId) throws UserNotFoundException {
		User user = getUser(userId);
		repo.delete(user);
		return user;
	}
	
}
