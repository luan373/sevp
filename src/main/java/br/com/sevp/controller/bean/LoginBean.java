package br.com.sevp.controller.bean;

import javax.faces.bean.ManagedBean;

import br.com.sevp.controller.bll.LoginBll;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "loginBean")
public class LoginBean {
	/**
	 * A Classe LoginBean utiliza dados da classe Usuario, pois os campos para
	 * realizar o login são os mesmo desta classe.
	 */

	private LoginBll loginBll;
	private Usuario usuario;
	private String mensagem;

	public String validaLogin() {
		boolean validacao = loginBll.isSenhaCorreta(usuario.getUsuario(), usuario.getSenha());
		if (!validacao) {
			setMensagem("Usuário ou senha incorretos");
			return getMensagem();
		}
		return "index";
	}

	public LoginBean() {
		this.loginBll = new LoginBll();
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
