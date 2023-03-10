package com.rian.armarios.model;


import com.rian.armarios.model.Enums.StatusArmario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "armario")
public class Armario  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    private String cor;

    @NotBlank
    @Column(name = "numero_chave")
    private String numeroChave;

    @NotBlank
    private String localizacao;

    @Enumerated(EnumType.STRING)
    private StatusArmario status = StatusArmario.DISPONIVEL;



}
