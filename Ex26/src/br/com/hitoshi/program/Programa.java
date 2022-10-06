package br.com.hitoshi.program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.com.hitoshi.model.Cliente;
import br.com.hitoshi.model.Conta;
import br.com.hitoshi.service.ClienteService;
import br.com.hitoshi.service.ContaService;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);

		Random random = new Random();
		
		int id;
		
		int escolha;
		
		do {
			
			System.out.println("Bem-vindo ao sistema da Hitoshi's Bank!");
			System.out.println("\nO que gostaria de fazer?\n1 - Cadastrar um Cliente"
													   + "\n2 - Atualizar Cliente"
													   + "\n3 - Excluir Cliente"
													   + "\n4 - Listar Cliente"
													   + "\n5 - Sair");
			
			escolha = sc.nextInt();
			
			Cliente ct = new Cliente();
			
			Conta cc = new Conta();
			
			switch(escolha) {
				case 1:
					System.out.printf("\nPor favor, digite o nome do cliente:");
					String nomeCliente = sc.next();
					ct.setNome(nomeCliente);
					
					System.out.printf("\nAgora, digite o email do cliente:");
					String emailCliente = sc.next();
					ct.setEmail(emailCliente);
					
					System.out.printf("\nE sua idade:");
					int idadeCliente = sc.nextInt();
					ct.setIdade(idadeCliente);
					
					System.out.println("\nQual a sua agência");
					cc.setAgencia(sc.next());
					
					int randomAcc = random.nextInt(9999);
					cc.setNumero(randomAcc);
					
					ContaService.InserirConta(cc);
					ClienteService.InserirCliente(ct);
				
					System.in.read();
							
					break;
					
				case 2:
					
					
					
					System.in.read();
							
					break;
					
				case 3:
					
					System.in.read();
					
					break;
					
				case 4:
					
					System.in.read();
					
					break;
					
				case 5:
					
					
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
