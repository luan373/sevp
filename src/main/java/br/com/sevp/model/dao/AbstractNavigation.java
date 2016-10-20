package br.com.sevp.model.dao;

import javax.faces.context.FacesContext;

public abstract class AbstractNavigation {

	protected String recuperarQueryString(String parametro) {
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parametro);
		return value;
	}

	protected String navegar(String url) {
		return url;
	}

}
