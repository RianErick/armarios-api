package com.rian.armarios.service.SolicitacaoService;
import com.rian.armarios.model.Armario;
import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.model.StatusAluguel;
import com.rian.armarios.model.StatusArmario;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
public class SolicitacaoArmarioService {

    @Autowired
    private SolicitacaoArmarioRepository solicitacaoArmarioRepository;

       Armario armario = new Armario();
    @Transactional
    public SolicitacaoArmario solicitarArmario (SolicitacaoArmario solicitacaoArmario){

        solicitacaoArmario.setDataAluguelArmario(LocalDate.now());
        solicitacaoArmario.setStatusAluguel(StatusAluguel.CONFIRMADO);
        armario.setStatus(StatusArmario.ALUGADO);
        return solicitacaoArmarioRepository.save(solicitacaoArmario);

    }


}
