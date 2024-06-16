package servlet;

import dao.Conexao;
import dao.JogoDAO;
import model.Jogo;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/jogo")
public class JogoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String desenvolvedor = request.getParameter("desenvolvedor");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String categoria = request.getParameter("categoria");
        double preco = Double.parseDouble(request.getParameter("preco"));

        try (Connection connection = Conexao.getConexao()) {
            JogoDAO jogoDAO = new JogoDAO(connection);
            jogoDAO.inserirJogo(nome, desenvolvedor, ano, categoria, preco);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir jogo no banco de dados.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = Conexao.getConexao()) {
            JogoDAO jogoDAO = new JogoDAO(connection);
            List<Jogo> jogos = jogoDAO.listarJogos();
            String json = new Gson().toJson(jogos);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar jogos do banco de dados.");
        }
    }
}
