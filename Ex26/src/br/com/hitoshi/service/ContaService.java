package br.com.hitoshi.service;

import java.sql.ResultSet;

import br.com.hitoshi.dao.Dao;
import br.com.hitoshi.model.Cliente;
import br.com.hitoshi.model.Conta;

public class ContaService {
	
	public static void InserirConta(Conta cc) {
		String query = String.format("select max(id_conta) as id_conta from TB_CONTA");
		
		ResultSet rs = Dao.SelectCommand(query);
		 try {
			 int id = -1;
	         while(rs.next()){
	             id = rs.getInt("id_conta");
	         }
	                    
	         id++;
	         
			query = String.format("insert into TB_CONTA (id_conta, agencia, numero, saldo) values ('%s', '%s', '%s', '%s')", id, cc.getAgencia(), cc.getNumero(), 0);
			Dao.InsertUpdateDeleteCommand(query);
		 } catch (Exception e) { 
            System.out.println(e);
		}
	}
	
	public static void AtualizarConta(Conta cc, int id) {
        String query = String.format("update tb_conta set agencia = '%s' where id = %s", cc.getAgencia(), id);
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void ExcluirConta(int id) {
        String query = String.format("DELETE FROM tb_conta WHERE id_conta = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void ListarConta() {
		String query = "SELECT * FROM tb_conta";
	       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.print(rs.getString("id_conta")+" ");
                System.out.println(rs.getString("agência"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
	}
	
	public static void ListarConta(int id) {
		String query = String.format("SELECT * FROM tb_conta WHERE id_conta = %s", id);
	       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.println(rs.getString("agência"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
	}
}
