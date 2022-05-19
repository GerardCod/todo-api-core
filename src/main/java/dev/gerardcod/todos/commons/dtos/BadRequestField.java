package dev.gerardcod.todos.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
public class BadRequestField {

    private String fieldName;
    private String rejectedValue;
    private String message;

    public static BadRequestField valueOf(FieldError fieldError) {
        return new BadRequestField(fieldError.getField(),
                "" + fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }
}
