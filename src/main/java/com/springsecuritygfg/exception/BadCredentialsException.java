package com.springsecuritygfg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadCredentialsException extends RuntimeException{

    private String message;
    private HttpStatus status;
    private LocalDateTime time;

    public BadCredentialsException(){
        this.time = LocalDateTime.now();
    }

    public BadCredentialsException(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }

}
