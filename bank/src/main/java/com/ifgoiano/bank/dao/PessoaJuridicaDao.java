package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaJuridica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaJuridicaDao {
    private final Connection conexao;
    private PreparedStatement stmt;
    PessoaDao pessoaDao = new PessoaDao();

    public PessoaJuridicaDao() {
        this.conexao = Connect.getConexao();
    }
    
    // Método para persistir um objeto do tipo PessoaJuridica.
    public void inserir(PessoaJuridica pessoaJuridica) {
        // Inserir dados referente a Pessoa e atribuir o id retornado.
        pessoaJuridica.setId(pessoaDao.inserir(pessoaJuridica));
        
        // Sql referente a inserção na tabela 'pessoa_Juridica'.
        String sql = "INSERT INTO pessoa_juridica (id_pessoa, cnpj) VALUES(?, ?)";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pessoaJuridica.getId());
            stmt.setString(2, pessoaJuridica.getCnpj());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para alterar um objeto do tipo PessoaJuridica.
    public void alterar(PessoaJuridica pessoaJuridica) {
        // Alterar dados referente a Pessoa.
        pessoaDao.alterar(pessoaJuridica);
        
        // Sql referente a atualização na tabela 'pessoa_juridica'.
        String sql = "UPDATE pessoa_juridica SET cnpj = ? WHERE id_pessoa = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaJuridica.getCnpj());
            stmt.setInt(2, pessoaJuridica.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
