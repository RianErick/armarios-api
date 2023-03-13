package com.rian.armarios.controller;


import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import com.rian.armarios.service.AlunoService.AlunoBolsistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@Tag(name ="Controlador de Alunos Bolsistas",
        description = "Controlador responsável por realizar o cadastro, a consulta, a edição e a exclusão de alunos bolsistas.")
public class AlunoBolsistaController {

    @Autowired
    private AlunoBolsistaRepository alunoBolsistaRepository;
    @Autowired
    private AlunoBolsistaService alunoBolsistaService;

    @GetMapping("/busca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Alunos não encontrados"),
    })
    @Operation(summary = "Busca todos os alunos bolsistas cadastrados")
    public List <AlunoBolsista> findAll() {
        return alunoBolsistaRepository.findAll();
    }
    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
    })
    @Operation(summary = "Cadastra um aluno bolsista")
    public AlunoBolsista create(@RequestBody @Valid  AlunoBolsista aluno) {
        return alunoBolsistaService.salvar(aluno);
    }
    @GetMapping("/buscar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
    })
    @Operation(summary = "Busca um aluno bolsista pelo id")
    public ResponseEntity <AlunoBolsista> findById(@PathVariable Long id){
        return alunoBolsistaRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AlunoBolsistaException("Id do Aluno nao existe na base de dados"));
    }
    @PutMapping("/editar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno editado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
    })
    @Operation(summary = "Edita um aluno bolsista")
    public ResponseEntity <AlunoBolsista> edit(@PathVariable Long id, @RequestBody @Valid AlunoBolsista alunoBolsista){
        if(!alunoBolsistaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alunoBolsista.setId(id);
        alunoBolsistaService.salvar(alunoBolsista);
        return ResponseEntity.ok(alunoBolsista);
    }
    @DeleteMapping("/deletar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
    })
    @Operation(summary = "Deleta um aluno bolsista")
    public ResponseEntity<Void> deletar(@PathVariable Long id ){
        if(!alunoBolsistaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alunoBolsistaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/buscar/matricula/{matricula}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
    })
    @Operation(summary = "Busca um aluno bolsista pela matricula")
    public AlunoBolsista buscarPelaMatricula(@PathVariable String matricula){
        return alunoBolsistaRepository.findByMatricula(matricula)
                .orElseThrow(()-> new AlunoBolsistaException("Matricula nao encontrada"));
    }

}