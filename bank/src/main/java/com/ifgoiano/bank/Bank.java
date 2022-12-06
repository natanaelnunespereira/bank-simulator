package com.ifgoiano.bank;

import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.dto.PessoaJuridica;
import com.ifgoiano.bank.dto.Conta;
import com.ifgoiano.bank.dao.ContaDao;
import com.ifgoiano.bank.dao.PessoaFisicaDao;
import com.ifgoiano.bank.dao.PessoaJuridicaDao;

public class Bank {

    public static void main(String[] args) {
        // Realização de testes.
        PessoaFisica p1 = new PessoaFisica("Ana", "Rua 1", "000.000.000-01");
        PessoaFisicaDao pf = new PessoaFisicaDao();
        
        pf.inserir(p1);
        p1.setNome("Ana Maria");
        p1.setEndereco("Rua 02");
        p1.setCpf("000.000.000-11");
        pf.alterar(p1);
        
        Conta c1 = new Conta(p1, 0001, 10.0, "qwe123");
        ContaDao c = new ContaDao();
        
        c.inserir(c1);
        c1.setNumero(0011);
        c.alterar(c1);
        c1.setStatus(c.desativar(c1).getStatus());
        
        PessoaJuridica p2 = new PessoaJuridica("IF Goiano", "Rua 2", "00.000.000/0000-01");
        PessoaJuridicaDao pj = new PessoaJuridicaDao();
        
        pj.inserir(p2);
        p2.setNome("IF Goiano - Campus Ceres");
        p2.setCnpj("00.000.000/0000-11");
        pj.alterar(p2);
        
        Conta c2 = new Conta(p2, 0022, 10.0, "12345678");
        c.inserir(c2);
    }
}
