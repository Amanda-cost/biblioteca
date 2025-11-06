package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDatabase {
	// Endereço do driver do SQL Server
	private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// URL do banco de dados
	private static final String URL = "jdbc:sqlserver://localhost:60008;encrypt=false;databaseName=Biblioteca";
	// Usuário do banco de dados
	private static final String user = "sa";
	// Senha do usuário do banco de dados
	private static final String password = "Senailab03";

	public static Connection getConnection() {

		try {

			Class.forName(Driver);
			System.out.println("Conexão realizada.");
			return DriverManager.getConnection(URL, user, password);	

		}catch (ClassNotFoundException | SQLException e ) {

			e.printStackTrace();
			throw new RuntimeException("Erro de conexão.", e);
		}

	}

	public static void closeConnection(Connection con) {
		try {

			if(con != null) {
				con.close();	
				System.out.println("Conexão fechada.");
			}

		}	catch (Exception e) {


			throw new RuntimeException("Erro ao fechar conexão.", e);

		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {

		closeConnection(con);

		try {

			if(stmt != null) {
				stmt.close();
			}

		} catch (Exception e) {

			throw new RuntimeException("Erro ao fechar conexão.", e);

		}

	}
	
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

		closeConnection(con);

		try {

			if(rs != null) {
				rs.close();
			}

		} catch (Exception e) {

			throw new RuntimeException("Erro ao fechar conexão.", e);

		}

	}



}
