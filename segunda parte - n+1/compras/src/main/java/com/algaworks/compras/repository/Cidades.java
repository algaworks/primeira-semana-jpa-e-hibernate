package com.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.compras.model.Cidade;
import com.algaworks.compras.model.Estado;

public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManagerFactory factory;
	
	public List<Cidade> porEstado(Estado estado) {
		EntityManager manager = factory.createEntityManager();
		List<Cidade> cidadesPorEstado = manager.createQuery("from Cidade c where c.estado = :estado", Cidade.class)
										.setParameter("estado", estado)
										.getResultList();
		manager.close();
		return cidadesPorEstado;
	}

	public Cidade porCodigo(Long codigo) {
		EntityManager manager = factory.createEntityManager();
		Cidade cidade = manager.find(Cidade.class, codigo);
		manager.close();
		return cidade;
	}
	
}






