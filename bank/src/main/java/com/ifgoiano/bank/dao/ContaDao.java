package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.Conta;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaDao {
    private Connection conexao;
    private PreparedStatement stmt;

    public ContaDao() {
        this.conexao = Connect.getConexao();
    }
    
    // Método para persistir um objeto do tipo Conta.
    public Conta inserir(Conta conta) {
        // Sql referente a inserção na tabela 'conta'.
        String sql = "INSERT INTO conta(numero, saldo, status, senha, id_pessoa) VALUES(?, ?, 0, MD5(?), ?);";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getSenha());
            stmt.setInt(4, conta.getPessoa().getId());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            // Atribui o id do objeto conta.
            conta.setId(rs.getInt(1));
            stmt.close();

            return conta;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para alterar um objeto do tipo Conta.
    public void alterar(Conta conta) {
        // Sql referente a atualização na tabela 'conta'.
        String sql = "UPDATE conta SET numero = ?, saldo = ?, status = ?, senha = MD5(?), id_pessoa = ? WHERE id = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getStatus());
            stmt.setString(4, conta.getSenha());
            stmt.setInt(5, conta.getPessoa().getId());
            stmt.setInt(6, conta.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para desativar um objeto do tipo Conta.
    public Conta desativar (Conta conta) {
        // Sql referente a desativar conta.
        String sql = "UPDATE conta SET status = 1 WHERE id = ?;";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, conta.getId());
            stmt.execute();
            stmt.close();
            
            conta.setStatus(1);
            
            return conta;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
