package com.rian.armarios.handler;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.handler.model.AlunoBolsistaEx;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    public AlunoBolsistaEx Ex (AlunoBolsistaException ex){
        String mensagemErro = ex.getMessage();

        return new AlunoBolsistaEx(mensagemErro);
    }

}
