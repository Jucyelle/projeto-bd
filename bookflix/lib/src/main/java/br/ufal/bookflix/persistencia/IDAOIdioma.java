package br.ufal.bookflix.persistencia;

import java.util.List;

import br.ufal.bookflix.model.Idioma;

public interface IDAOIdioma {

	Idioma getIdioma(int codigo);

	List<Idioma> getIdiomas();

	List<Idioma> getIdiomas(String filtroNome);

	void adicionarOuAlterarIdioma(Idioma i);

	void apagarIdioma(Idioma i);

}