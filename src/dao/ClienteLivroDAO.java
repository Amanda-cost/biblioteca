package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import model.ClienteLivro;

public class ClienteLivroDAO {

    public void create(ClienteLivro clienteLivro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO ClienteLivro (tituloLivro, nomeCliente, dataEmprestimo, dataDevolucao, turmaAluno, FK_idCliente, FK_idLivro) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, clienteLivro.getTituloLivro());
            stmt.setString(2, clienteLivro.getNomeCliente());
            stmt.setString(3, clienteLivro.getDataEmprestimo());
            stmt.setString(4, clienteLivro.getDataDevolucao());
            stmt.setString(5, clienteLivro.getTurmaAluno()); // novo campo
            stmt.setString(6, clienteLivro.getFK_idCliente());
            stmt.setString(7, clienteLivro.getFK_idLivro());

            stmt.execute();
            System.out.println("Registro de empréstimo criado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar empréstimo!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<ClienteLivro> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ClienteLivro> emprestimos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ClienteLivro");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteLivro cl = new ClienteLivro();
                cl.setIdClienteLivro(rs.getString("idClienteLivro"));
                cl.setTituloLivro(rs.getString("tituloLivro"));
                cl.setNomeCliente(rs.getString("nomeCliente"));
                cl.setDataEmprestimo(rs.getString("dataEmprestimo"));
                cl.setDataDevolucao(rs.getString("dataDevolucao"));
                cl.setDevolvido(rs.getBoolean("devolvido"));
                cl.setTurmaAluno(rs.getString("turmaAluno")); // novo campo

                emprestimos.add(cl);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler os registros de empréstimos!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return emprestimos;
    }

    public void update(ClienteLivro clienteLivro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE ClienteLivro SET tituloLivro = ?, nomeCliente = ?, dataEmprestimo = ?, dataDevolucao = ?, devolvido = ?, turmaAluno = ? WHERE idClienteLivro = ?"
            );
            stmt.setString(1, clienteLivro.getTituloLivro());
            stmt.setString(2, clienteLivro.getNomeCliente());
            stmt.setString(3, clienteLivro.getDataEmprestimo());
            stmt.setString(4, clienteLivro.getDataDevolucao());
            stmt.setBoolean(5, clienteLivro.isDevolvido());
            stmt.setString(6, clienteLivro.getTurmaAluno()); // novo campo
            stmt.setString(7, clienteLivro.getIdClienteLivro());

            stmt.execute();
            System.out.println("Registro de empréstimo atualizado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o registro!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void delete(String idClienteLivro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ClienteLivro WHERE idClienteLivro = ?");
            stmt.setString(1, idClienteLivro);

            stmt.execute();
            System.out.println("Registro de empréstimo deletado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o registro!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<ClienteLivro> search(String pesquisar) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ClienteLivro> emprestimos = new ArrayList<>();

        pesquisar = "%" + pesquisar + "%";

        try {
            stmt = con.prepareStatement(
                "SELECT * FROM ClienteLivro WHERE tituloLivro LIKE ? OR nomeCliente LIKE ? OR turmaAluno LIKE ?"
            );
            stmt.setString(1, pesquisar);
            stmt.setString(2, pesquisar);
            stmt.setString(3, pesquisar); // inclui busca por turmaAluno

            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteLivro cl = new ClienteLivro();
                cl.setIdClienteLivro(rs.getString("idClienteLivro"));
                cl.setTituloLivro(rs.getString("tituloLivro"));
                cl.setNomeCliente(rs.getString("nomeCliente"));
                cl.setDataEmprestimo(rs.getString("dataEmprestimo"));
                cl.setDataDevolucao(rs.getString("dataDevolucao"));
                cl.setDevolvido(rs.getBoolean("devolvido"));
                cl.setTurmaAluno(rs.getString("turmaAluno")); // novo campo

                emprestimos.add(cl);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar registros!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return emprestimos;
    }
}
