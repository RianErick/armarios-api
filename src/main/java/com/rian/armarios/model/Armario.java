package com.rian.armarios.model;


import jakarta.persistence.*;
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

    private String cor;

    @Column(name = "numero_chave")
    private String numeroChave;

    private String localizacao;

    @Enumerated(EnumType.STRING)
    private StatusArmario status;

    public Armario(){

    }

}
