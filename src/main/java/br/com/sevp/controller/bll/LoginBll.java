package br.com.sevp.controller.bll;

import br.com.sevp.model.dao.UsuarioDao;

public class LoginBll {
	UsuarioDao usuarioDao = null;

	public LoginBll() {
		this.usuarioDao = new UsuarioDao();
	}

	public boolean isSenhaCorreta(String login, String senha) {

		boolean isValido = usuarioDao.validaLogin(login, senha);
		return isValido;

	}
}
