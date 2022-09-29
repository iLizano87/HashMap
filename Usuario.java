package HashMap;

public class Usuario {

	private String pass;
	private int intentos;

	public Usuario() {
	}
	
	public Usuario(String pass, int intentos) {
		this.pass=pass;
		this.intentos=intentos;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}


}
