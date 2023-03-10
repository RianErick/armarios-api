package com.rian.armarios.handler.model;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Hidden
public class AlunoBolsistaEx {

    @Getter
    private List <String> erros;
    public AlunoBolsistaEx(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
