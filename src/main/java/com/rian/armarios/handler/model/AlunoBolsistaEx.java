package com.rian.armarios.handler.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AlunoBolsistaEx {

    @Getter
    private List <String> erros;
    public AlunoBolsistaEx(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
