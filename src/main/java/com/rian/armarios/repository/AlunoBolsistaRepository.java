package com.rian.armarios.repository;

import com.rian.armarios.model.AlunoBolsista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoBolsistaRepository extends JpaRepository<AlunoBolsista,Long> {

    Optional <AlunoBolsista> findByEmail(String email);

    Optional <AlunoBolsista> findByMatricula(String matricula);




}