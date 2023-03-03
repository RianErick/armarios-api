package com.rian.armarios.handler;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.handler.model.AlunoBolsistaEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlunoBolsistaException.class)

    public AlunoBolsistaEx Ex(AlunoBolsistaException ex) {
        String mensagemErro = ex.getMessage();
        return new AlunoBolsistaEx(mensagemErro);
    }

}
