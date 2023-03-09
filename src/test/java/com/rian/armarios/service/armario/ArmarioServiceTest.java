package com.rian.armarios.service.armario;

import com.rian.armarios.model.Armario;
import com.rian.armarios.repository.ArmarioRepository;
import com.rian.armarios.service.ArmarioService.ArmarioService;
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

@SpringBootTest(classes = ArmarioService.class)
@AutoConfigureMockMvc
public class ArmarioServiceTest{

    @MockBean
    ArmarioRepository armarioRepository;

    @Autowired
    ArmarioService armarioService;

    private Armario armario;

    @BeforeEach
    void setup(){
        armario = mock(Armario.class);
    }

    @Test
    @DisplayName("Deve salvar um armario")
    void deveSalvarUmArmario(){
        Mockito.when(armarioRepository.save(ArgumentMatchers.any(Armario.class))).thenReturn(armario);

        Armario response = armarioService.cadastrarArmario(armario);

        Assertions.assertEquals(armario, response);
        Mockito.verify(armarioRepository).save(ArgumentMatchers.any(Armario.class));
    }
}
