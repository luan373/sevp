package br.com.sevp.controller.bll;

import java.util.List;

import br.com.sevp.exception.SevpException;
import br.com.sevp.model.dao.ClienteDao;
import br.com.sevp.model.entity.Cliente;

public class ClienteBll {
	ClienteDao clienteDao = null;

	public ClienteBll() {
		this.clienteDao = new ClienteDao();
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
}
