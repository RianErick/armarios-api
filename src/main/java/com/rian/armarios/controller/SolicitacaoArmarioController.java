package com.rian.armarios.controller;

import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import com.rian.armarios.service.SolicitacaoService.SolicitacaoArmarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armario/")
@Tag(name = "Solicitações de Armários",description = "Controlador de Solicitações de Armários")
public class SolicitacaoArmarioController {

    @Autowired
    private SolicitacaoArmarioService solicitacaoArmarioService;

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;

    @PostMapping("/solicitacao")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Solicitar Armário", description = "Realiza a requisição de um Armário e retorna status code 201 se obter sucesso. " +
            "Caso contrário, retorna status code 400 e uma mensagem de erro. " +
            "OBS: O campo 'id' não deve ser informado, pois é gerado automaticamente pelo banco de dados.")
    public SolicitacaoArmario solicitacao(@RequestBody SolicitacaoArmario solicitacao){
       return solicitacaoArmarioService.solicitarArmario(solicitacao);

    }
    @GetMapping("/consultar")
    @Operation(summary = "Consultar Solicitações de Armários", description = "Realiza a consulta de todas as Solicitações de Armários e retorna uma lista de armários. " +
            "Caso contrário, retorna status code 404 e uma mensagem de erro. ")
    public List <SolicitacaoArmario> consulta (){
        return solicitacaoArmarioRepository.findAll();
    }
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Exclusão de Solicitação de Armário", description = "Realiza a exclusão de uma Solicitação de Armário." +
            "Basta passar o id da solicitação de armário e se obtiver sucesso é retornado um status code 204. " +
            "Caso contrário, retorna status code 404 e uma mensagem de erro. ")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if (!solicitacaoArmarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
       solicitacaoArmarioService.deletar(id);
       return ResponseEntity.noContent().build();

    }

}
