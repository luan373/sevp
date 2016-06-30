package br.com.sevp.util;

public class Enuns {
	public enum TipoPessoa {
		PessoaFisica("PF"), PessoaJuridica("PJ");

		private final String tipoPessoa;

		private TipoPessoa(String tipoPessoa) {
			this.tipoPessoa = tipoPessoa;
		}

		public String getTipoPessoa() {
			return this.tipoPessoa;
		}
	}
}