package br.ufal.bookflix.persistencia;

import java.util.List;

import br.ufal.bookflix.model.HistoricoEmprestimo;

public interface IDAOHistoricoEmprestimo {

	List<HistoricoEmprestimo> getHistoricoEmprestimos();

	void adicionarOuAlterarHistoricoEmprestimo(HistoricoEmprestimo he);

	void apagarHistoricoEmprestimo(HistoricoEmprestimo he);

}