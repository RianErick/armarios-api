package com.rian.armarios.model;


import com.rian.armarios.model.Enums.StatusArmario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "armario")
@Schema(description = "Armário", name = "Armario")
public class Armario  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Schema(description = "Id do armário", name = "id", required = true,type = "Long")
    private Long id;

    @NotBlank
    @Schema(description = "Cor do armário", name = "cor", required = true,type = "String")
    private String cor;

    @NotBlank
    @Column(name = "numero_chave")
    @Schema(description = "Número da chave do armário", name = "numeroChave", required = true,type = "String")
    private String numeroChave;

    @NotBlank
    @Schema(description = "Localização do armário", name = "localizacao", required = true,type = "String")
    private String localizacao;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do armário", name = "status", required = true,type = "StatusArmario")
    private StatusArmario status = StatusArmario.DISPONIVEL;



}
