package br.ufal.bookflix.principal;

import java.util.List;
import java.util.ArrayList;

import br.ufal.bookflix.model.Cliente;
import br.ufal.bookflix.model.Idioma;
import br.ufal.bookflix.model.Livro;
import br.ufal.bookflix.model.Emprestimo;
import br.ufal.bookflix.model.Fisico;
import br.ufal.bookflix.model.HistoricoEmprestimo;

import br.ufal.bookflix.persistencia.DAOCliente;
import br.ufal.bookflix.persistencia.DAOIdioma;
import br.ufal.bookflix.persistencia.DAOLivro;
import br.ufal.bookflix.persistencia.DAOEmprestimo;
import br.ufal.bookflix.persistencia.DAOHistoricoEmprestimo;

import br.ufal.bookflix.persistencia.IDAOCliente;
import br.ufal.bookflix.persistencia.IDAOIdioma;
import br.ufal.bookflix.persistencia.IDAOLivro;
import br.ufal.bookflix.persistencia.IDAOEmprestimo;
import br.ufal.bookflix.persistencia.IDAOHistoricoEmprestimo;

public class Main {
	public static void main(String[] args) {
		//DEMONSTRAÇÃO DO CRUD
		
		//criação de clientes
		IDAOCliente daoCliente = new DAOCliente();
		
		Cliente cAna = new Cliente("ana", "Ana Maria");
		daoCliente.adicionarOuAlterarCliente(cAna);
		
		Cliente cBruno = new Cliente("bruno", "Bruno Vieira");
		daoCliente.adicionarOuAlterarCliente(cBruno);
		
		Cliente cCarlos = new Cliente("carlos", "Carlos Marcos");
		daoCliente.adicionarOuAlterarCliente(cCarlos);
		
		//obtendo clientes
		System.out.println("--- CLIENTES ---");
		System.out.println(daoCliente.getClientes());
		
		//atualizando um cliente (Ana Maria)
		cAna.setNome("Ana Maria Ferreira");
		daoCliente.adicionarOuAlterarCliente(cAna);
		
		System.out.println("--- ATUALIZANDO CLIENTE ANA ---");
		System.out.println(daoCliente.getCliente("ana"));
		
		//deletando um cliente (Carlos Marcos)
		daoCliente.apagarCliente(cCarlos);
		System.out.println("--- APAGANDO O CLIENTE CARLOS ---");
		System.out.println(daoCliente.getClientes());
		
		//CRIANDO DADOS PARA SE RELACIONAREM
		
		//criando idiomas
		IDAOIdioma daoIdioma = new DAOIdioma();
		
		Idioma iPT = new Idioma(1, "Português");
		Idioma iEN = new Idioma(2, "Inglês");
		daoIdioma.adicionarOuAlterarIdioma(iPT);
		daoIdioma.adicionarOuAlterarIdioma(iEN);
		
		//criando livros
		IDAOLivro daoLivro = new DAOLivro();
		
		Livro l1 = new Livro(1, "Battle Royale");
		Livro l2 = new Livro(2, "Drácula");
		daoLivro.adicionarOuAlterarLivro(l1);
		daoLivro.adicionarOuAlterarLivro(l2);
		
		//criando um emprestimo fisico disponivel
		IDAOEmprestimo daoEmprestimo = new DAOEmprestimo();
		
		Emprestimo e1 = new Fisico();
		e1.setCodigo(1);
		e1.setPreco(10);
		e1.setLivro(l1);
		
		List listaIdiomas = new ArrayList();
		listaIdiomas.add(iPT);
		listaIdiomas.add(iEN);
		e1.setEdicoes(listaIdiomas);
		
		daoEmprestimo.adicionarOuAlterarEmprestimo(e1);
		
		//associando os dados
		IDAOHistoricoEmprestimo daoHistoricoEmprestimo = new DAOHistoricoEmprestimo();
		
		HistoricoEmprestimo h1 = new HistoricoEmprestimo();
		
		h1.setData_emprestimo("15-05-2023");
		h1.setData_devolucao("15-06-2023");
		h1.setCliente(cBruno);
		h1.setEmprestimo(e1);
		
		daoHistoricoEmprestimo.adicionarOuAlterarHistoricoEmprestimo(h1);
		
		List listaHistoricoEmprestimos = new ArrayList();
		listaHistoricoEmprestimos.add(h1);
		cBruno.setHistoricoEmprestimos(listaHistoricoEmprestimos);
		e1.setHistorico_emprestimos(listaHistoricoEmprestimos);
		
		//printando os emprestimos realizados pelo Bruno
		System.out.println("--- EMPRESTIMOS DE BRUNO ---");
		
		for(HistoricoEmprestimo he : cBruno.getHistoricoEmprestimos()) {
			System.out.println(he);
			System.out.println(he.getEmprestimo());
			
			System.out.println("Edições disponíveis para o livro:");
			for(Idioma i : he.getEmprestimo().getEdicoes()) {
				System.out.println(i);
			}	
		}
	}
}
