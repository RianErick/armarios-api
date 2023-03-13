package com.rian.armarios.controller;

import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import com.rian.armarios.service.SolicitacaoService.SolicitacaoArmarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armario/")
@Tag(name = "Controlador de Solicitações de Armário",
        description = "Controlador responsável por realizar a solicitação " +
        "de um armário, a exclusão de uma solicitação de um armário e a consulta de todas as solicitações de armários.")
public class SolicitacaoArmarioController {

    @Autowired
    private SolicitacaoArmarioService solicitacaoArmarioService;

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;

    @PostMapping("/solicitacao")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Solicitação realizada com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Solicitação não encontrada"),
    })
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
