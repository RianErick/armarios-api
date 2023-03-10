package com.rian.armarios.controller;

import com.rian.armarios.model.Armario;
import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import com.rian.armarios.service.SolicitacaoService.SolicitacaoArmarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armario/")
public class SolicitacaoArmarioController {

    @Autowired
    private SolicitacaoArmarioService solicitacaoArmarioService;

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;

    @PostMapping("/solicitacao")
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoArmario solicitacao(@RequestBody @Valid SolicitacaoArmario solicitacao){
       return solicitacaoArmarioService.solicitarArmario(solicitacao);

    }
    @GetMapping("/consultar")
    public List <SolicitacaoArmario> consulta (){
        return solicitacaoArmarioRepository.findAll();
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if (!solicitacaoArmarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
       solicitacaoArmarioService.deletar(id);
       return ResponseEntity.noContent().build();

    }

}
