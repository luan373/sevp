package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.model.dao.AbstractNavigation;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "usuarioManterBean")
@ViewScoped
public class UsuarioManterBean extends AbstractNavigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4347964920110318709L;

	Usuario usuario = null;
	UsuarioBll usuarioBll = null;

	public UsuarioManterBean() {
		System.out.println("Construtor");
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		this.usuarioBll = new UsuarioBll();
		System.out.println(usuario);

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
		System.out.println("excluiuuuuu");

		return "/index";
	}

	public String addTituloPagina() {
		if (usuario.getIdUsuario() == 0) {
			return "Cadastrar Usuário";
		}
		return "Alterar Usuário";
	}

	public String editar(long idUsuario) {
		return this.navegar("formulario_usuario.xhtml?faces-redirect=trueidUsuario=" + idUsuario);
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
