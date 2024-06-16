package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String BD_USUARIO = "root";
    private static final String BD_SENHA = "root";
    private static final String BD_HOST = "jdbc:mysql://127.0.0.1:3306/tdepoo?useSSL=false";

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(BD_HOST, BD_USUARIO, BD_SENHA);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver do banco de dados não encontrado.");
        }
    }
}
