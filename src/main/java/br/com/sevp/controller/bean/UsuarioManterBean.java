package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.excpetion.SevpException;
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

	public void validaUsuario() {

		try {
			if (usuario.getIdUsuario() == 0) {
				this.usuarioBll.inserir(usuario);
				getScriptsJsBean().executaScript("salvar();");
				// js();
			} else {
				this.usuarioBll.alterar(usuario);
				getScriptsJsBean().executaScript("salvar();");
			}
		} catch (SevpException e) {
			// TODO Auto-generated catch block
			getScriptsJsBean().executaScript("MessagemErroToast('" + e.getMessage() + "');");
		} catch (Exception e) {
			getScriptsJsBean().executaScript("MessagemErroToastDefault('" + e.getMessage() + "');");
		}
	}

	public void excluiUsuario() {
		this.usuarioBll.excluir(usuario);
		getScriptsJsBean().executaScript("excluir();");
	}

	public String addTituloPagina() {
		if (usuario.getIdUsuario() == 0) {
			return "Cadastrar Usuário";
		}
		return "Alterar Usuário";
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
