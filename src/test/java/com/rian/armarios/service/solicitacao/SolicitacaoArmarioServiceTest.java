package com.rian.armarios.service.solicitacao;

import com.rian.armarios.model.SolicitacaoArmario;
import com.rian.armarios.repository.SolicitacaoArmarioRepository;
import com.rian.armarios.service.ArmarioService.ArmarioService;
import com.rian.armarios.service.SolicitacaoService.SolicitacaoArmarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.mock;

@SpringBootTest(classes = SolicitacaoArmarioService.class)
@AutoConfigureMockMvc
public class SolicitacaoArmarioServiceTest{

    @MockBean
    SolicitacaoArmarioRepository solicitacaoArmarioRepository;

    @Autowired
    SolicitacaoArmarioService solicitacaoArmarioService;

    private SolicitacaoArmario solicitacaoArmario;

    @BeforeEach
    void setup(){
        solicitacaoArmario = mock(SolicitacaoArmario.class);
    }

    @Test
    @DisplayName("Deve solicitar um armario")
    void DeveSolicitarUmArmario(){
        Mockito.when(solicitacaoArmarioRepository.save(solicitacaoArmario)).thenReturn(solicitacaoArmario);

        SolicitacaoArmario  resposta = solicitacaoArmarioService.solicitarArmario(solicitacaoArmario);

        Assertions.assertEquals(solicitacaoArmario, resposta);
        Mockito.verify(solicitacaoArmarioRepository).save(ArgumentMatchers.any(SolicitacaoArmario.class));
    }

    @Test
    @DisplayName("Deve deletar uma solicitacao")
    void DeveDeletarUmaSolicitacao(){
        solicitacaoArmarioService.deletar(1L);

        Mockito.verify(solicitacaoArmarioRepository).deleteById(ArgumentMatchers.anyLong());
    }
}
