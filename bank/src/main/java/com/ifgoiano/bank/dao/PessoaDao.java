package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.dto.PessoaJuridica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDao {
    private final Connection conexao;
    private PreparedStatement stmt;

    public PessoaDao() {
        this.conexao = Connect.getConexao();
    }
    
    // Método para persistir um objeto do tipo PessoaFisica.
    public int inserir(PessoaFisica pessoaFisica) {
        // Sql referente a inserção na tabela 'pessoa'.
        String sql = "INSERT INTO pessoa(nome, endereco, tipo) VALUES(?, ?, 'F')";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaFisica.getNome());
            stmt.setString(2, pessoaFisica.getEndereco());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            //Atribui o id do objeto pessoaFisica.
            pessoaFisica.setId(rs.getInt(1));
            
            stmt.close();

            return pessoaFisica.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para persistir um objeto do tipo PessoaJuridica.
    public int inserir(PessoaJuridica pessoaJuridica) {
        // Sql referente a inserção na tabela 'pessoa'.
        String sql = "INSERT INTO pessoa(nome, endereco, tipo) VALUES(?, ?, 'J')";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaJuridica.getNome());
            stmt.setString(2, pessoaJuridica.getEndereco());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            // Atribui o id do objeto pessoaJuridica.
            pessoaJuridica.setId(rs.getInt(1));
            
            stmt.close();

            return pessoaJuridica.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para alterar um objeto do tipo PessoaFisica.
    public void alterar(PessoaFisica pessoaFisica) {
        // Sql referente a atualização na tabela 'pessoa'.
        String sql = "UPDATE pessoa SET nome = ?, endereco = ? WHERE id = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaFisica.getNome());
            stmt.setString(2, pessoaFisica.getEndereco());
            stmt.setInt(3, pessoaFisica.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para alterar um objeto do tipo PessoaJuridica.
    public void alterar(PessoaJuridica pessoaJuridica) {
        // Sql referente a atualização na tabela 'pessoa'.
        String sql = "UPDATE pessoa SET nome = ?, endereco = ? WHERE id = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoaJuridica.getNome());
            stmt.setString(2, pessoaJuridica.getEndereco());
            stmt.setInt(3, pessoaJuridica.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
