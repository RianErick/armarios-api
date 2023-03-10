package com.rian.armarios.service.SolicitacaoService;

import com.rian.armarios.model.Enums.StatusAluguel;
import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class SolicitacaoArmarioService {

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;


    @Transactional
    public SolicitacaoArmario solicitarArmario (SolicitacaoArmario solicitacaoArmario){

        solicitacaoArmario.setDataAluguelArmario(LocalDate.now());
        solicitacaoArmario.setStatusAluguel(StatusAluguel.CONFIRMADO);
        return solicitacaoArmarioRepository.save(solicitacaoArmario);
    }
    @Transactional
    public void deletar (Long clienteId) {
       solicitacaoArmarioRepository.deleteById(clienteId);
    }

}
