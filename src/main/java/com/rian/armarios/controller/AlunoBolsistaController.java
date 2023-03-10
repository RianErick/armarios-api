package com.rian.armarios.controller;


import com.rian.armarios.handler.exception.AlunoBolsistaException;
import com.rian.armarios.model.AlunoBolsista;
import com.rian.armarios.repository.AlunoBolsistaRepository;
import com.rian.armarios.service.AlunoService.AlunoBolsistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoBolsistaController {

    @Autowired
    private AlunoBolsistaRepository alunoBolsistaRepository;
    @Autowired
    private AlunoBolsistaService alunoBolsistaService;

    @GetMapping("/busca")
    public List <AlunoBolsista> findAll() {
        return alunoBolsistaRepository.findAll();
    }
    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoBolsista create(@RequestBody @Valid  AlunoBolsista aluno) {
        return alunoBolsistaService.salvar(aluno);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity <AlunoBolsista> findById(@PathVariable Long id){
        return alunoBolsistaRepository
                .findById(id)
                .map(alunoBolsista -> ResponseEntity.ok(alunoBolsista))
                .orElseThrow(() -> new AlunoBolsistaException("Id do Aluno nao existe na base de dados"));
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <AlunoBolsista> edit(@PathVariable Long id, @RequestBody @Valid AlunoBolsista alunoBolsista){
        if(!alunoBolsistaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alunoBolsista.setId(id);
        alunoBolsistaService.salvar(alunoBolsista);
        return ResponseEntity.ok(alunoBolsista);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id ){
        if(!alunoBolsistaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alunoBolsistaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/buscar/matricula/{matricula}")
    public AlunoBolsista buscarPelaMatricula(@PathVariable String matricula){
        return alunoBolsistaRepository.findByMatricula(matricula)
                .orElseThrow(()-> new AlunoBolsistaException("Matricula nao encontrada"));
    }

}