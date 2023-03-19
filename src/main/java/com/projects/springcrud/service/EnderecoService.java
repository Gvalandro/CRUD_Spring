package com.projects.springcrud.service;

import com.projects.springcrud.model.Endereco;
import com.projects.springcrud.model.Pessoa;
import com.projects.springcrud.repository.EnderecoRepository;
import com.projects.springcrud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Endereco> getAll(){
        return enderecoRepository.findAll();
    }

    public ResponseEntity<?> getById(Long id){
        if(enderecoRepository.findById(id).isPresent())
            return new ResponseEntity<>(enderecoRepository.findById(id).get(), HttpStatus.OK);
        else {
            return new ResponseEntity<>("Não Foi possivel localizar no Banco", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Endereco> save(Endereco endereco){
       // Pessoa pessoa = pessoaRepository.findById(endereco.getEnderecos_pessoa().getId_pessoa()).orElse(null);
        //if(pessoa == null){
          //  pessoa = new Pessoa();
        //}
        //pessoa.setNome(endereco.getEnderecos_pessoa().getNome());
        //pessoa.setDataNascimento(endereco.getEnderecos_pessoa().getDataNascimento());
        //pessoa.adicionaEndereco(endereco);


        return new ResponseEntity<>(enderecoRepository.save(endereco),HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Long id, Endereco endereco){
        if(enderecoRepository.findById(id).isPresent()){
            Endereco novoEndereco = enderecoRepository.findById(id).get();
            novoEndereco.setLogradouro(endereco.getLogradouro());
            novoEndereco.setNumero(endereco.getNumero());
            novoEndereco.setCidade(endereco.getCidade());
            novoEndereco.setCep(endereco.getCep());
            return new ResponseEntity<>(enderecoRepository.save(novoEndereco),HttpStatus.OK);
        }else return new ResponseEntity<>("Falha no Update da Pessoa", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> delete(Long id){
        if(enderecoRepository.findById(id).isPresent()){
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else return ResponseEntity.notFound().build();
    }

}
