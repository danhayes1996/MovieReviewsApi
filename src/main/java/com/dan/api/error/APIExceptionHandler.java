package com.dan.api.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dan.api.exception.DuplicateEmailException;
import com.dan.api.exception.DuplicateUsernameException;
import com.dan.api.exception.InvalidAccountDetailsException;
import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.exception.ReviewNotFoundException;
import com.dan.api.exception.UserNotFoundException;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({UserNotFoundException.class, MovieNotFoundException.class, ReviewNotFoundException.class})
	public void notFoundException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler({InvalidAccountDetailsException.class})
	public void unauthorizedException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.UNAUTHORIZED.value());
	}
	
	@ExceptionHandler({DuplicateUsernameException.class, DuplicateEmailException.class})
	public void duplicateException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
