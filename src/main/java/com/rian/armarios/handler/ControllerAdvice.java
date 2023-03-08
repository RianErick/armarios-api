package com.rian.armarios.handler;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.handler.exception.ArmarioException;
import com.rian.armarios.handler.model.AlunoBolsistaEx;
import com.rian.armarios.handler.model.ArmarioEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AlunoBolsistaException.class)
    public AlunoBolsistaEx Ex(AlunoBolsistaException ex) {
        String mensagemErro = ex.getMessage();
        return new AlunoBolsistaEx(mensagemErro);
    }
    @ExceptionHandler(ArmarioException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ArmarioEx Ex (ArmarioException ex){
        String mensagemErro = ex.getMessage();
        return new ArmarioEx(mensagemErro);
    }

}
