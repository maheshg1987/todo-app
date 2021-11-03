package com.todo.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.todo.app.dao.TodoRepository;
import com.todo.app.model.Todo;

/**
 * The Class TodoController.
 */
@RestController
@RequestMapping("/api")
public class TodoController {

	/** The todo repository. */
	@Autowired
	TodoRepository todoRepository;

	/**
	 * Creates the todo.
	 *
	 * @param todo the todo
	 * @return the response entity
	 */
	@PostMapping("/todo")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		try {
			Todo _todo = todoRepository
					.save(new Todo(todo.getName(), todo.getDescription(), todo.getDueDate(), todo.getStatus()));
			return new ResponseEntity<>(_todo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the all todo.
	 *
	 * @param status the status
	 * @return the all todo
	 */
	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> getAllTodo(@RequestParam(required = false) String status) {
		try {
			List<Todo> todo = new ArrayList<Todo>();

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
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the todo by id.
	 *
	 * @param id the id
	 * @return the todo by id
	 */
	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") long id) {
		Optional<Todo> todoData = todoRepository.findById(id);

		if (todoData.isPresent()) {
			return new ResponseEntity<>(todoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update todo.
	 *
	 * @param id the id
	 * @param todo the todo
	 * @return the response entity
	 */
	@PutMapping("/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo) {
		Optional<Todo> todoData = todoRepository.findById(id);

		if (todoData.isPresent()) {
			Todo _todo = todoData.get();
			_todo.setName(todo.getName());
			_todo.setDescription(todo.getDescription());
			_todo.setDueDate(todo.getDueDate());
			_todo.setStatus(todo.getStatus());
			return new ResponseEntity<>(todoRepository.save(_todo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete todo.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") long id) {
		try {
			todoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
