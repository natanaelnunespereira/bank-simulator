package com.ifgoiano.bank.dto;

public class PessoaFisica extends Pessoa{
    private String cpf;
    
    public PessoaFisica(String nome, String endereco, String cpf) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.cpf = cpf;
    }

    public PessoaFisica(int id, String nome, String endereco, String cpf) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
