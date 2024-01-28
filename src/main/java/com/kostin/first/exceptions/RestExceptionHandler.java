package com.kostin.first.exceptions;

import com.kostin.first.dtos.ErrorDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(WebRequest request, EntityNotFoundException exception){
        log.error(request.getDescription(false) + " Exception: " + exception.getMessage());
        return toError(HttpStatus.NOT_FOUND, new ErrorDto(exception.getMessage()));
    }
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorDto> handleExistsException(WebRequest request, EntityExistsException exception){
        log.error(request.getDescription(false) + " Exception: " + exception.getMessage());
        return toError(HttpStatus.BAD_REQUEST, new ErrorDto(exception.getMessage()));
    }
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorDto> handleValidationException(WebRequest request, Exception e) {
        String message = e instanceof MethodArgumentNotValidException me ? extractValidationError(me) : e.getMessage();
        log.error(message);
        return toError(HttpStatus.BAD_REQUEST, new ErrorDto(message));
    }
    private ResponseEntity<ErrorDto> toError(HttpStatus httpStatus, ErrorDto errorDto){
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON).body(errorDto);
    }
    private String extractValidationError(MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors().stream().map(error -> {
            String name = error.getObjectName();
            if (error instanceof FieldError fieldError) {
                name = fieldError.getField();
            }
            return "'" + name + "': " + error.getDefaultMessage();
        }).collect(Collectors.joining("; "));
    }

}
