package com.projects.springcrud.model;

import jakarta.persistence.*;


@Entity
@Table(name = "End")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id_endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_pessoa",foreignKey = @ForeignKey(name = "id_pessoa"))
    private Pessoa enderecos_pessoa;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "num")
    private String numero;

    @Column(name = "cidade")
    private String cidade;


    public Endereco(Long id_endereco, Pessoa pessoa, String logradouro, String cep, String numero, String cidade) {

        this.id_endereco = id_endereco;
        this.enderecos_pessoa = pessoa;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }
    public Endereco() {
    }



    public Pessoa getEnderecos_pessoa() {
        return enderecos_pessoa;
    }

    public void setEnderecos_pessoa(Pessoa id_pessoa) {
        this.enderecos_pessoa = id_pessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {

        this.logradouro = logradouro;
    }

    public String getCep() {

        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {

        this.numero = numero;
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public void setId_endereco(Long idEndereco) {
        this.id_endereco = idEndereco;
    }

    public Long getId_endereco() {
        return id_endereco;
    }
}
