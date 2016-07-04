package br.com.sevp.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sevp.controller.bll.LoginBll;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {
	/**
	 * A Classe LoginBean utiliza dados da classe Usuario, pois os campos para
	 * realizar o login são os mesmo desta classe.
	 */

	private LoginBll loginBll;
	private Usuario usuario;

	public LoginBean() {
		this.loginBll = new LoginBll();
		this.usuario = new Usuario();
	}

	

	public String validaLogin() {
		boolean validacao = loginBll.isSenhaCorreta(usuario.getUsuario(), usuario.getSenha());
		if (!validacao) {
			return "Usário ou senha incorretos";
		}
		return "index";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
