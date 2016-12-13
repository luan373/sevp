package br.com.sevp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.sevp.model.entity.Cidades;

public class CidadesDao extends AbstractDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3705657287112041172L;

	public CidadesDao() {
		super();
	}

	public Cidades recuperar(int idCidades) {
		Criteria criteria = this.getSession().createCriteria(Cidades.class);
		criteria.add(Restrictions.eq("id", idCidades));

		Cidades cidades = (Cidades) criteria.uniqueResult();
		return cidades;
	}

	@SuppressWarnings("unchecked")
	public List<Cidades> listar() {
		Criteria criteria = this.getSession().createCriteria(Cidades.class);
		List<Cidades> lista = (List<Cidades>) criteria.list();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Cidades> pesquisar(int idCidades) {
		Criteria criteria = this.getSession().createCriteria(Cidades.class);
		criteria.add(Restrictions.eq("estados.id", idCidades));

		List<Cidades> lsitaCidades = (List<Cidades>) criteria.list();
		return lsitaCidades;
	}
}
