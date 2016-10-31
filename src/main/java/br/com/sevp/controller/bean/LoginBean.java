package br.com.sevp.controller.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import br.com.sevp.controller.bll.LoginBll;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4821815470767329667L;
	/**
	 * A Classe LoginBean utiliza dados da classe Usuario, pois os campos para
	 * realizar o login são os mesmo desta classe.
	 */

	private LoginBll loginBll;
	private String login;
	private String senha;
	private Boolean logado;

	private String mensagem;

	public String validaLogin() {
		boolean validacao = loginBll.isSenhaCorreta(login, senha);
		if (!validacao) {
			setMensagem("Usuário ou senha incorretos");
			return getMensagem();
		}

		setLogado(true);
		return "/index";
	}

	public String logout() {
		HttpSession session = br.com.sevp.util.Util.getSession();
		session.invalidate();

		setLogado(false);

		return "/login?faces-redirect=true";
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public LoginBean() {
		this.loginBll = new LoginBll();
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
