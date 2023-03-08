package com.rian.armarios.handler.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ArmarioEx {
    @Getter
    private List<String> erros;
    public ArmarioEx(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
