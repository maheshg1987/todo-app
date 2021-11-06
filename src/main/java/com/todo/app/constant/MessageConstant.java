package com.todo.app.constant;

public enum MessageConstant {
	
	TODO_NOT_FOUND("TODO not found for this id :"),
	TODO_DELETD("Todo Entry Successfully Deleted."),
	PENDING("Pending"),
	DONE("Done"),
	VALIDATE_STATUS("Status should be Done or Pending."),
	VALIDATE_NAME("Name is Required."),
	VALIDATE_DESCRIPTION("Description no longer than 500 charecters."),
	VALIDATE_STATUS_ON_CREATION("Status must be Pending on creation.");
	private String mesg;
	
	MessageConstant(String mesg) {
		this.mesg = mesg;
	}
	
	public String mesg() {
		return mesg;
	}

}
