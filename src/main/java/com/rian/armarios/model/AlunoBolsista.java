package com.rian.armarios.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class AlunoBolsista {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;
    private String email;
    private String matricula;
    private String periodo;
    private String curso;
    private LocalDate dataAluguelArmario;
    private Armario armario;

}
