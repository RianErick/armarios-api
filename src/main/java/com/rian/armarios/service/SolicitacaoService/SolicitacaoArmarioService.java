package com.rian.armarios.service.SolicitacaoService;
import com.rian.armarios.model.Armario;
import com.rian.armarios.model.Enums.StatusArmario;
import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.model.Enums.StatusAluguel;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Service
public class SolicitacaoArmarioService {

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;

    @Autowired
    private ArmarioRepository armarioRepository;


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
