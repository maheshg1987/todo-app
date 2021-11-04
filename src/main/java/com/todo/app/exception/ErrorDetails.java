package com.todo.app.exception;

/**
 * The Class ErrorDetails.
 */
public class ErrorDetails {
	
	/** The message. */
	private String message;
    
    /** The details. */
    private String details;
    
	/**
	 * Instantiates a new error details.
	 *
	 * @param message the message
	 * @param details the details
	 */
	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the new details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
   
	
    
}
