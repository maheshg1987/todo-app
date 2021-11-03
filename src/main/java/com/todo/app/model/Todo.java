package com.todo.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Todo.
 */
@Entity
@Table(name = "todo")
public class Todo {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The description. */
	@Column(name = "description")
	private String description;

	/** The due date. */
	@Column(name = "dueDate")
	private LocalDate dueDate;

	/** The status. */
	@Column(name = "status")
	private String status;

	/**
	 * Instantiates a new todo.
	 */
	public Todo() {

	}

	/**
	 * Instantiates a new todo.
	 *
	 * @param name        the name
	 * @param description the description
	 * @param dueDate     the due date
	 * @param status      the status
	 */
	public Todo(String name, String description, LocalDate dueDate, String status) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
