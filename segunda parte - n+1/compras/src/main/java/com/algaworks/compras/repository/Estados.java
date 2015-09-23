package com.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.compras.model.Estado;

public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManagerFactory factory;
	
	public List<Estado> todos() {
		EntityManager manager = factory.createEntityManager();
		List<Estado> todosEstados = manager.createQuery("from Estado order by nome"
				, Estado.class).getResultList();
		manager.close();
		
		return todosEstados;
	}

	public Estado porCodigo(Long codigo) {
		EntityManager manager = factory.createEntityManager();
		Estado estado = manager.find(Estado.class, codigo);
		manager.close();
		return estado;
	}

}







