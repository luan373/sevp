package br.com.sevp.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static boolean getLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return Boolean.parseBoolean((String) session.getAttribute("islogin"));
	}

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null) {
			return (String) session.getAttribute("userid");
		} else
			return null;
	}
}