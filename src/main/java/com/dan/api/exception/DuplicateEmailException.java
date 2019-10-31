package com.dan.api.exception;

public class DuplicateEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException(String email) {
		super("Email address is already linked to an account: \"" + email + "\"");
	}
}
