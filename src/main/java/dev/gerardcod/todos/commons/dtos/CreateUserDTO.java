package dev.gerardcod.todos.commons.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String firstName;
	
	private String middleName;
	
	@NotBlank
	private String lastName;
	
}
