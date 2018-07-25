package com.jobs.microservice.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmploiNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmploiNotFoundException(String message) {
        super(message);
    }
}