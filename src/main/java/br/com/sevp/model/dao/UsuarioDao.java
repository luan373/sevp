package br.com.sevp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Usuario;

public class UsuarioDao extends AbstractDao implements Serializable {

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

	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisar(Usuario usuario) {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		if (usuario.getNome() != null && !usuario.getNome().equals("")) {
			criteria.add(Restrictions.like("nome", usuario.getNome(), MatchMode.ANYWHERE));
		}

		if (usuario.getUsuario() != null && !usuario.getUsuario().equals("")) {
			criteria.add(Restrictions.like("usuario", usuario.getUsuario(), MatchMode.ANYWHERE));
		}
		
		List<Usuario> resultado = criteria.list();
		
		return resultado;
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

	/**
	 * Método que valida se o login e senha estão corretos, se correto retorna
	 * true, senão false.
	 * 
	 * @param usuario
	 * @param senha
	 * @return true/false
	 */
	public boolean validaLogin(String usuario, String senha) {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("senha", senha));

		Usuario usr = (Usuario) criteria.uniqueResult();

		if (usr != null) {
			return true;
		}

		return false;

	}

}
