package br.com.sevp.controller.bll;

import java.util.List;

import br.com.sevp.exception.SevpException;
import br.com.sevp.model.dao.CidadesDao;
import br.com.sevp.model.dao.ClienteDao;
import br.com.sevp.model.dao.EstadosDao;
import br.com.sevp.model.entity.Cidades;
import br.com.sevp.model.entity.Cliente;
import br.com.sevp.model.entity.Estados;

public class ClienteBll {
	ClienteDao clienteDao = null;
	EstadosDao estadosDao = null;
	CidadesDao cidadesDao = null;

	public ClienteBll() {
		this.clienteDao = new ClienteDao();
		this.estadosDao = new EstadosDao();
		this.cidadesDao = new CidadesDao();
	}

	public void inserir(Cliente cliente) throws SevpException {
		this.clienteDao.inserir(cliente);
	}

	public void alterar(Cliente cliente) throws SevpException {
		this.clienteDao.alterar(cliente);
	}

	public void excluir(Cliente cliente) {
		this.clienteDao.excluir(cliente);
	}

	public Cliente recuperar(long idCliente) {
		return this.clienteDao.recuperar(idCliente);
	}

	public List<Cliente> pesquisar(Cliente cliente) {
		List<Cliente> clientes = this.clienteDao.pesquisar(cliente);

		return clientes;
	}

	public List<Estados> recuperarEstados() {
		List<Estados> listaEstados = estadosDao.listar();

		return listaEstados;
	}

	public List<Cidades> pesquisaCidades(String uf) {
		Estados estados = estadosDao.recuperar(uf);

		List<Cidades> listaCidades = cidadesDao.pesquisar(estados.getId());
		return listaCidades;
	}
}
