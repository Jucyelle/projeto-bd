package br.ufal.bookflix.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	private String login;
	private String nome;
	@OneToMany(mappedBy = "cliente")
	private List<HistoricoEmprestimo> historico_emprestimos;
	
	public Cliente() {
		//Para o Hibernate
	}
	
	public Cliente(String login, String nome) {
		super();
		this.login = login;
		this.nome = nome;
	}

	public List<HistoricoEmprestimo> getHistoricoEmprestimos() {
		return historico_emprestimos;
	}

	public void setHistoricoEmprestimos(List<HistoricoEmprestimo> historico_emprestimos) {
		this.historico_emprestimos = historico_emprestimos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.login + " - " + this.nome;
	}

}