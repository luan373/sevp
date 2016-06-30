package br.com.sevp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {

	// Vari�vel est�tica que conter� a inst�ncia do m�todo
		private static Session instance;

		static {
			// Opera��es de inicializa��o da classe
		}

		// Construtor privado. Suprime o construtor p�blico padr�o, ou seja, nunca
		// ser� usado
		private SessionFactoryUtil() {
		}

		// M�todo p�blico est�tico de acesso �nico ao objeto
		public static Session getInstance() {

			if (instance == null) {
				inicializaInstancia();
			}

			// Retorna o a inst�ncia do objeto
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
