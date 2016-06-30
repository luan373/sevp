package br.com.sevp.model.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Pedido;

public class PedidoDao extends AbstractDao {
	public PedidoDao() {
		super();
	}

	public Pedido recuperar(long idPedido) {
		Criteria criteria = this.getSession().createCriteria(Pedido.class);
		criteria.add(Restrictions.eq("idPedido", idPedido));

		Pedido pedido = (Pedido) criteria.uniqueResult();

		return pedido;
	}
	
	public void inserir(Pedido pedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(pedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(Pedido pedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(pedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void excluir(Pedido pedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(pedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
}
