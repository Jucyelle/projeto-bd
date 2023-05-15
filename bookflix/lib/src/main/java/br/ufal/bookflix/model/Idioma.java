package br.ufal.bookflix.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="idioma")
public class Idioma{
	@Id
	private int codigo;
	private String nome;
	
	@ManyToMany(mappedBy="edicoes")
	private List<Emprestimo> emprestimosEdicao;
	
	public Idioma() {
		//Para o Hibernate
	}
	
	public Idioma(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.emprestimosEdicao = new ArrayList<Emprestimo>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Emprestimo> getEmprestimosEdicao() {
		return emprestimosEdicao;
	}

	public void setEmprestimosEdicao(List<Emprestimo> emprestimosEdicao) {
		this.emprestimosEdicao = emprestimosEdicao;
	}

	@Override
	public String toString() {
		return this.codigo + " - " + this.nome;
	}

}
