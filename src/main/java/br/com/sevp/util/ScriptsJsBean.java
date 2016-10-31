package br.com.sevp.util;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "scriptsJsBean")
@ViewScoped
public class ScriptsJsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5052829852963220017L;

	private String script = "";

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public void ConsoleLog(String mensagem) {
		script = "console.log('" + mensagem + "');";
	}

	public void Alert(String mensagem) {
		script = "alert('" + mensagem + "');";
	}

	public void RemoveScript() {
		script = "";
	}

	public void executaScript(String script) {
		this.script = "$(document).ready(function(){" + script + "});";
	}

}
