package com.dan.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.User;
import com.dan.api.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") long userId){
		return service.getUser(userId);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@RequestBody User user){
		return service.createUser(user);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public User updateUser(@PathVariable("id") long userId, @RequestBody User user){
		return service.updateUser(userId, user);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable("id") long userId){
		return service.deleteUser(userId);
	}
}
