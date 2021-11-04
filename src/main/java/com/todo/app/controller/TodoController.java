package com.todo.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.constant.MessageConstant;
import com.todo.app.dao.TodoRepository;
import com.todo.app.dto.TodoDTO;
import com.todo.app.dto.mapper.TodoDTOMapper;
import com.todo.app.exception.ResourceNotFoundException;
import com.todo.app.model.Todo;

/**
 * The Class TodoController.
 */
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	TodoRepository todoRepository;

	/**
	 * Creates the todoEntity.
	 *
	 * @param todoDTO the todo's DTO
	 * @return the response entity
	 */
	@PostMapping("/todo")
	public ResponseEntity<Todo> createTodo(@RequestBody TodoDTO todoDTO) {
		try {
			Todo todo = todoRepository.save(TodoDTOMapper.todoOnPersists(todoDTO));
			return new ResponseEntity<>(todo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the all todoEntity.
	 *
	 * @param status the status
	 * @return the all todoEntity
	 */
	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> getAllTodo(@RequestParam(required = false) String status) {
		try {
			List<Todo> todo = new ArrayList<>();

			if (StringUtils.isBlank(status)) {
				todoRepository.findAll().forEach(todo::add);
			} else {
				todoRepository.findByStatus(status).forEach(todo::add);
			}
			if (todo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the todoEntity by id.
	 *
	 * @param id the id
	 * @return the todoEntity by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") long id) throws ResourceNotFoundException {
		Todo todoData = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstant.TODO_NOT_FOUND.mesg() + id));
		return ResponseEntity.ok().body(todoData);
	}

	/**
	 * Update todoEntity.
	 *
	 * @param id the id
	 * @param todoDTO the todo's DTO
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody TodoDTO todoDTO)
			throws ResourceNotFoundException {
		Todo todoData = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstant.TODO_NOT_FOUND.mesg() + id));
		return new ResponseEntity<>(todoRepository.save(TodoDTOMapper.todoOnUpdate(todoData, todoDTO)), HttpStatus.OK);

	}

	/**
	 * Delete todoEntity.
	 *
	 * @param id the id
	 * @return the map
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@DeleteMapping("/todo/{id}")
	public Map<String, Boolean> deleteTodo(@PathVariable("id") long id) throws ResourceNotFoundException {
		Todo todoData = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstant.TODO_NOT_FOUND.mesg() + id));
		todoRepository.delete(todoData);
		Map<String, Boolean> response = new HashMap<>();
		response.put(MessageConstant.TODO_DELETD.mesg(), Boolean.TRUE);
		return response;
	}
}
