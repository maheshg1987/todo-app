package com.todo.app.constant;

public enum MessageConstant {
	
	TODO_NOT_FOUND("TODO not found for this id :"),
	TODO_DELETD("Todo Entry Successfully Deleted.");
	
	private String mesg;
	
	MessageConstant(String mesg) {
		this.mesg = mesg;
	}
	
	public String mesg() {
		return mesg;
	}

}
