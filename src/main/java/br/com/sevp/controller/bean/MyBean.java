package br.com.sevp.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;

@ManagedBean(name = "myBean")
public class MyBean {

	public void js() {
		System.out.println("called");
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext extContext = ctx.getExternalContext();
		if (ctx.getPartialViewContext().isAjaxRequest()) {
			try {
				extContext.setResponseContentType("text/xml");
				extContext.addResponseHeader("Cache - Control ", "no - cache");
				PartialResponseWriter writer = ctx.getPartialViewContext().getPartialResponseWriter();
				writer.startDocument();
				writer.startEval();
				writer.write("oi();");
				writer.endEval();
				writer.endDocument();
				writer.flush();
				ctx.responseComplete();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
