package br.com.hitoshi.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UsuarioDBOracle {
	
	public Connection ConexaoDB() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93442", "130204");
			
			if(conn != null) {
				System.out.println("Sucesso na conexão com a database :D");
			} else {
				System.out.println("Deu ruim na conexão irmão...");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return conn;
		
	}
	
	public void InserirAlunoDB(Aluno al) {
		
		Connection conn = ConexaoDB();
		
		Statement statement;
		
		try {
			
			String query = String.format("insert into TB_ALUNO (aluno_id, nome_aluno, ra_aluno, curso_aluno) values ('%s', '%s', '%s', '%s')", al.getId(), al.getNome(), al.getRa(), al.getCurso());
			
			statement = conn.createStatement();
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void ListarAlunoDB() {
		
		Connection conn = ConexaoDB();
		
		Statement statement;
		
		ResultSet rs = null;
		
		try {
			
			String query = "select * from TB_ALUNO";
			
			statement = conn.createStatement();
			
			rs = statement.executeQuery(query);

			while(rs.next()) {
				System.out.printf("Id: '%s' - Nome: '%s' - R.A: '%s' - Curso: '%s'\n", rs.getString("aluno_id") + " ", rs.getString("nome_aluno"), rs.getString("ra_aluno"), rs.getString("curso_aluno"));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	

}
