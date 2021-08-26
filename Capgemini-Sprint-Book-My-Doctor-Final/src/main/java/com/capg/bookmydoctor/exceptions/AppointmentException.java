package com.capg.bookmydoctor.exceptions;

public class AppointmentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public AppointmentException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message.toString().trim();
	}
}
