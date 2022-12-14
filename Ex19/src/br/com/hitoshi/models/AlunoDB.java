package br.com.hitoshi.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlunoDB {
	
	public Connection ConexaoDB(String dbname, String user, String pass) {
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://jelani.db.elephantsql.com:5432/" + dbname, user, pass);
			if(conn != null) {
				System.out.println("Sucesso na conex?o!");
			} else {
				System.out.println("Tivemos um problema ao conectar com o banco :(");
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
	
	public void InserirAlunoDB(Aluno al) {
		
		Connection conn = ConexaoDB("poinczki", "poinczki", "E_hweKdydwtmAqHTuaDrXWunETPfORgp");
		
		Statement statement;
		
		try {
			
			String query = String.format("insert into tb_aluno (id, nome, ra, curso) values ('%s', '%s', '%s', '%s');", al.getId(), al.getNome(), al.getRa(), al.getCurso());
			
			statement = conn.createStatement();
			
			statement.executeUpdate(query);
			
			System.out.println("\nRegistro conclu?do com sucesso!");
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void ListarAlunosDB() {
		
		Connection conn = ConexaoDB("poinczki", "poinczki", "E_hweKdydwtmAqHTuaDrXWunETPfORgp");
		
		Statement statement;
		
		ResultSet rs = null;
		
		try {
			
			String query = "select * from tb_aluno;";
			
			statement = conn.createStatement();
			
			rs = statement.executeQuery(query);
			
			if(rs.getFetchSize() == 0) {
				System.out.println("\nN?o h? alunos cadastrados no banco!");
			} else {
				while(rs.next()) {
					System.out.printf("Id: %s - Nome: %s - R.A: %s - Curso: %s\n", rs.getString("id"), rs.getString("nome"), rs.getString("ra"), rs.getString("curso"));
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}
