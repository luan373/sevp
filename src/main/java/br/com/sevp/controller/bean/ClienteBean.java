package br.com.sevp.controller.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sevp.controller.bll.ClienteBll;
import br.com.sevp.exception.SevpException;
import br.com.sevp.model.dao.AbstractNavigation;
import br.com.sevp.model.entity.Cliente;
import net.sf.json.JSONArray;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean extends AbstractNavigation implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5690656986029124994L;
	Cliente cliente = null;
	ClienteBll clienteBll = null;

	public ClienteBean() {
		if (this.cliente == null) {
			this.cliente = new Cliente();
		}
		this.clienteBll = new ClienteBll();

		String idEncodado = this.getParam("idCliente");

		if (idEncodado != null) {
			long idCliente = Long.parseLong(idEncodado);
			this.cliente = this.clienteBll.recuperar(idCliente);
		}
	}
	
	public void validaCliente() {
		try {
			if (cliente.getIdCliente() == 0) {
				this.clienteBll.inserir(cliente);
				getScriptsJsBean().executaScript("salvar();");
			} else {
				this.clienteBll.alterar(cliente);
				getScriptsJsBean().executaScript("salvar();");
			}
		} catch (SevpException e) {
			getScriptsJsBean().executaScript("MessagemErroToast('" + e.getMessage() + "');");
		} catch (Exception e) {
			getScriptsJsBean().executaScript("MessagemErroToastDefault('" + e.getMessage() + "');");
		}
	}

	public void excluiCliente() {
		this.clienteBll.excluir(cliente);
		getScriptsJsBean().executaScript("excluir();");
	}

	public String addTituloPagina() {
		if (cliente.getIdCliente() == 0) {
			return "Cadastrar Cliente";
		}
		return "Alterar Cliente";
	}
	
	/**
	 * Getters and Setters
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
