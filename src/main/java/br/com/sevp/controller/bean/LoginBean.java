package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.sevp.model.entity.Usuario;

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

	private static final String HOME_PAGE = "/";
	private static final String PAGE_AFTER_LOGOUT = HOME_PAGE;

	private static final String SESSION_USER_VARIABLE_NAME = "usuario";

	private String login;
	private String senha;
	private String mensagem;

	private boolean logado = false;
	
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
		HttpSession httpSession = request.getSession();
		
		extractRequestedUrlBeforeLogin();
		
		try {
			request.login(login, senha);
			setLogado(true);
			httpSession.setAttribute(SESSION_USER_VARIABLE_NAME, isLogado());
			externalContext.redirect("pages/index.xhtml");
		} catch (ServletException e) {
			e.getLocalizedMessage();
			setMensagem("Usuário ou senha incorretos");
		}
	}

	public void logout() throws IOException {
		setLogado(false);

		ExternalContext externalContext = externalContext();
		externalContext.invalidateSession();
		externalContext.redirect(externalContext.getRequestContextPath() + PAGE_AFTER_LOGOUT);
	}

	public Usuario getUsuario() {
		FacesContext context = facesContext();
		ExternalContext externalContext = context.getExternalContext();
		return (Usuario) externalContext.getSessionMap().get("usuario");

	}

	// Set Object in Session
	public void setSession(String nomeAtributo, String value) {

	}

	// Get Object in Session
	public String getSession(String nomeAtributo) {
		FacesContext context = facesContext();
		ExternalContext externalContext = context.getExternalContext();

		return (String) externalContext.getSessionMap().get(nomeAtributo);
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

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
