package com.rian.armarios.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rian.armarios.model.Enums.StatusAluguel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @OneToOne
    @JoinColumn(name = "aluno_id")
    private AlunoBolsista aluno;

    @NotNull
    @OneToOne
    @JoinColumn(name = "armario_id")
    private Armario armario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_sl_armario")
    private LocalDate dataAluguelArmario;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_sl")
    private StatusAluguel statusAluguel;


}
