package com.springsecuritygfg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException{

    private String message;
    private HttpStatus status;
    private LocalDateTime time;

    public EntityNotFoundException(){
        this.time = LocalDateTime.now();
    }

    public EntityNotFoundException(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }


}
