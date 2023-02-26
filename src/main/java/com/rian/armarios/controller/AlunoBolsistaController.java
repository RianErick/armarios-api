package com.rian.armarios.controller;


import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import com.rian.armarios.service.AlunoBolsistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoBolsistaController {

    @Autowired
    private AlunoBolsistaRepository alunoBolsistaRepository;
    @Autowired
    private AlunoBolsistaService alunoBolsistaService;

    @GetMapping("/busca")
    public List <AlunoBolsista> findAll() {
        return alunoBolsistaRepository.findAll();
    }
    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoBolsista create(@RequestBody AlunoBolsista aluno) {
        return alunoBolsistaService.salvar(aluno);
    }

}