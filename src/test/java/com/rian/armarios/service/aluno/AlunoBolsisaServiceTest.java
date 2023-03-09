package com.rian.armarios.service.aluno;

import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import com.rian.armarios.service.AlunoService.AlunoBolsistaService;
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

import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

@SpringBootTest(classes = AlunoBolsistaService.class)
@AutoConfigureMockMvc
public class AlunoBolsisaServiceTest {

    @MockBean
    AlunoBolsistaRepository alunoBolsistaRepository;

    @Autowired
    AlunoBolsistaService alunoBolsistaService;

    private AlunoBolsista alunoBolsista;

    @BeforeEach
    void setup(){
        alunoBolsista = mock(AlunoBolsista.class);
    }

    @Test
    @DisplayName("Deve salvar um aluno bolsista")
    void deveSalvarUmAlunoBolsista(){
        Mockito.when(alunoBolsistaRepository.findByEmail(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Mockito.when(alunoBolsistaRepository.save(ArgumentMatchers.any(AlunoBolsista.class))).thenReturn(alunoBolsista);

        AlunoBolsista resposta = alunoBolsistaService.salvar(alunoBolsista);

        Assertions.assertEquals(alunoBolsista, resposta);

    }

    @Test
    @DisplayName("Deve lançar uma exception ao salvar um aluno bolsista")
    void deveLancarUmaExceptionSalvarUmAlunoBolsista(){
        AlunoBolsista alunoBolsistaDoOptional = new AlunoBolsista();
        alunoBolsistaDoOptional.setEmail("aluno@aluno.com");
        alunoBolsista.setEmail("aluno@aluno.com");

        Mockito.when(alunoBolsistaRepository.findByEmail(ArgumentMatchers.anyString())).thenReturn(Optional.of(alunoBolsista));

        Assertions.assertThrowsExactly(AlunoBolsistaException.class, ()-> alunoBolsistaService.salvar(alunoBolsistaDoOptional) ,"Email Ja Cadastrado");
    }

}
