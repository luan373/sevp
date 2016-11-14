package br.com.sevp.model.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.UsuarioRoles;

public class UsuarioRolesDao extends AbstractDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7808429074436777459L;
	UsuarioRoles usuarioRoles = null;

	public UsuarioRolesDao() {
		super();
	}

	public void inserir(String usuario) {
		usuarioRoles = new UsuarioRoles();

		this.usuarioRoles.setRole("user");
		this.usuarioRoles.setUsuario(usuario);

		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(usuarioRoles);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	public void excluir(String usuario) {
		usuarioRoles = new UsuarioRoles();

		Criteria criterionUsuarioRole = this.getSession().createCriteria(UsuarioRoles.class);
		criterionUsuarioRole.add(Restrictions.eq("usuario", usuario));
		this.usuarioRoles = (UsuarioRoles)criterionUsuarioRole.uniqueResult();

		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(usuarioRoles);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
