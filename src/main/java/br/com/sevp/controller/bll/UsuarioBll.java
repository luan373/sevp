package br.com.sevp.controller.bll;

import java.io.Serializable;
import java.util.List;

import org.hibernate.NonUniqueObjectException;

import br.com.sevp.excpetion.SevpException;
import br.com.sevp.model.dao.UsuarioDao;
import br.com.sevp.model.dao.UsuarioRolesDao;
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

	public void inserir(Usuario usuario) throws SevpException {
		// verifica se ja existe um loco com esse usuario, caso tenha
		this.validaUsuario(usuario.getUsuario());
		this.usuarioDao.inserir(usuario);

		// insere sua permisão de usuário
		UsuarioRolesDao usuarioRolesDao = new UsuarioRolesDao();
		usuarioRolesDao.inserir(usuario.getUsuario());

	}

	@SuppressWarnings("null")
	public void alterar(Usuario usuario) throws SevpException {
		String usuarioValidacao = usuario.getUsuario();
		usuario.setUsuario(usuarioValidacao);
		this.usuarioDao.alterar(usuario);
	}

	public void excluir(Usuario usuario) {
		this.usuarioDao.excluir(usuario);
	}

	public Usuario recuperar(long idUsuario) {
		return this.usuarioDao.recuperar(idUsuario);
	}

	public List<Usuario> pesquisar(Usuario usuario) {

		List<Usuario> resultado = usuarioDao.pesquisar(usuario);

		return resultado;
	}

	public void validaUsuario(String usuario) throws SevpException {
		try{
			this.usuarioDao.validaUsuario(usuario);
		}catch (NonUniqueObjectException e) {
			throw new SevpException("Usuário já existe");
		}
	}

	public List<Usuario> listar() {
		List<Usuario> resultado = usuarioDao.listar();
		return resultado;
	}
}
