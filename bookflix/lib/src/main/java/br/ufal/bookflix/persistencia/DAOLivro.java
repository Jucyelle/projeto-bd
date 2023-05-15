package br.ufal.bookflix.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufal.bookflix.hibernate.HibernateConfiguration;
import br.ufal.bookflix.model.Livro;

public class DAOLivro implements IDAOLivro {
	private Session session;
	
	public DAOLivro() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public Livro getLivro(int codigo) {
		Livro output = this.session.get(Livro.class, codigo);
		return output;
	}
	
	@Override
	public List<Livro> getLivros() {
		List<Livro> output = null;
		
		String hql = "FROM Livro l";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Livro>();
		
		return output;
	}
	
	@Override
	public List<Livro> getLivros(String filtroNome) {
		List<Livro> output = null;
		
		String hql = "FROM Livro l WHERE l.nome LIKE '%"+filtroNome+"%'";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Livro>();
		
		return output;
	}
	
	@Override
	public void adicionarOuAlterarLivro(Livro l) {
		Transaction t = this.session.beginTransaction();
		this.session.saveOrUpdate(l);
		t.commit();
	}
	
	@Override
	public void apagarLivro(Livro l) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(l);
		t.commit();
	}
}
