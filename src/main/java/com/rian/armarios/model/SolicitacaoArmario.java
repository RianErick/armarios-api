package com.rian.armarios.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table( name = "solicitacao_armario")
public class SolicitacaoArmario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "aluno_id")
    private AlunoBolsista aluno;

    @JoinColumn(name = "armario_id")
    private Armario armario;

    @Column(name = "data_sl_armario")
    private LocalDate dataAluguelArmario;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_sl")
    private StatusAluguel statusAluguel;
}
