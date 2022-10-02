package br.com.hitoshi.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProdutoDB {
	
	public Connection ConexaoDB(String db, String user, String password) {
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://jelani.db.elephantsql.com:5432/" + db, user, password);
			
			if(conn != null) {
				System.out.println("Sucesso na conexão :D");
			} else {
				System.out.println("Não foi possível estabelecer conexão com o banco");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
	
	public void InserirProdutoDB(Produto pd) {
		
		Connection conn = ConexaoDB("pccdpppp", "pccdpppp", "j09eZSVo9ueLk2AmoeS9uCz3Q68Ky04h");
		
		Statement statement;
		
		try {
			
			String query = String.format("insert into tb_produto (id, nome, preco, quantidade) values ('%d', '%s', '%f', '%d')", pd.getId(), pd.getNomeProduto(), pd.getPrecoProduto(), pd.getQuantidade());
			
			statement = conn.createStatement();
			
			statement.executeUpdate(query);
			
			System.out.println("\nRegistro concluído com sucesso!");
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void ListarProdutoDB() {
		
		Connection conn = ConexaoDB("pccdpppp", "pccdpppp", "j09eZSVo9ueLk2AmoeS9uCz3Q68Ky04h");
		
		Statement statement;
		
		ResultSet rs = null;
		
		try {
			
			String query = "select * from tb_produto;";
			
			statement = conn.createStatement();
			
			rs = statement.executeQuery(query);
			
			if(rs.getFetchSize() == 0) {
				System.out.println("\nNão há produtos cadastrados no banco de dados :(");
			} else {
				while(rs.next()) {
					System.out.printf("Id: %d - Nome: %s - Preço: %f - Quantidade: %d\n", rs.getString("id"), rs.getString("nome"), rs.getString("ra"), rs.getString("curso"));
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}
