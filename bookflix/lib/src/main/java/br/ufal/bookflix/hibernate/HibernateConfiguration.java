package br.ufal.bookflix.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.ufal.bookflix.model.Digital;
import br.ufal.bookflix.model.Cliente;
import br.ufal.bookflix.model.Fisico;
import br.ufal.bookflix.model.Livro;
import br.ufal.bookflix.model.Idioma;
import br.ufal.bookflix.model.HistoricoEmprestimo;
import br.ufal.bookflix.model.Emprestimo;


public class HibernateConfiguration {

	private Configuration cfg;
	private SessionFactory factory;

	public HibernateConfiguration(){
		cfg = new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/bookflix");
		cfg.setProperty("hibernate.connection.username", "root"); 
		cfg.setProperty("hibernate.connection.password", "servidorprincipal");

		//opcionais - INICIO
		cfg.setProperty("hibernate.connection.characterEncoding", "utf8");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.connection.autoReconnect", "true");
		cfg.setProperty("hibernate.show_sql", "false");
        //opcionais - FIM

		//classes persistentes - INICIO
		cfg.addAnnotatedClass(Cliente.class);
		cfg.addAnnotatedClass(Livro.class);
		cfg.addAnnotatedClass(Idioma.class);
		cfg.addAnnotatedClass(Emprestimo.class);
		cfg.addAnnotatedClass(Fisico.class);
		cfg.addAnnotatedClass(Digital.class);
		cfg.addAnnotatedClass(HistoricoEmprestimo.class);
		//classes persistentes - FIM
		
	    ServiceRegistry serviceRegistry = 
      new StandardServiceRegistryBuilder().applySettings(this.cfg.getProperties()).build();
	    factory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	
	public Session getSession() {
        //Retorna a sessão aberta
    	return this.factory.openSession();
    }
    
    public Configuration getConfiguration() {
        //Retorna a configuracao
    	return this.cfg;
    }
}
