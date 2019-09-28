package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dan.api.exception.DuplicateEmailException;
import com.dan.api.exception.DuplicateUsernameException;
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
		try {
			repo.save(user);
		} catch (DataIntegrityViolationException dive) {
			if(repo.existsByEmail(user.getEmail())) {
				throw new DuplicateEmailException(user.getEmail());
			} else if (repo.existsByUsername(user.getUsername())) {
				throw new DuplicateUsernameException(user.getUsername());
			}
		}
		return "{\"message\":\"User Successfully Created.\"}";
	}
	
	public User updateUser(long userId, User newUser) throws UserNotFoundException {
		//errors if newUser.email == oldUser.email
		if(repo.existsByEmail(newUser.getEmail())) {
			throw new DuplicateEmailException(newUser.getEmail());
		} else if (repo.existsByUsername(newUser.getUsername())) {
			throw new DuplicateUsernameException(newUser.getUsername());
		}
		
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
