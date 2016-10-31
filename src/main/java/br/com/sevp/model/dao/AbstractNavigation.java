package br.com.sevp.model.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;

import br.com.sevp.util.Cifrador;
import br.com.sevp.util.UtilCriptografia;

public abstract class AbstractNavigation extends AbstractJs {

	protected Cifrador cifrador = null;

	public AbstractNavigation() {

	}

	protected String recuperarQueryString(String parametro) {
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parametro);
		return value;
	}

	protected String navegar(String url) {
		return url;
	}

	protected String navegarParametro(String url, String nomeParametro, String valorParametro) {
		String urlCriptografada = null;
		try {
			String id = String.valueOf(valorParametro);
			String idCriptografado = UtilCriptografia.getInstancia().encripta(id);
			String idEncode = URLEncoder.encode(idCriptografado, "UTF-8");
			urlCriptografada = url + ".xhtml?faces-redirect=true" + nomeParametro + "=" + idEncode;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.navegar(urlCriptografada);
	}

	public String getParam(String param) {

		String projectParam = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
			projectParam = paramMap.get(param);

			// Se estiver nulo ele pula a encodação por não ser necessária.
			if (projectParam == null) {
				return null;
			}

			projectParam = URLDecoder.decode(projectParam, "UTF-8");
			projectParam = UtilCriptografia.getInstancia().descripta(projectParam);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projectParam;
	}

	public void js() {
		System.out.println("called");
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext extContext = ctx.getExternalContext();

		try {
			extContext.setResponseContentType("text/xml");
			extContext.addResponseHeader("Cache - Control ", "no - cache");
			PartialResponseWriter writer = ctx.getPartialViewContext().getPartialResponseWriter();
			writer.startDocument();
			writer.startEval();
			writer.write("$(document).ready(function(){oi();});");
			writer.endEval();
			writer.endDocument();
			writer.flush();
			ctx.responseComplete();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
