package br.ufal.bookflix.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufal.bookflix.hibernate.HibernateConfiguration;
import br.ufal.bookflix.model.Emprestimo;

public class DAOEmprestimo implements IDAOEmprestimo {
	private Session session;
	
	public DAOEmprestimo() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public Emprestimo getEmprestimo(int codigo) {
		Emprestimo output = this.session.get(Emprestimo.class, codigo);
		return output;
	}
	
	@Override
	public List<Emprestimo> getEmprestimos() {
		List<Emprestimo> output = null;
		
		String hql = "FROM Emprestimo e";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<Emprestimo>();
		
		return output;
	}
	
	@Override
	public void adicionarOuAlterarEmprestimo(Emprestimo e) {
		Transaction t = this.session.beginTransaction();
		this.session.saveOrUpdate(e);
		t.commit();
	}
	
	@Override
	public void apagarEmprestimo(Emprestimo e) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(e);
		t.commit();
	}
}
