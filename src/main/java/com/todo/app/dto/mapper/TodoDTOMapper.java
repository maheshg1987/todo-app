package com.todo.app.dto.mapper;

import java.text.ParseException;

import com.todo.app.dto.TodoDTO;
import com.todo.app.model.Todo;
import com.todo.app.util.DateFormatter;

/**
 * The Class TodoDTOMapper.
 */
public class TodoDTOMapper {

	private TodoDTOMapper() {

	}

	/** TodoDTOMapper on persists. 
	 * @throws ParseException */
	public static Todo todoOnPersists(TodoDTO dto) {
		Todo todo = new Todo();
		todo.setName(dto.getName().trim());
		todo.setDescription(dto.getDescription().trim());
		todo.setDueDate(DateFormatter.getFormattedDate(dto.getDueDate()));
		todo.setStatus(dto.getStatus().toLowerCase().trim());
		return todo;
	}

	/** TodoDTOMapper on update. */
	public static Todo todoOnUpdate(Todo todo, TodoDTO todoDTO) {
		todo.setName(todoDTO.getName().trim());
		todo.setDescription(todoDTO.getDescription().trim());
		todo.setDueDate(DateFormatter.getFormattedDate(todoDTO.getDueDate()));
		todo.setStatus(todoDTO.getStatus().toLowerCase().trim());
		return todo;

	}
}
