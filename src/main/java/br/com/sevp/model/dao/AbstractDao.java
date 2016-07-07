package br.com.sevp.model.dao;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.sevp.util.SessionFactoryUtil;

public class AbstractDao implements Serializable {
	public AbstractDao() {

	}

	protected Session getSession() {

		return SessionFactoryUtil.getInstance();
	}
}
