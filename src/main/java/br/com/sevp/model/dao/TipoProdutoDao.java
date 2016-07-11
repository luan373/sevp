package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.TipoProduto;

public class TipoProdutoDao extends AbstractDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7036472305363552571L;

	public TipoProdutoDao() {
		super();
	}

	public TipoProduto recuperar(long idTipoProduto) {
		Criteria criteria = this.getSession().createCriteria(TipoProduto.class);
		criteria.add(Restrictions.eq("idTipoProduto", idTipoProduto));

		TipoProduto tipoProduto = (TipoProduto) criteria.uniqueResult();
		return tipoProduto;

	}

	@SuppressWarnings("unchecked")
	public List<TipoProduto> listar() {
		Criteria criteria = this.getSession().createCriteria(TipoProduto.class);
		List<TipoProduto> lista = criteria.list();
		return lista;
	}

	public void inserir(TipoProduto tipoProduto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(tipoProduto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(TipoProduto tipoProduto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(tipoProduto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void excluir(TipoProduto tipoProduto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(tipoProduto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
