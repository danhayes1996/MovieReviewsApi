package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.dto.ReviewMovieDTO;
import com.dan.api.persistance.dto.UserReviewsDTO;
import com.dan.api.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserReviewsDTO> getAll(){
		return service.getAll()
					.stream()
					.map(user -> new UserReviewsDTO(user))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public UserReviewsDTO getUser(@PathVariable("id") long userId){
		return new UserReviewsDTO(service.getUser(userId));
	}
	
	@RequestMapping(value = "/getReviews/{id}", method = RequestMethod.GET)
	public List<ReviewMovieDTO> getUserReviews(@PathVariable("id") long userId){
		return service.getUser(userId).getReviews()
						.stream()
						.map(review -> new ReviewMovieDTO(review))
						.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@RequestBody User user){
		return service.createUser(user);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public UserReviewsDTO updateUser(@PathVariable("id") long userId, @RequestBody User user){
		return new UserReviewsDTO(service.updateUser(userId, user));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public UserReviewsDTO deleteUser(@PathVariable("id") long userId){
		return new UserReviewsDTO(service.deleteUser(userId));
	}
}
