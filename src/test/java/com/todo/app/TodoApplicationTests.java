package com.todo.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.app.controller.TodoController;
import com.todo.app.dao.TodoRepository;
import com.todo.app.dto.TodoDTO;
import com.todo.app.exception.CustomException;
import com.todo.app.model.Todo;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TodoController controller;

	@Test
	void checkStatusValidatioin() throws CustomException {
		TodoDTO todo = new TodoDTO();
		todo.setName("Mahesh");
		todo.setDescription("user add");
		todo.setDueDate("2021-08-25T06:35:57.000Z");
		todo.setStatus("Pending");
		controller.createTodo(todo);
		assertNotEquals("done", todo.getStatus());
	}

	@Test
	void checkNameValidatioin() throws CustomException {
		TodoDTO todo = new TodoDTO();
		todo.setName("Mahesh");
		todo.setDescription("user add");
		todo.setDueDate("2021-08-25T06:35:57.000Z");
		todo.setStatus("Pending");
		controller.createTodo(todo);
		assertNotNull(todo.getName());
	}

	@Test
	@Order(1)
	void createTodo() throws CustomException {
		Todo todo = new Todo();
		todo.setName("Mahesh");
		todo.setDescription("user add");
		todo.setDueDate("2021-08-25T06:35:57.000Z");
		todo.setStatus("Pending");
		todoRepository.save(todo);
		assertNotNull(todoRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	void readdAllTodo() {
		List list = todoRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	void updateTodo() {
		Todo todo = todoRepository.findById(1L).get();
		todo.setName("mahesh guruge");
		todoRepository.save(todo);
		assertNotNull("mahesh", todoRepository.findById(1L).get().getName());
	}

	@Test
	@Order(4)
	void deleteTodo() {
		todoRepository.deleteById(1L);
		assertThat(todoRepository.existsById(1L)).isFalse();
	}

}
