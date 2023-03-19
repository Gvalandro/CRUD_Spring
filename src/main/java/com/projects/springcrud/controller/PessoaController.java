package com.projects.springcrud.controller;


import com.projects.springcrud.model.Pessoa;
import com.projects.springcrud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Thread.*;

//Classe Responsável por Controlar o Fluxo das Requisições HTTP e utilizar as regras de negócio

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;



    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        return pessoaService.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return pessoaService.getById(id);
    }



    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Pessoa pessoa){
        return pessoaService.update(id,pessoa);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return pessoaService.delete(id);
    }
}
