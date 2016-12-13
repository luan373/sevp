package br.com.sevp.controller.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.script.ScriptException;

import br.com.sevp.model.dao.AbstractJs;

@ManagedBean
@ViewScoped
public class TesteBean extends AbstractJs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String aviso = "Ola";

	public String getAviso() {
		return aviso;
	}

	String script = "alert('peek-a-boo')";

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String submit() {
		// this.getScriptsJsBean().RemoveScript();
		this.aviso = "submit";
		this.getScriptsJsBean().ConsoleLog("rodou!" + new Date());

		return "";
	}

	public String executa() throws ScriptException, NoSuchMethodException, IOException {
		this.aviso = "executa";		
		
		return "";
	}

	public String alert() {
		this.aviso = "submit";
		this.getScriptsJsBean().Alert("funcionando!" + new Date());
		return "";
	}
}
