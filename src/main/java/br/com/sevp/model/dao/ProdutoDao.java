package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Produto;

public class ProdutoDao extends AbstractDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2343154257884028529L;

	public ProdutoDao() {
		super();
	}

	public Produto recuperar(long idProduto) {
		Criteria criteria = this.getSession().createCriteria(Produto.class);
		criteria.add(Restrictions.eq("idProduto", idProduto));

		Produto produto = (Produto) criteria.uniqueResult();
		return produto;

	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		Criteria criteria = this.getSession().createCriteria(Produto.class);
		List<Produto> lista = criteria.list();
		return lista;
	}
	
	public void inserir(Produto produto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.save(produto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void alterar(Produto produto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(produto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void excluir(Produto produto) {
		Session session = this.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(produto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
