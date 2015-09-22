package com.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.compras.model.Fornecedor;

public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManagerFactory factory;
	
	@Inject
	private EntityManager manager;
	
	public void adicionar(Fornecedor fornecedor) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(fornecedor);
		manager.getTransaction().commit();
		manager.close();
	}

	public List<Fornecedor> todos() {
		return manager.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}

}
