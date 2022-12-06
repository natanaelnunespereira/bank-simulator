package com.ifgoiano.bank.dto;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String cnpj) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.cnpj= cnpj;
    }

    public PessoaJuridica(int id, String nome, String endereco, String cnpj) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.cnpj= cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
