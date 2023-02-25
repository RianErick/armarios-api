package com.rian.armarios.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

public class SolicitacaoArmario {

    @OneToOne
    private AlunoBolsista aluno;

    private Armario armario;

    private LocalDate dataAluguelArmario;

    @Enumerated(EnumType.STRING)
    private StatusArmario statusArmario;
}
