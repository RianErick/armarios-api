package com.rian.armarios.service.AlunoService;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        boolean matriculaExistente = alunoBolsistaRepository.findByMatricula(aluno.getMatricula())
                .stream()
                .anyMatch(matricula -> ! matricula.equals(aluno));
                if (matriculaExistente){
                    throw new AlunoBolsistaException("Matricula Ja Existente");
                }
                return alunoBolsistaRepository.save(aluno);
    }

}
