package com.rian.armarios.controller;


import com.rian.armarios.model.Armario;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.service.ArmarioService.ArmarioService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/armario")
@Tag(name = "Controlador de Armários",
        description = "Controlador responsável por realizar o cadastro de um armário, " +
                "a exclusão de um armário e a consulta de todos os armários.")
public class ArmarioController {

    @Autowired
    private ArmarioRepository armarioRepository;

    @Autowired
    private ArmarioService armarioService;
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Armário cadastrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Armário não encontrado"),
    })
    @Operation(summary = "Cadastra um armário")
    public Armario create( @RequestBody @Valid Armario armario){
        return armarioService.cadastrarArmario(armario);
    }
    @GetMapping("/listar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Armários listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Armários não encontrados"),
    })
    @Operation(summary = "Lista todos os armários cadastrados")
    public List <Armario> listarArmarios(){
        return armarioRepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Armário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Armário não encontrado"),
    })
    @Operation(summary = "Deleta um armário")
    public ResponseEntity<Void> deletarArmario (@PathVariable Long id){
        if (!armarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
         armarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
