package com.example.ppmtools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.annotation.RequestScope;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException{
    public ProjectIDException(String message) {
        super(message);
    }
}
