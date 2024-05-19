package com.springsecuritygfg.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> notFoundException(EntityNotFoundException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getStatus(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(errorDetails, errorDetails.getStatus());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestExceptionMethod(BadRequestException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getStatus(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(errorDetails, errorDetails.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidExceptionMethod(MethodArgumentNotValidException ex){
        // Map<Object, String> errorMap = new HashMap<>();

        // ex.getBindingResult().getFieldErrors().forEach(error ->{
        //     errorMap.put(error.getField(), error.getDefaultMessage());
        // });

        ErrorDetails errorResponse = null;
        ObjectError errorMessage = ex.getBindingResult().getFieldError();
        List<String> errorMessageList = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            errorMessageList.add(error.getDefaultMessage());
        }

        if(errorMessageList.size() > 1){
            errorResponse = new ErrorDetails(HttpStatus.BAD_REQUEST, errorMessageList.toString(),  LocalDateTime.now());
        }
        else if(errorMessageList != null){
            errorResponse = new ErrorDetails(HttpStatus.BAD_REQUEST, errorMessage.getDefaultMessage(), LocalDateTime.now());
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
