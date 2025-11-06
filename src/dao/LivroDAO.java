package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import alertas.Alerts;
import connectionFactory.ConnectionDatabase;
import model.Livro;

public class LivroDAO {

    public void create(Livro livro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Livro VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getAno());
            stmt.setInt(6, livro.getQuantDisponivel());

            stmt.execute();
            System.out.println("Livro cadastrado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar o livro!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<Livro> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Livro> livros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Livro");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getString("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setGenero(rs.getString("genero"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setAno(rs.getString("ano"));
                livro.setQuantDisponivel(rs.getInt("quantDisponivel"));

                livros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler os dados dos livros", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return livros;
    }

    public void update(Livro livro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Livro SET titulo = ?, genero = ?, autor = ?, editora = ?, ano = ?, quantDisponivel = ? WHERE idLivro = ?");
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getAno());
            stmt.setInt(6, livro.getQuantDisponivel());
            stmt.setString(7, livro.getIdLivro());

            stmt.execute();
            System.out.println("Livro atualizado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o livro!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void delete(String idLivro) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Livro WHERE idLivro = ?");
            stmt.setString(1, idLivro);

            stmt.execute();
            System.out.println("Livro deletado!");

        } catch (SQLException e) {
        	 Alerts.alerterro("ERRO", "O LIVRO NAO PODE SER EXCLUIDO", "UMA TABELA DE EMPRÉSTIMO AINDA TEM ESTE LIVRO REGISTRADO. DELETE O EMPRÉSTIMO.");
            throw new RuntimeException("Erro ao deletar o livro!", e);
                   } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public ArrayList<Livro> search(String pesquisar) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Livro> livros = new ArrayList<>();

        pesquisar = "%" + pesquisar + "%";

        try {
            stmt = con.prepareStatement("SELECT * FROM Livro WHERE titulo LIKE ? OR autor LIKE ? OR genero LIKE ?");
            stmt.setString(1, pesquisar);
            stmt.setString(2, pesquisar);
            stmt.setString(3, pesquisar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getString("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setGenero(rs.getString("genero"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setAno(rs.getString("ano"));
                livro.setQuantDisponivel(rs.getInt("quantDisponivel"));

                livros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livros!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return livros;
    }
}
