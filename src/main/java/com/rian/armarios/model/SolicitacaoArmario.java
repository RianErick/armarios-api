package com.rian.armarios.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rian.armarios.model.Enums.StatusAluguel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table( name = "solicitacao_armario")
@Schema(description = "Solicitação de armário", name = "SolicitacaoArmario")
public class SolicitacaoArmario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id da solicitação de armário", name = "id", required = true,type = "Long")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "aluno_id")
    @Schema(description = "Aluno que solicitou o armário", name = "aluno", required = true,type = "AlunoBolsista")
    private AlunoBolsista aluno;

    @NotNull
    @OneToOne
    @JoinColumn(name = "armario_id")
    @Schema(description = "Armário solicitado", name = "armario", required = true,type = "Armario")
    private Armario armario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_sl_armario")
    @Schema(description = "Data da solicitação do armário", name = "dataAluguelArmario", required = true,type = "LocalDate")
    private LocalDate dataAluguelArmario;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_sl")
    @Schema(description = "Status da solicitação", name = "statusAluguel", required = true,type = "StatusAluguel")
    private StatusAluguel statusAluguel;


}
