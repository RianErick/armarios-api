package com.rian.armarios.handler.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class AlunoBolsistaException extends RuntimeException{
    public AlunoBolsistaException(HttpStatus status, String message) {
        super(message);

    }
}
