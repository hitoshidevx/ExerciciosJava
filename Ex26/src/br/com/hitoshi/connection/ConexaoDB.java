package br.com.hitoshi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93442", "130204");
			
			if(conn != null) {
				System.out.println("Sucesso na conexão com a database :D");
			} else {
				System.out.println("Deu ruim na conexão irmão...");
			}
			
		} catch (SQLException sqlException) {
			System.err.format("SQL State: %s\n%s", sqlException.getSQLState(), sqlException.getMessage());
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return conn;
		
	}
	
}
