package br.com.sevp.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.sevp.controller.bll.LoginBll;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	/**
	 * A Classe LoginBean utiliza dados da classe Usuario, pois os campos para
	 * realizar o login são os mesmo desta classe.
	 */

	private LoginBll loginBll;
	private String login;
	private String senha;

	private String mensagem;

	public String validaLogin() {
		boolean validacao = loginBll.isSenhaCorreta(login, senha);
		if (!validacao) {
			setMensagem("Usuário ou senha incorretos");
			return getMensagem();
		}
		return "/index";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
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
