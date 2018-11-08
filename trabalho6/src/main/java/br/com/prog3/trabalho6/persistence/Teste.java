package br.com.prog3.trabalho6.persistence;

import br.com.prog3.trabalho6.model.Aluno;

public class Teste {

	public static void main(String[] args) {
		AlunoDAOImp ad = new AlunoDAOImp();
		Aluno aluno = ad.findByMatricula(7841);
		if (aluno != null) {
			System.out.println(aluno.getNome()+"\n"+aluno.getMatricula()+"\n"+aluno.getRa());
		}

	}

}
