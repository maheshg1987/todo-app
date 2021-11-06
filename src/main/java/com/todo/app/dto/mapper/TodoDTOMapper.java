package com.todo.app.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
		todo.setName(dto.getName());
		todo.setDescription(dto.getDescription());
		todo.setDueDate(DateFormatter.getFormattedDate(dto.getDueDate()));
		todo.setStatus(dto.getStatus().toLowerCase());
		return todo;
	}

	/** TodoDTOMapper on update. */
	public static Todo todoOnUpdate(Todo todo, TodoDTO todoDTO) {
		todo.setName(todoDTO.getName());
		todo.setDescription(todoDTO.getDescription());
		todo.setDueDate(DateFormatter.getFormattedDate(todoDTO.getDueDate()));
		todo.setStatus(todoDTO.getStatus().toLowerCase());
		return todo;

	}
}
