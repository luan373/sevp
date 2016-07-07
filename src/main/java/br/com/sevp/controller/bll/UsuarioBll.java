package br.com.sevp.controller.bll;

import java.io.Serializable;
import java.util.List;

import br.com.sevp.model.dao.UsuarioDao;
import br.com.sevp.model.entity.Usuario;

public class UsuarioBll implements Serializable {
	UsuarioDao usuarioDao = null;

	public UsuarioBll() {
		this.usuarioDao = new UsuarioDao();
	}

	public void inserir(Usuario usuario) {
		this.usuarioDao.inserir(usuario);
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
