package com.dan.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.api.exception.CreationException;
import com.dan.api.exception.DuplicateEmailException;
import com.dan.api.exception.DuplicateUsernameException;
import com.dan.api.exception.InvalidAccountDetailsException;
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
		return repo.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
	
	@Override
	public User authenticateUser(User user) throws InvalidAccountDetailsException {
		User foundUser = repo.authenticateUser(user.getUsername(), user.getEmail(), user.getPassword());
		if(foundUser != null) return foundUser;
		else throw new InvalidAccountDetailsException();
	}

	@Override
	@Transactional
	public User createUser(User user) {
		User result = null;
		try {
			result = repo.save(user);
		} catch (DataIntegrityViolationException dive) {
			if(repo.existsByEmail(user.getEmail())) {
				throw new DuplicateEmailException(user.getEmail());
			} else if (repo.existsByUsername(user.getUsername())) {
				throw new DuplicateUsernameException(user.getUsername());
			}
		}
		
		if(result == null) throw new CreationException("user");
		return result;
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
