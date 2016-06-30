package br.com.sevp.model.entity;
// Generated 28/06/2016 16:48:43 by Hibernate Tools 3.5.0.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "Usuario", schema = "dbo", catalog = "SEVP")
public class Usuario implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2509337539434932111L;

	private long idUsuario;
	private String nome;
	private String usuario;
	private String senha;
	private boolean ativo;
	private Set<Pedido> pedidos = new HashSet<Pedido>();

	public Usuario() {
	}

	public Usuario(long idUsuario, String nome, String usuario, String senha, boolean ativo) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
	}

	public Usuario(long idUsuario, String nome, String usuario, String senha, boolean ativo, Set<Pedido> pedidos) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
		this.pedidos = pedidos;
	}

	@Id

	@Column(name = "IdUsuario", unique = true, nullable = false)
	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "Nome", nullable = false)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "Usuario", nullable = false)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "Senha", nullable = false)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "Ativo", nullable = false)
	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdUsuario")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha
				+ ", ativo=" + ativo + "]";
	}

}