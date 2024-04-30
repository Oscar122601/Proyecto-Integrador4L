package datos;

public class LoginSecurity {
	private String usuario;
	private String contraseña;
	
	public LoginSecurity(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public String getUsername() {
		return usuario;
	}

	public void setUsername(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return contraseña;
	}

	public void setPassword(String contraseña) {
		this.contraseña = contraseña;
	}
}