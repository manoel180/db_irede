package br.com.boardtec.controllers;


import br.org.iredeam.data.dtos.ErrorDto;
import br.org.iredeam.data.dtos.FieldErrorDto;
import br.org.iredeam.data.exceptions.BusinessException;
import br.org.iredeam.data.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ErrorDto> exceptions(ResourceNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto(new Date(), exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<ErrorDto> exceptions(BusinessException exception) {
        ErrorDto errorDto = new ErrorDto(new Date(), exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
             Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        FieldErrorDto fieldErrorDto = new FieldErrorDto(new Date(), "Bad request", errors);
        return new ResponseEntity<>(fieldErrorDto, HttpStatus.BAD_REQUEST);
    }
}