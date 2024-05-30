package com.insurance.exception;

public class IdNotFoundException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdNotFoundException(String message) {
		super(message);
		// this.message = message;
	}

}
