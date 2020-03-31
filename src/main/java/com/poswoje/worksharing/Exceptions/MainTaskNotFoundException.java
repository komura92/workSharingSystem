package com.poswoje.worksharing.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MainTask doesn't exists!")
public class MainTaskNotFoundException extends RuntimeException {
    public MainTaskNotFoundException(Long mainTaskId) {
        super("Nie znaleziono zadania o id równym " + mainTaskId + ".");
    }
}
