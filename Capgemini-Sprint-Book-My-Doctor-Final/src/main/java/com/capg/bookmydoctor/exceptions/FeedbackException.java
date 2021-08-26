package com.capg.bookmydoctor.exceptions;

public class FeedbackException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public FeedbackException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message.toString().trim();
	}

}
