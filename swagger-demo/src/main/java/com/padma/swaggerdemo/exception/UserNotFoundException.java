package com.padma.swaggerdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8990905235407427388L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}

