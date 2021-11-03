package com.todo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.app.model.Todo;

/**
 * The Interface TodoRepository.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

	/**
	 * Find by status.
	 *
	 * @param status the status
	 * @return the list
	 */
	List<Todo> findByStatus(String status);

}
