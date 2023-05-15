package br.ufal.bookflix.model;

// usado no caso de ter múltiplas chaves
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprestar")
public class HistoricoEmprestimo implements Serializable{
	private static final long serialVersionUID = 5982911232143066021L;
	
	@Id
	private String data_emprestimo;
	private String data_devolucao;
	@Id
	@ManyToOne
	@JoinColumn(name="login_clienteFK", referencedColumnName="login")
	private Cliente cliente;
	@Id
	@ManyToOne
	@JoinColumn(name="codigo_emprestimoFK", referencedColumnName="codigo")
	private Emprestimo emprestimo;
	
	
	
	public HistoricoEmprestimo() {
		//Para o Hibernate
	}
	
	public HistoricoEmprestimo(String data_emprestimo, String data_devolucao) {
		super();
		this.data_emprestimo = data_emprestimo;
		this.data_devolucao = data_devolucao;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(String data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public String getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
		
		if(obj!=null  &&  obj instanceof HistoricoEmprestimo) {
			if(this.cliente!=null && ((HistoricoEmprestimo)obj).cliente!=null  &&  this.cliente.getLogin().equals(((HistoricoEmprestimo)obj).cliente.getLogin())) {
				if(this.emprestimo!=null && ((HistoricoEmprestimo)obj).emprestimo!=null  &&  this.emprestimo.getCodigo() == ((HistoricoEmprestimo)obj).emprestimo.getCodigo()) {
					if(this.data_emprestimo!=null && ((HistoricoEmprestimo)obj).data_emprestimo!=null  &&  this.data_emprestimo.equals(((HistoricoEmprestimo)obj).data_emprestimo)) {
						out = true;
					}
				}
			}
		}
		
		return out;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.cliente.hashCode() - this.emprestimo.hashCode() + this.data_emprestimo.hashCode();
	}
	
	
	@Override
	public String toString() {
		return this.getData_emprestimo()+ " --> " + this.emprestimo;
	}

}
