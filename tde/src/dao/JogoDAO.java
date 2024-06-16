package dao;

import model.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private Connection connection;

    public JogoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirJogo(String nome, String desenvolvedor, int ano, String categoria, double preco) {
        String sql = "INSERT INTO jogo (nome, desenvolvedor, ano, categoria, preco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, desenvolvedor);
            stmt.setInt(3, ano);
            stmt.setString(4, categoria);
            stmt.setDouble(5, preco);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir no banco", e);
        }
    }

    public List<Jogo> listarJogos() {
        String query = "SELECT * FROM jogo";
        List<Jogo> jogos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("desenvolvedor"),
                        rs.getInt("ano"),
                        rs.getString("categoria"),
                        rs.getDouble("preco")
                );
                jogos.add(jogo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar jogos.");
        }
        return jogos;
    }
}
