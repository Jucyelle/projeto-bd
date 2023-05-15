package br.ufal.bookflix.persistencia;

import java.util.List;

import br.ufal.bookflix.model.Livro;

public interface IDAOLivro {

	Livro getLivro(int codigo);

	List<Livro> getLivros();

	List<Livro> getLivros(String filtroNome);

	void adicionarOuAlterarLivro(Livro l);

	void apagarLivro(Livro l);

}