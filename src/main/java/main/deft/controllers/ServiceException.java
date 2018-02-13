package main.deft.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }
}
