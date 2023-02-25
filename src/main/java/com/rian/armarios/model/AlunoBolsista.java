package com.rian.armarios.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluno_bolsista")
public class AlunoBolsista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private String periodo;
    private String curso;

    @ManyToOne
    @JsonIgnore
    private Armario armario;
}
