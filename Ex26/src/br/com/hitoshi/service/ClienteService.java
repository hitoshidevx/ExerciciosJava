package br.com.hitoshi.service;

import java.sql.ResultSet;

import br.com.hitoshi.dao.Dao;
import br.com.hitoshi.model.Cliente;

public class ClienteService {

	public static void InserirCliente(Cliente ct) {
		String query = String.format("select max(id) as id from TB_CLIENTE");
		
		ResultSet rs = Dao.SelectCommand(query);
		
		 try {
			 int id = -1;
	         while(rs.next()){
	             id = rs.getInt("id");
	         }
	                    
		    id++;
			
			query = String.format("insert into TB_CLIENTE (id, nome, idade, email, id_conta) values (%s, '%s', %s, '%s', %s)", id, ct.getNome(), ct.getIdade(), ct.getEmail(), id);
			Dao.InsertUpdateDeleteCommand(query);
		
		 } catch (Exception e) { 
	            System.out.println(e);
		}
	}
	
	public static void AtualizarCliente(Cliente ct) {
        String query = String.format("UPDATE tb_cliente SET nome='%s',email='%s',idade =%s WHERE id = %s", ct.getNome(), ct.getEmail(), ct.getIdade(), ct.getId());
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void ExcluirCliente(int id) {
        String query = String.format("DELETE FROM tb_cliente WHERE id = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void ListarCliente() {
		String query = "SELECT * FROM tb_cliente";
	       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	System.out.printf("Id: '%s' - Nome: '%s' - Idade: '%s' - Email: '%s' \n", rs.getString("id") + " ", rs.getString("nome"), rs.getString("idade"), rs.getString("email"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
	}
	
	public static void ListarCliente(int id) {
		String query = String.format("SELECT * FROM tb_cliente WHERE id = %s", id);
	       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	System.out.printf("Id: '%s' - Nome: '%s' - Idade: '%s' - Email: '%s' \n", rs.getString("id") + " ", rs.getString("nome"), rs.getString("idade"), rs.getString("email"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
	}
	
}
