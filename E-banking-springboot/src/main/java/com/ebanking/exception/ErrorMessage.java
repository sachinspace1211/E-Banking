package com.ebanking.exception;

public class ErrorMessage extends RuntimeException
{
	private static final long serialVersionUID = 6800056082766472376L;
	
	private final String heading;
	private final String message;
	private final String username;
	
	
	public ErrorMessage(String heading, String message, String username) {
		super();
		this.heading = heading;
		this.message = message;
		this.username = username;
	}



	@Override
	public String getMessage() {
		return message;
	}
	public String getHeading() {
		return heading;
	}
	public String getUsername() {
		return username;
	}
}
