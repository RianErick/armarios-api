package com.rian.armarios.controller;


import com.rian.armarios.repository.AlunoBolsistaRepository;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class AlunoBolsistaController {

    @Autowired
    private AlunoBolsistaRepository alunoBolsistaRepository;


    
}
