package com.rian.armarios.controller;

import com.rian.armarios.model.Armario;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.service.ArmarioService.ArmarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Armario create( @RequestBody  Armario armario){
        return armarioService.cadastrarArmario(armario);
    }
    @GetMapping("/listar")
    public List <Armario> ListarArmario(){
        return armarioRepository.findAll();
    }


}
