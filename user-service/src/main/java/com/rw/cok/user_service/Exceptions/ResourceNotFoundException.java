package com.rw.cok.user_service.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private String errorCode;
    private LocalDateTime timeStamp;
    public ResourceNotFoundException(String message,String errorCode){
        super(message);
        this.errorCode = errorCode;
        this.timeStamp = LocalDateTime.now();
    }
}
