package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Usuario;

public class UsuarioDao extends AbstractDao {

	public UsuarioDao() {
		super();
	}

	public Usuario recuperar(long idUsuario) {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("idUsuario", idUsuario));

		Usuario usuario = (Usuario) criteria.uniqueResult();
		return usuario;

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		List<Usuario> lista = criteria.list();
		return lista;
	}

	public void inserir(Usuario usuario) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(usuario);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(usuario);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usuario) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(usuario);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
