package sevp;

import br.com.sevp.model.dao.AbstractDao;

public class Principal extends AbstractDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7152692732855008783L;

	public Principal() {
		super();
	}

	public void name() {
		this.getSession();
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		
		boolean oi = principal.osh(true);
		
		System.out.println(oi);
	}

	public boolean osh(boolean oi) {
		if(!oi == false){
			return false;
		}
		
		return true;

	}
}
