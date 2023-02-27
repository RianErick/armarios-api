package com.rian.armarios.handler.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class AlunoBolsistaException extends RuntimeException{
    public AlunoBolsistaException( String message) {
        super(message);

    }
}
