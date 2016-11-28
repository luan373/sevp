package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Cliente;
import br.com.sevp.model.entity.Usuario;

public class ClienteDao extends AbstractDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6212327755892061552L;

	public ClienteDao() {
		super();
	}

	public Cliente recuperar(long idCliente) {
		Criteria criteria = this.getSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("idCliente", idCliente));

		Cliente cliente = (Cliente) criteria.uniqueResult();
		return cliente;

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		Criteria criteria = this.getSession().createCriteria(Cliente.class);
		List<Cliente> lista = criteria.list();
		return lista;
	}

	public void inserir(Cliente cliente) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(cliente);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(Cliente cliente) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(cliente);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void excluir(Cliente cliente) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(cliente);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisar(Cliente cliente) {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		if (cliente.getNomeRazao() != null && !cliente.getNomeRazao().equals("")) {
			criteria.add(Restrictions.like("nome", cliente.getNomeRazao(), MatchMode.ANYWHERE));
		}

		if (cliente.getCpfCnpj() != null && !cliente.getCpfCnpj().equals("")) {
			criteria.add(Restrictions.like("usuario", cliente.getCpfCnpj(), MatchMode.ANYWHERE));
		}

		List<Cliente> resultado = criteria.list();

		return resultado;
	}

}
