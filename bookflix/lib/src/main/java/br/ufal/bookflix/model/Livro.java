package br.ufal.bookflix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livro")
public class Livro {
	@Id
	private int codigo;
	@Column(nullable = false)
	private String nome;
	@OneToMany(mappedBy="livro")
	private List<Emprestimo> emprestimos;
	
	
	public Livro() {
		//Para o Hibernate
	}
	
	public Livro(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
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
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.nome;
	}

}
