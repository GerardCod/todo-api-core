package dev.gerardcod.todos.commons.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import dev.gerardcod.todos.commons.entities.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoDTO implements Serializable {
	private static final long serialVersionUID = -713659396380896733L;

	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotNull
	private Date dueDate;
	
	public Todo toTodo() {
		Todo todo = new Todo(this.title, this.description, this.dueDate);
		todo.setId(0L);
		return todo;
	}
}
