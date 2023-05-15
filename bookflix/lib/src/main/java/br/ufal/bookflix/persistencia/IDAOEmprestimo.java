package br.ufal.bookflix.persistencia;

import java.util.List;

import br.ufal.bookflix.model.Emprestimo;

public interface IDAOEmprestimo {

	Emprestimo getEmprestimo(int codigo);

	List<Emprestimo> getEmprestimos();

	void adicionarOuAlterarEmprestimo(Emprestimo e);

	void apagarEmprestimo(Emprestimo e);

}