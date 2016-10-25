package br.com.sevp.util;

public class UtilCriptografia {

	private static Cifrador instancia;
	
	private UtilCriptografia(){
		
	}
	
	public static Cifrador getInstancia() {
		try {
			if (instancia == null) {
				instancia = new Cifrador("sevp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instancia;
	}
	
}
