package br.ufal.bookflix.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufal.bookflix.hibernate.HibernateConfiguration;
import br.ufal.bookflix.model.Idioma;

public class DAOIdioma implements IDAOIdioma {
	private Session session;
	
	public DAOIdioma() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public Idioma getIdioma(int codigo) {
		Idioma output = this.session.get(Idioma.class, codigo);
		return output;
	}
	
	@Override
	public List<Idioma> getIdiomas() {
		List<Idioma> output = null;
		
		String hql = "FROM Idioma i";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Idioma>();
		
		return output;
	}
	
	@Override
	public List<Idioma> getIdiomas(String filtroNome) {
		List<Idioma> output = null;
		
		String hql = "FROM Idioma i WHERE i.nome LIKE '%"+filtroNome+"%'";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Idioma>();
		
		return output;
	}
	
	@Override
	public void adicionarOuAlterarIdioma(Idioma i) {
		Transaction t = this.session.beginTransaction();
		this.session.saveOrUpdate(i);
		t.commit();
	}
	
	@Override
	public void apagarIdioma(Idioma i) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(i);
		t.commit();
	}
}
