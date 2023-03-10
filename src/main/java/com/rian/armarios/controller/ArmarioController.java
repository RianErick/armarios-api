package com.rian.armarios.controller;


import com.rian.armarios.handler.exception.ArmarioException;
import com.rian.armarios.model.Armario;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.service.ArmarioService.ArmarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/armario")
public class ArmarioController {

    @Autowired
    private ArmarioRepository armarioRepository;

    @Autowired
    private ArmarioService armarioService;
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Armario create( @RequestBody @Valid Armario armario){
        return armarioService.cadastrarArmario(armario);
    }
    @GetMapping("/listar")
    public List <Armario> listarArmarios(){
        return armarioRepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarArmario (@PathVariable Long id){
        if (!armarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
         armarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
