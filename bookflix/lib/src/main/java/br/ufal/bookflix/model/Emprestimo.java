package br.ufal.bookflix.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="emprestimo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Emprestimo {
	@Id
	private int codigo;
	private double preco;
	@OneToMany(mappedBy="emprestimo")
	private List<HistoricoEmprestimo> historico_emprestimos;
	@ManyToMany
	@JoinTable(
		name="possuir_edicao", 
		joinColumns = {
			@JoinColumn(name="codigo_emprestimoFK", referencedColumnName="codigo")
		},
		inverseJoinColumns = {
			@JoinColumn(name="codigo_idiomaFK", referencedColumnName="codigo")
		}
	)
	private List<Idioma> edicoes;
	@ManyToOne
	@JoinColumn(name="codigo_livroFK", referencedColumnName="codigo")
	private Livro livro;
	
	
	public Emprestimo() {
		//Para o Hibernate
	}
	
	public Emprestimo(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}
	

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Idioma> getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(List<Idioma> idiomas) {
		this.edicoes = idiomas;
	}

	public List<HistoricoEmprestimo> getHistorico_emprestimos() {
		return historico_emprestimos;
	}

	public void setHistorico_emprestimos(List<HistoricoEmprestimo> historico_emprestimos) {
		this.historico_emprestimos = historico_emprestimos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return this.livro + "(R$ " + this.preco + ")";
	}

}
