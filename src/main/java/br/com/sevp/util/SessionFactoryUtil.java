package br.com.sevp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {

	// Variável estática que conterá a instância do método
		private static Session instance;

		static {
			// Operações de inicialização da classe
		}

		// Construtor privado. Suprime o construtor público padrão, ou seja, nunca
		// será usado
		private SessionFactoryUtil() {
		}

		// Método público estático de acesso único ao objeto
		public static Session getInstance() {

			if (instance == null) {
				inicializaInstancia();
			}

			// Retorna o a instância do objeto
			return instance;

		}

		private static synchronized void inicializaInstancia() {
			if (instance == null) {
				SessionFactory sessions = new AnnotationConfiguration().configure("hibernate.cfg.xml")
						.buildSessionFactory();
				instance = sessions.openSession();

			}
		}
}
