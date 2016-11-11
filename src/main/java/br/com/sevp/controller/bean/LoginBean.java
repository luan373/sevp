package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.sevp.controller.bll.LoginBll;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {
	/**
	 * serialVersionUID
	 */

	private static final long serialVersionUID = -4821815470767329667L;
	/**
	 * A Classe LoginBean utiliza dados da classe Usuario, pois os campos para
	 * realizar o login são os mesmo desta classe.
	 */

	private static final String HOME_PAGE = "/";
	private static final String PAGE_AFTER_LOGOUT = HOME_PAGE;

	private static final String SESSION_USER_VARIABLE_NAME = "usuario";

	private LoginBll loginBll;
	private String login;
	private String senha;

	private String urlSeguinte;
	private String mensagem;

	@PostConstruct
	public void init() {
		this.urlSeguinte = extractRequestedUrlBeforeLogin();
	}

	private String extractRequestedUrlBeforeLogin() {
		ExternalContext externalContext = externalContext();
		String requestedUrl = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
		if (requestedUrl == null) {
			return externalContext.getRequestContextPath() + HOME_PAGE;
		}
		String queryString = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);
		return requestedUrl + (queryString == null ? "" : "?" + queryString);
	}

	private ExternalContext externalContext() {
		return facesContext().getExternalContext();
	}

	private FacesContext facesContext() {
		return FacesContext.getCurrentInstance();
	}

	public void login() throws IOException, NamingException, ClassNotFoundException {
		ExternalContext externalContext = externalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		try {
			request.login(login, senha);
			externalContext.getSessionMap().put(SESSION_USER_VARIABLE_NAME, new Usuario(login));
			externalContext.redirect(urlSeguinte + "pages/index.xhtml");
		} catch (ServletException e) {
			String loginErrorMessage = e.getLocalizedMessage();
			setMensagem("Usuário ou senha incorretos");
		}
	}

	public void logout() throws IOException {
		ExternalContext externalContext = externalContext();
		externalContext.invalidateSession();
		externalContext.redirect(externalContext.getRequestContextPath() + PAGE_AFTER_LOGOUT);
	}

	public Usuario getUsuario() {
		FacesContext context = facesContext();
		ExternalContext externalContext = context.getExternalContext();
		return (Usuario) externalContext.getSessionMap().get("user");
	}

	public boolean isUsuarioLogado() {
		return getUsuario() != null;
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
