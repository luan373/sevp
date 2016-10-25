package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.model.dao.AbstractNavigation;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "usuarioManterBean")
@RequestScoped
public class UsuarioManterBean extends AbstractNavigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4347964920110318709L;

	@PostConstruct
	public void init() {

	}

	Usuario usuario = null;
	UsuarioBll usuarioBll = null;

	public UsuarioManterBean() throws Exception {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		this.usuarioBll = new UsuarioBll();

		String idEncodado = this.getParam("idUsuario");

		if (idEncodado != null) {
			long idUsuario = Long.parseLong(idEncodado);
			this.usuario = this.usuarioBll.recuperar(idUsuario);
		}
	}

	public String validaUsuario() {
		if (usuario.getIdUsuario() == 0) {
			this.usuarioBll.inserir(usuario);
		} else {
			this.usuarioBll.alterar(usuario);
		}

		return "/index";
	}

	public String excluiUsuario() {
		this.usuarioBll.excluir(usuario);
		return "/index";
	}

	public String addTituloPagina() {
		if (usuario.getIdUsuario() == 0) {
			return "Cadastrar Usu�rio";
		}
		return "Alterar Usu�rio";
	}

	public Usuario recuperaUsuario(Long idUsuario) {
		return usuario;

	}

	public String direcionaPagina(String local) throws IOException {
		return local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
