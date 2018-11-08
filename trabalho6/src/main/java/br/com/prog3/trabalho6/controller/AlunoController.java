package br.com.prog3.trabalho6.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prog3.trabalho6.model.Aluno;
import br.com.prog3.trabalho6.persistence.AlunoDAOImp;



@ManagedBean
@SessionScoped
public class AlunoController {
	private Integer matricula;
	private String nome;
	private String ra;
	private Aluno aluno;
	private String mensagem;

	public String limpaController(Integer face){
		this.aluno=new Aluno();
		this.matricula=null;
		this.mensagem=new String();
		this.ra=new String();
		this.nome=new String();
		if(face == 1)
		return "index";
		if(face == 2)
	    return "inserirAluno";
		if(face == 3)
		return "listaAlunos";	
				
		return "buscarAluno";
	}
	public void addAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.save(aluno));
		this.aluno = new Aluno();
	}
	
	public String editaAluno(Aluno aluno){
		this.aluno=aluno;
		this.mensagem=new String();
		return "alterarAluno.xhtml";
	}

	public void editAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(this.aluno.getMatricula());
		aluno.setNome(this.aluno.getNome());
		aluno.setRa(this.aluno.getRa());
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.update(aluno));
		this.aluno=new Aluno();
	}

	public void deleteAluno(Aluno aluno) {
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.delete(aluno.getMatricula()));
	}

	public List<Aluno> getAlunos() {
		AlunoDAOImp ad = new AlunoDAOImp();
		return ad.list();
	}

	public String findAluno() {
		AlunoDAOImp ad = new AlunoDAOImp();
		this.aluno=ad.findByMatricula(matricula);
		return "buscarAluno.xhtml";
		
	}
	

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
