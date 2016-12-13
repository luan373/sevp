package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.sevp.controller.bll.ClienteBll;
import br.com.sevp.exception.SevpException;
import br.com.sevp.model.dao.AbstractNavigation;
import br.com.sevp.model.entity.Cidades;
import br.com.sevp.model.entity.Cliente;
import br.com.sevp.model.entity.Estados;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean extends AbstractNavigation implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5690656986029124994L;
	/**
	 * Classe cliente e negócio.
	 */
	Cliente cliente = null;
	ClienteBll clienteBll = null;

	/**
	 * Lista de UFs e cidades que serão populadas de acordo com a opção
	 * selecionada.
	 */
	List<Estados> listaUFs = null;
	List<Cidades> cidades = null;

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

	@PostConstruct
	public void init() {
		this.listaUFs = clienteBll.recuperarEstados();
	}

	public void changeEstado() {
		cidades = clienteBll.pesquisaCidades(cliente.getUf());
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
	 * Reload page
	 * @throws IOException
	 */
	public void reload() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
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

	public List<Estados> getListaUFs() {
		return listaUFs;
	}

	public void setListaUFs(List<Estados> listaUFs) {
		this.listaUFs = listaUFs;
	}

	public List<Cidades> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}

}
