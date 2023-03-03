package com.rian.armarios.controller;

import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.service.SolicitacaoArmarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/armario/")
public class SolicitacaoArmarioController {

    @Autowired
    private SolicitacaoArmarioService solicitacaoArmarioService;
    @PostMapping("/solicitacao")
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoArmario solicitacao(@RequestBody SolicitacaoArmario solicitacao){
        return solicitacaoArmarioService.solicitarArmario(solicitacao);
    }
}
