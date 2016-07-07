package br.com.sevp.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.model.entity.Usuario;

@ViewScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711950941720495714L;
	Usuario usuario = null;
	UsuarioBll usuarioBll = null;

	List<Usuario> lista = null;

	public String cadastraUsuario() {
		this.usuarioBll.inserir(usuario);
		return "/index";
	}

	public void pesquisaUsuario() {
		lista = usuarioBll.pesquisar(usuario);
	}

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarioBll = new UsuarioBll();
		this.lista = new ArrayList<Usuario>();
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
