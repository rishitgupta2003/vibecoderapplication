package dev.rishit.vibecoder.util;

import dev.rishit.vibecoder.exceptions.UnableToGenerateTokenException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
