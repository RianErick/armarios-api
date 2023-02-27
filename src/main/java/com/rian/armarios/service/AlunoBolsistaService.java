package com.rian.armarios.service;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import org.flywaydb.core.internal.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AlunoBolsistaService {

    @Autowired
    private AlunoBolsistaRepository alunoBolsistaRepository;

    @Transactional
    public AlunoBolsista salvar(AlunoBolsista aluno) {

        boolean emailExistente = alunoBolsistaRepository.findByEmail(aluno.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(aluno));

        if (emailExistente) {
            throw new AlunoBolsistaException("Email Ja Cadastrado");
        }
        return alunoBolsistaRepository.save(aluno);
    }

}
