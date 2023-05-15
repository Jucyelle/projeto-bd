package br.ufal.bookflix.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Digital extends Emprestimo{

	public Digital() {
		//Para o Hibernate
		super();
	}
	
	public Digital(int codigo, double preco) {
		super(codigo, preco);
	}
	
	@Override
	public String toString() {
		return super.toString() + " [DIGITAL]";
	}

}
