package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Estados;

public class EstadosDao extends AbstractDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2668459213928710198L;

	public EstadosDao() {
		super();
	}

	public Estados recuperar(String uf) {
		Criteria criteria = this.getSession().createCriteria(Estados.class);
		criteria.add(Restrictions.eq("sigla", uf));

		Estados estados = (Estados) criteria.uniqueResult();
		return estados;
	}

	@SuppressWarnings("unchecked")
	public List<Estados> listar() {
		Criteria criteria = this.getSession().createCriteria(Estados.class);
		List<Estados> lista = (List<Estados>) criteria.list();

		return lista;
	}

}
