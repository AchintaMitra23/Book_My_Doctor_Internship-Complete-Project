package com.capg.bookmydoctor.exceptions;

public class PatientException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public PatientException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message.toString().trim();
	}
}
