package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.ProdutoPedido;

public class ProdutoPedidoDao extends AbstractDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4912448001452103427L;

	public ProdutoPedidoDao() {
		super();
	}

	public ProdutoPedido recuperar(long idProdutoPedido) {
		Criteria criteria = this.getSession().createCriteria(ProdutoPedido.class);
		criteria.add(Restrictions.eq("idProdutoPedido", idProdutoPedido));

		ProdutoPedido produtoPedido = (ProdutoPedido) criteria.uniqueResult();
		return produtoPedido;

	}

	@SuppressWarnings("unchecked")
	public List<ProdutoPedido> listar() {
		Criteria criteria = this.getSession().createCriteria(ProdutoPedido.class);
		List<ProdutoPedido> lista = criteria.list();
		return lista;
	}

	public void inserir(ProdutoPedido produtoPedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(produtoPedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(ProdutoPedido produtoPedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(produtoPedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void excluir(ProdutoPedido produtoPedido) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(produtoPedido);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
