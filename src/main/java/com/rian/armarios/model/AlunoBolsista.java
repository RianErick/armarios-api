package com.rian.armarios.model;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Entity
@Table(name = "aluno_bolsista")
@Schema(description = "Aluno Bolsista", name = "AlunoBolsista")
public class AlunoBolsista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id do aluno bolsista", name = "id", required = true,type = "Long")
    private Long id;

    @NotBlank
    @Schema(description = "Nome do aluno bolsista", name = "nome", required = true,type = "String")
    private String nome;

    @Email
    @NotBlank
    @Schema(description = "Email do aluno bolsista", name = "email", required = true,type = "String")
    private String email;

    @CPF
    @NotBlank
    @Schema(description = "CPF do aluno bolsista", name = "cpf", required = true,type = "String")
    private String cpf;

    @NotBlank
    @Schema(description = "Matrícula do aluno bolsista", name = "matricula", required = true,type = "String")
    private String matricula;

    @NotBlank
    @Schema(description = "Período do aluno bolsista", name = "periodo", required = true,type = "String")
    private String periodo;

    @NotBlank
    @Schema(description = "Curso do aluno bolsista", name = "curso", required = true,type = "String")
    private String curso;

}
