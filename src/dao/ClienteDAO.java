package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import alertas.Alerts;
import connectionFactory.ConnectionDatabase;
import model.Cliente;

public class ClienteDAO {

	public void create(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;


		try {
			stmt = con.prepareStatement("INSERT INTO Cliente values(?,?,?,?,?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getIdade());
			stmt.setString(3, cliente.getCPF());
			stmt.setString(4, cliente.getTurma());
			stmt.setString(5, cliente.getTelefone());

			stmt.execute();
			System.out.print("Cliente cadastrado!");



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar !", e);
			
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}
	}
		
		public ArrayList<Cliente>read(){
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM Cliente");
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getString("idCliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setIdade(rs.getString("idade"));
					cliente.setCPF(rs.getString("CPF"));
					cliente.setTurma(rs.getString("turma"));
					cliente.setTelefone(rs.getString("telefone"));
					clientes.add(cliente);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Erro ao ler os dados",e);
			}finally{
				ConnectionDatabase.closeConnection(con,stmt,rs);
			}
			return clientes;
		
		}
		
		public void update(Cliente cliente) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;


			try {
				stmt = con.prepareStatement("UPDATE Cliente set nome = ? , idade = ?, CPF = ?,"
			+ "turma = ?, telefone = ?");
				stmt.setString(1, cliente.getNome());
				stmt.setString(2, cliente.getIdade());
				stmt.setString(3, cliente.getCPF());
				stmt.setString(4, cliente.getTurma());
				stmt.setString(5, cliente.getTelefone());

				stmt.execute();
				System.out.print("Cliente Atualizado!");



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
				stmt = con.prepareStatement("DELETE FROM Cliente where CPF = ?");
				stmt.setString(1, cpf);
				
				stmt.execute();
				System.out.println("Cliente apagado!");
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 Alerts.alerterro("ERRO", "O CLIENTE NAO PODE SER EXCLUIDO", "UMA TABELA DE EMPRÉSTIMO AINDA TEM ESTE CLIENTE REGISTRADO. DELETE O EMPRÉSTIMO.");
				throw new RuntimeException("Erro ao apagar !", e);
			} finally {
				ConnectionDatabase.closeConnection(con, stmt);

			}
		}
		public ArrayList<Cliente> search (String pesquisar) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			pesquisar = "%" + pesquisar + "%";
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM Cliente where nome like ? or CPF like ? ");
				stmt.setString(1, pesquisar);
				stmt.setString(2, pesquisar);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getString("idCliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setIdade(rs.getString("idade"));
					cliente.setCPF(rs.getString("CPF"));
					cliente.setTurma(rs.getString("turma"));
					cliente.setTelefone(rs.getString("telefone"));
					clientes.add(cliente);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Erro ao ler os dados",e);
			}finally{
				ConnectionDatabase.closeConnection(con,stmt,rs);
			}
			return clientes;
		
		
	}
}








