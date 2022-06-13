package com.sample.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class CartProductNotFoundException extends RuntimeException {
	 private String message;

	 public CartProductNotFoundException(String message) {
	 	super(message);
	 	this.message = message;
	 }
}