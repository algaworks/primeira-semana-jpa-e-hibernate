package com.algaworks.compras.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.compras.model.Cidade;
import com.algaworks.compras.model.Estado;
import com.algaworks.compras.model.Fornecedor;
import com.algaworks.compras.repository.Cidades;
import com.algaworks.compras.repository.Estados;
import com.algaworks.compras.repository.Fornecedores;

@Named
@ViewScoped
public class CadastroFornecedoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private Estados estados;

	@Inject
	private Cidades cidades;

	private Fornecedor fornecedor;

	private Estado estado;

	private List<Estado> todosEstados;

	private List<Cidade> cidadesPorEstado;

	private List<Fornecedor> todosFornecedores;

	public void inicializar() {
		fornecedor = new Fornecedor();
		estado = null;
		todosFornecedores = fornecedores.todosComCidadeEstado();

		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosEstados = estados.todos();
		}
	}

	public void onEstadoChange() {
		cidadesPorEstado = null;
		if (estado != null) {
			cidadesPorEstado = cidades.porEstado(estado);
		}
	}

	public void cadastrar() {
		fornecedores.adicionar(fornecedor);
		inicializar();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidadesPorEstado() {
		return cidadesPorEstado;
	}

	public List<Estado> getTodosEstados() {
		return todosEstados;
	}

	public List<Fornecedor> getTodosFornecedores() {
		return todosFornecedores;
	}

}
