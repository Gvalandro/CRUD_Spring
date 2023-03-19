package com.projects.springcrud.controller;


import com.projects.springcrud.model.Endereco;
import com.projects.springcrud.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping
    public List<Endereco> getAll(){
        return enderecoService.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return enderecoService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> savePessoa(@RequestBody Endereco endereco){
        return enderecoService.save(endereco);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Endereco endereco){
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return enderecoService.delete(id);
    }
}
