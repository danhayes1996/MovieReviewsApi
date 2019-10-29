package com.dan.api.service;

import java.util.List;

import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.User;

public interface UserService {
	
	public List<User> getAll();
	public User getUser(long userId) throws UserNotFoundException;
	public User authenticateUser(long userId, User user) throws UserNotFoundException;
	public String createUser(User user);
	public User updateUser(long userId, User newUser) throws UserNotFoundException;
	public User deleteUser(long userId) throws UserNotFoundException;

}
