package br.com.hitoshi.program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hitoshi.models.Produto;
import br.com.hitoshi.models.ProdutoDB;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		
		ProdutoDB db = new ProdutoDB();
		
		int escolha;
		
		do {
			
			System.out.println("Bem-vindo ao sistema da Hitoshi's Corporation!");
			System.out.println("\nO que gostaria de fazer?\n1 - Cadastrar Produtos\n2 - Listar Produtos\n3 - Sair");
			
			escolha = sc.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.println("\nBeleza, bora cadastrar um produtos!");
					System.out.println("\nMe informe o nome desse produto, por gentileza:");
					String nomeProduto = sc.next();
					
					System.out.println("\nAgora me fala o preço:");
					double precoProduto = sc.nextDouble();
					
					System.out.println("\nE por fim, sua quantidade:");
					int qtdProduto = sc.nextInt();
					
					int idProduto = listaProdutos.size();
					
					String idAlunoParse = String.valueOf(idProduto);
					
					Produto produto = new Produto(idProduto, nomeProduto, precoProduto, qtdProduto);
					
					listaProdutos.add(produto);
					
					db.InserirProdutoDB(produto);
					
					System.out.println("\nSucesso no cadastro! Confira o banco :D");
					
					System.in.read();
							
					break;
					
				case 2:
					
					System.out.println("\nOkay. Lista dos Produtos Cadastrados:");
					
					db.ListarProdutoDB();
					
					System.in.read();
					
					break;
					
				case 3:
					System.out.println("\nCerto. Até mais!");
					
					escolha = 0;
					
					System.in.read();
					
					break;
					
				default:
					
					System.out.println("\nEscolha inválida.");
					
					System.in.read();
					
					break;
			}
			
		} while(escolha != 0);
		
		System.out.println("\nSistema finalizado!");

	}

}
