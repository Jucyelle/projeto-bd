package br.ufal.bookflix.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Fisico extends Emprestimo{
	
	public Fisico() {
		//Para o Hibernate
		super();
	}
	
	public Fisico(int codigo, double preco) {
		super(codigo, preco);
	}
	
	@Override
	public String toString() {
		return super.toString() + " [FISICO]";
	}

}
