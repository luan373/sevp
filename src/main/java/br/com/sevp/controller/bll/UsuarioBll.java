package br.com.sevp.controller.bll;

import java.io.Serializable;
import java.util.List;

import br.com.sevp.model.dao.UsuarioDao;
import br.com.sevp.model.entity.Usuario;

public class UsuarioBll implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -84145567180744470L;
	UsuarioDao usuarioDao = null;

	public UsuarioBll() {
		this.usuarioDao = new UsuarioDao();
	}

	public void inserir(Usuario usuario) {
		this.usuarioDao.inserir(usuario);
	}

	public void alterar(Usuario usuario) {
		this.usuarioDao.alterar(usuario);
	}

	public void excluir(Usuario usuario) {
		this.usuarioDao.excluir(usuario);
	}

	public List<Usuario> pesquisar(Usuario usuario) {

		List<Usuario> resultado = usuarioDao.pesquisar(usuario);

		return resultado;
	}

	public List<Usuario> listar() {
		List<Usuario> resultado = usuarioDao.listar();
		return resultado;
	}
}
