package br.ufal.bookflix.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufal.bookflix.hibernate.HibernateConfiguration;
import br.ufal.bookflix.model.HistoricoEmprestimo;

public class DAOHistoricoEmprestimo implements IDAOHistoricoEmprestimo {
	private Session session;
	
	public DAOHistoricoEmprestimo() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public List<HistoricoEmprestimo> getHistoricoEmprestimos() {
		List<HistoricoEmprestimo> output = null;
		
		String hql = "FROM HistoricoEmprestimo he";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		
		if(output == null)
			output = new ArrayList<HistoricoEmprestimo>();
		
		return output;
	}
	
	@Override
	public void adicionarOuAlterarHistoricoEmprestimo(HistoricoEmprestimo he) {
		Transaction t = this.session.beginTransaction();
		this.session.saveOrUpdate(he);
		t.commit();
	}
	
	@Override
	public void apagarHistoricoEmprestimo(HistoricoEmprestimo he) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(he);
		t.commit();
	}
}
