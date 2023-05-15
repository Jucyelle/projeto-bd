package br.ufal.bookflix.persistencia;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufal.bookflix.hibernate.HibernateConfiguration;
import br.ufal.bookflix.model.Cliente;

public class DAOCliente implements IDAOCliente {
	private Session session;
	
	public DAOCliente() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public Cliente getCliente(String login) {
		Cliente output = this.session.get(Cliente.class, login);
		return output;
	}
	
	@Override
	public List<Cliente> getClientes() {
		List<Cliente> output = null;
		
		String hql = "FROM Cliente c";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Cliente>();
		
		return output;
	}
	
	@Override
	public List<Cliente> getClientes(String filtroNome) {
		List<Cliente> output = null;
		
		String hql = "FROM Cliente c WHERE c.nome LIKE '%"+filtroNome+"%'";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Cliente>();
		
		return output;
	}
	
	@Override
	public void adicionarOuAlterarCliente(Cliente c) {
		Transaction t = this.session.beginTransaction();
		this.session.saveOrUpdate(c);
		t.commit();
	}
	
	@Override
	public void apagarCliente(Cliente c) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(c);
		t.commit();
	}
}
