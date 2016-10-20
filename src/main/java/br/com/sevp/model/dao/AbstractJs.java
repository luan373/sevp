package br.com.sevp.model.dao;

import javax.faces.bean.ManagedProperty;

import br.com.sevp.util.ScriptsJsBean;

public abstract class AbstractJs {
	
	@ManagedProperty(value = "#{scriptsJsBean}")
	private ScriptsJsBean scriptsJsBean;

	public ScriptsJsBean getScriptsJsBean() {
		return scriptsJsBean;
	}

	public void setScriptsJsBean(ScriptsJsBean scriptsJsBean) {
		this.scriptsJsBean = scriptsJsBean;
	}
}
