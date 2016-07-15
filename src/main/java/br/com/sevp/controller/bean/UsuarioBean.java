package br.com.sevp.controller.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.sevp.controller.bll.UsuarioBll;
import br.com.sevp.model.entity.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711950941720495714L;
	Usuario usuario = null;
	UsuarioBll usuarioBll = null;

	List<Usuario> lista = null;

	public String validaUsuario() {
		if (usuario.getIdUsuario() == 0) {
			this.usuarioBll.inserir(usuario);
		} else {
			this.usuarioBll.alterar(usuario);
		}

		mataSessao();
		return "/index";
	}

	public String excluiUsuario() {
		this.usuarioBll.excluir(usuario);
		System.out.println("excluiuuuuu");
		mataSessao();

		return "/index";
	}

	public void pesquisaUsuario() {
		lista = usuarioBll.pesquisar(usuario);
	}

	public UsuarioBean() {
		System.out.println("Construtor");
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		this.usuarioBll = new UsuarioBll();
		this.lista = new ArrayList<Usuario>();
		System.out.println(usuario);
	}

	public String addTituloPagina() {
		if (usuario.getIdUsuario() == 0) {
			return "Cadastrar Usuário";
		}
		return "Alterar Usuário";
	}

	public String direcionaPagina(String local) throws IOException {
		mataSessao();

		return local;
	}

	private void menssagemSucesso() {
		
	}

	private void mataSessao() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBean", null);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
}
