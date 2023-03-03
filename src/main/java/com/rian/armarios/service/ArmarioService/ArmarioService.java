package com.rian.armarios.service.ArmarioService;
import com.rian.armarios.model.Armario;
import com.rian.armarios.model.StatusArmario;
import com.rian.armarios.repository.ArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArmarioService {

    @Autowired
   private ArmarioRepository armarioRepository;

    @Transactional
    public Armario cadastrarArmario(Armario armario){
         armario.setStatus(StatusArmario.DISPONIVEL);
         return armarioRepository.save(armario);
    }

}
