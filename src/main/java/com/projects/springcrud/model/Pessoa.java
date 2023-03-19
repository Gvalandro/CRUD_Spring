package com.projects.springcrud.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "testPeople")
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_pessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dt_nasc")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;


    @Column(name ="enderecos")
    @OneToMany(mappedBy = "enderecos_pessoa",cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(Long id_pessoa, String nome, LocalDate dataNascimento, Endereco enderecos) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecos.add(enderecos);
    }

    public Pessoa(){
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Long getId_pessoa() {
        return id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public void adicionaEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco){
        enderecos.remove(endereco);
    }

}
