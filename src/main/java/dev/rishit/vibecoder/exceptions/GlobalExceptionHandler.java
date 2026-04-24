package dev.rishit.vibecoder.exceptions;

import dev.rishit.vibecoder.util.ResponseBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    final ResponseBuilder responseBuilder;

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateException(DataIntegrityViolationException ex){
        String message = "Email already exists";
        if (ex.getMessage() != null && ex.getMessage().contains("email")) {
            return responseBuilder.buildConflictResponse(message);
        }
        return responseBuilder.buildConflictResponse("Data integrity violation");
    }

    @ExceptionHandler(UnableToGenerateTokenException.class)
    public ResponseEntity<Map<String, Object>> handleUnableToGenerateTokenException(UnableToGenerateTokenException ex){
        return responseBuilder.buildConflictResponse(ex.getMessage());
    }

    @ExceptionHandler(
            {
                    UserNotFoundException.class, ProjectNotFoundException.class
            }
    )
    public ResponseEntity<Map<String, Object>> handleNotFound(RuntimeException ex){
        return responseBuilder.buildNotFoundResponse(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return responseBuilder.buildBadRequestResponse(errors);
    }
}
