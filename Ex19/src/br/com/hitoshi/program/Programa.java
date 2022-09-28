package br.com.hitoshi.program;

import br.com.hitoshi.models.Aluno;
import br.com.hitoshi.models.AlunoDB;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlunoDB db = new AlunoDB();

		Aluno al = new Aluno("1", "Gabriel", "98775", "ADM");
		Aluno al2 = new Aluno("2", "Elaine", "98445", "Cybersecurity");
		
		db.InserirAlunoDB(al);
		db.InserirAlunoDB(al2);
		
		db.ListarAlunosDB();
		
		
		
	}

}
