package dev.gerardcod.todos.commons.exceptions;

import dev.gerardcod.todos.commons.dtos.BadRequestField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class BadRequestBodyException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 8356337322767594285L;
    List<BadRequestField> errors;

    public BadRequestBodyException(String message, List<FieldError> errors) {
        super(message);
        this.errors = errors.stream().map(BadRequestField::valueOf).collect(Collectors.toList());
    }

}
