package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.dto.ReviewMovieDTO;
import com.dan.api.persistance.dto.UserReviewsDTO;
import com.dan.api.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserReviewsDTO> getAll(){
		return service.getAll()
					.stream()
					.map(user -> new UserReviewsDTO(user))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long userId){
		try {
			User user = service.getUser(userId);
			return ResponseEntity.ok(new UserReviewsDTO(user));
		} catch (UserNotFoundException unfe) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(unfe.getMessage());
		}
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
