package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectionFactory.ConnectionDatabase;
import model.Administrador;



public class AdministradorDAO {

	public void create(Administrador admin) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;


		try {
			stmt = con.prepareStatement("INSERT INTO Administrador values(?,?,?,?)");
			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getCPF());
			stmt.setString(3, admin.getSenha());
			stmt.setString(4, admin.getTelefone());

			stmt.execute();
			System.out.print("Administrador cadastrado!");



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar !", e);
			
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}
	}
		
		public ArrayList<Administrador>read(){
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Administrador> admins = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM Administrador");
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					Administrador admin = new Administrador();
					admin.setIdAdmin(rs.getString("idAdmin"));
					admin.setNome(rs.getString("nome"));
					admin.setCPF(rs.getString("CPF"));
					admin.setSenha(rs.getString("senha"));
					admin.setTelefone(rs.getString("telefone"));
					admins.add(admin);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Erro ao ler os dados",e);
			}finally{
				ConnectionDatabase.closeConnection(con,stmt,rs);
			}
			return admins;
		
		}
		
		public void update(Administrador admin) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;


			try {
				stmt = con.prepareStatement("UPDATE Administrador set nome = ? , CPF = ?, senha = ?,"
			+ "telefone = ?");
				stmt.setString(1, admin.getNome());
				stmt.setString(3, admin.getCPF());
				stmt.setString(4, admin.getSenha());
				stmt.setString(5, admin.getTelefone());

				stmt.execute();
				System.out.print("Administrador Atualizado!");



			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao atualizar !", e);
			} finally {
				ConnectionDatabase.closeConnection(con, stmt);

			}
		}
		
		public void delete(String cpf) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;


			try {
				stmt = con.prepareStatement("DELETE FROM Administrador where CPF = ?");
				stmt.setString(1, cpf);
				
				stmt.execute();
				System.out.println("Administrador apagado!");
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao apagar !", e);
			} finally {
				ConnectionDatabase.closeConnection(con, stmt);

			}
		}
		public ArrayList<Administrador> search (String pesquisar) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			pesquisar = "%" + pesquisar + "%";
			ArrayList<Administrador> admins = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM Administrador where nome like ? or CPF like ? ");
				stmt.setString(1, pesquisar);
				stmt.setString(2, pesquisar);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					Administrador admin = new Administrador();
					admin.setIdAdmin(rs.getString("idAdmin"));
					admin.setNome(rs.getString("nome"));
					admin.setCPF(rs.getString("CPF"));
					admin.setSenha(rs.getString("senha"));
					admin.setTelefone(rs.getString("telefone"));
					admins.add(admin);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Erro ao ler os dados",e);
			}finally{
				ConnectionDatabase.closeConnection(con,stmt,rs);
			}
			return admins;
		
		
	}
		
		


public Administrador autenticarUser (String user, String password) {
	Connection con = ConnectionDatabase.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Administrador funcionario = new Administrador();

	try {
		stmt = con.prepareStatement("SELECT * FROM Administrador where CPF = ? and senha = ? ");
		stmt.setString(1, user);
		stmt.setString(2, password);
		rs = stmt.executeQuery();

		while (rs.next()) {
			funcionario.setIdAdmin(rs.getString("idAdmin"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setCPF(rs.getString("CPF"));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setTelefone(rs.getString("telefone"));
		}

	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Erro ao ler os dados",e);
	}finally{
		ConnectionDatabase.closeConnection(con,stmt,rs);
	}
	return funcionario;


}
}









