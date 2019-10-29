package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.api.exception.DuplicateEmailException;
import com.dan.api.exception.DuplicateUsernameException;
import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.repository.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAll(){
		return repo.findAll();
	}

	@Override
	public User getUser(long userId) throws UserNotFoundException {
		Optional<User> result = repo.findById(userId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException(userId);
	}
	
	@Override
	public User authenticateUser(long userId, User userDetails) throws UserNotFoundException {
		//TODO: check (user.email || user.username) && user.password is correct
		Optional<User> result = repo.findById(userId);
		return null;
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
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

	@Override
	@Transactional
	public User deleteUser(long userId) throws UserNotFoundException {
		User user = getUser(userId);
		repo.delete(user);
		return user;
	}
}
