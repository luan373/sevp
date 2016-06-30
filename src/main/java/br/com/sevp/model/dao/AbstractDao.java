package br.com.sevp.model.dao;

import org.hibernate.Session;

import br.com.sevp.util.SessionFactoryUtil;

public class AbstractDao {
	public AbstractDao() {

	}

	protected Session getSession() {

		return SessionFactoryUtil.getInstance();
	}
}
