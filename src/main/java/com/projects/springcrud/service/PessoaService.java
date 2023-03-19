package com.projects.springcrud.service;

import com.projects.springcrud.model.Endereco;
import com.projects.springcrud.model.Pessoa;
import com.projects.springcrud.repository.EnderecoRepository;
import com.projects.springcrud.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final EnderecoRepository enderecoRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public ResponseEntity<List<Pessoa>> getAll(){
        try {
            List<Pessoa> pessoas = pessoaRepository.findAll();
            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> getById(Long id){

        if(pessoaRepository.findById(id).isPresent())
            return new ResponseEntity<>(pessoaRepository.findById(id).get(), HttpStatus.OK);
        else {
            return new ResponseEntity<>("Não Foi possivel localizar no Banco", HttpStatus.NOT_FOUND);
        }


    }

    public ResponseEntity<Pessoa> save(Pessoa pessoa){
        return new ResponseEntity<>(pessoaRepository.save(pessoa),HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Long id, Pessoa pessoa) {
        if (pessoaRepository.findById(id).isPresent()) {
            Pessoa attpessoa = pessoaRepository.findById(id).get();
            attpessoa.setNome(pessoa.getNome());
            attpessoa.setDataNascimento(pessoa.getDataNascimento());
            return new ResponseEntity<>(pessoaRepository.save(attpessoa), HttpStatus.OK);
        }else return new ResponseEntity<>("Falha no Update da Pessoa", HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<?> delete(Long id){
            if(pessoaRepository.findById(id).isPresent()){
                pessoaRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else return ResponseEntity.notFound().build();

    }

    public Endereco addEnderecoPessoa(Long id_pessoa, Endereco end){
            if(pessoaRepository.findById(id_pessoa).isPresent()){
                Pessoa a = pessoaRepository.getById(id_pessoa);

                end.setEnderecos_pessoa(a);

            }
    }


}
