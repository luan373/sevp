package br.com.sevp.model.dao;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.sevp.util.SessionFactoryUtil;

public class AbstractDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6006498564090925551L;

	public AbstractDao() {

	}

	protected Session getSession() {

		return SessionFactoryUtil.getInstance();
	}
}
