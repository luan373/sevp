package br.com.sevp.util;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@FacesValidator("validador")
public class Validador implements Serializable, Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String campo;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	int tamanhoMinimo = 5;

	public Validador() {
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String modelo = (String) value;

		if (modelo.length() < 5) {
			FacesMessage msg = new FacesMessage("Tamanho mínimo são 5 caracteres");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(msg);
		}
	}

}
