package com.rian.armarios.handler.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Hidden
public class ArmarioEx {
    @Getter
    private List<String> erros;
    public ArmarioEx(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
