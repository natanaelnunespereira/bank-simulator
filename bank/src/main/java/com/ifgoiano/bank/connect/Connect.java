package com.ifgoiano.bank.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Connect {
    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/cadastro_banco?useTimezone=true&serverTimezone=UTC";
    public static final String USUARIO = "root";
    public static final String SENHA = "";
    public static Connection conexao = null;
    
    // Método para conectar ao banco de dados.
    public static Connection getConexao() {
        try {
            // Se a conexão existir, não irá criar uma nova.
            if (conexao == null) {
                conexao = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
            }

            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement prepareStatement(String sql, int RETURN_GENERATED_KEYS) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
