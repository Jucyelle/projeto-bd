package br.ufal.bookflix.persistencia;

import java.util.List;

import br.ufal.bookflix.model.Cliente;

public interface IDAOCliente {

	Cliente getCliente(String login);

	List<Cliente> getClientes();

	List<Cliente> getClientes(String filtroNome);

	void adicionarOuAlterarCliente(Cliente c);
	
	void apagarCliente(Cliente c);

}