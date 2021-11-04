package com.todo.app.exception;

import java.io.Serializable;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends Exception implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8201016414290340752L;

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param message the message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
