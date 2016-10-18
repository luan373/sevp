package br.com.sevp.controller.bean;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.script.ScriptException;

import br.com.sevp.model.dao.AbstractJs;
import br.com.sevp.util.JavaScriptRunner;

@ManagedBean
@ViewScoped
public class TesteBean extends AbstractJs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String aviso = "Ola";

	JavaScriptRunner javaScriptRunner = new JavaScriptRunner();

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
		FacesContext context = FacesContext.getCurrentInstance();
		javaScriptRunner.runScript(context, script);
		
		return "";
	}

	public String alert() {
		this.aviso = "submit";
		this.getScriptsJsBean().Alert("funcionando!" + new Date());
		return "";
	}
}
