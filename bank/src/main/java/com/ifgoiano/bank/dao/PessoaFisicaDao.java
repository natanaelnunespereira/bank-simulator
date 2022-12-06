package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaFisicaDao {
    private final Connection conexao;
    private PreparedStatement stmt;
    PessoaDao pessoaDao = new PessoaDao();
    
    public PessoaFisicaDao() {
        this.conexao = Connect.getConexao();
    }
    
    // Método para persistir um objeto do tipo PessoaFisica.
    public void inserir(PessoaFisica pessoaFisica) {
        // Inserir dados referente a Pessoa e atribuir o id retornado.
        pessoaFisica.setId(pessoaDao.inserir(pessoaFisica));
        
        // Sql referente a inserção na tabela 'pessoa_fisica'.
        String sql = "INSERT INTO pessoa_fisica (id_pessoa, cpf) VALUES(?, ?)";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pessoaFisica.getId());
            stmt.setString(2, pessoaFisica.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para alterr um objeto do tipo PessoaFisica.
    public void alterar(PessoaFisica pessoaFisica) {
        // Alterar dados referente a Pessoa.
        pessoaDao.alterar(pessoaFisica);
        
        // Sql referente a atualização na tabela 'pessoa_fisica'.
        String sql = "UPDATE pessoa_fisica SET cpf = ? WHERE id_pessoa = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaFisica.getCpf());
            stmt.setInt(2, pessoaFisica.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
