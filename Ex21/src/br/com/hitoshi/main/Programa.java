package br.com.hitoshi.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hitoshi.models.Aluno;
import br.com.hitoshi.models.UsuarioDBOracle;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		
		UsuarioDBOracle db = new UsuarioDBOracle();
		
		int escolha;
		
		do {
			
			System.out.println("Bem-vindo ao sistema da Hitoshi's Academy!");
			System.out.println("\nO que gostaria de fazer?\n1 - Cadastrar Alunos\n2 - Listar Alunos\n3 - Sair");
			
			escolha = sc.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.println("\nBeleza, bora cadastrar um aluno!");
					System.out.println("\nMe informe o nome desse aluno, por gentileza:");
					String nomeAluno = sc.next();
					
					System.out.println("\nAgora me fala o seu R.A:");
					String raAluno = sc.next();
					
					System.out.println("\nE por fim, seu curso:");
					String cursoAluno = sc.next();
					
					int idAluno = listaAlunos.size();
					
					Aluno aluno = new Aluno(idAluno, nomeAluno, raAluno, cursoAluno);
					
					listaAlunos.add(aluno);
					
					db.InserirAlunoDB(aluno);
					
					System.out.println("\nSucesso no cadastro! Confira o banco :D");
					
					System.in.read();
							
					break;
					
				case 2:
					
					System.out.println("\nOkay. Lista dos Alunos Cadastrados:");
					
					db.ListarAlunoDB();
					
					
					System.out.println("\nAperte algum botão para prosseguir:");
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
