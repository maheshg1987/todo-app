package com.todo.app.dto.mapper;

import com.todo.app.dto.TodoDTO;
import com.todo.app.model.Todo;

/**
 * The Class TodoDTOMapper.
 */
public class TodoDTOMapper {

	private TodoDTOMapper() {

	}

	/** TodoDTOMapper on persists. */
	public static Todo todoOnPersists(TodoDTO dto) {
		Todo todo = new Todo();
		todo.setName(dto.getName());
		todo.setDescription(dto.getDescription());
		todo.setDueDate(dto.getDueDate());
		todo.setStatus(dto.getStatus().toLowerCase());
		return todo;
	}

	/** TodoDTOMapper on update. */
	public static Todo todoOnUpdate(Todo todo, TodoDTO todoDTO) {
		todo.setName(todoDTO.getName());
		todo.setDescription(todoDTO.getDescription());
		todo.setDueDate(todoDTO.getDueDate());
		todo.setStatus(todoDTO.getStatus().toLowerCase());
		return todo;

	}
}
