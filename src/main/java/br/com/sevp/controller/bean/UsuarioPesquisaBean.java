package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "usuarioPesquisaBean")
@ViewScoped
public class UsuarioPesquisaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7959138682849706510L;
	
	Usuario usuario = null;
	UsuarioBll usuarioBll = null;

	List<Usuario> lista = null;

	public void pesquisaUsuario() {
		lista = usuarioBll.pesquisar(usuario);
	}

	public UsuarioPesquisaBean() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		
		this.usuarioBll = new UsuarioBll();
		this.lista = new ArrayList<Usuario>();
	}

	public String direcionaPagina(String local) throws IOException {
		mataSessao();

		return local;
	}

	private void mataSessao() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioPesquisaBean", null);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
}
