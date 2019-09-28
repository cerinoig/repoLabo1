package entidades;

public class Usuario {

	private int idUsuario;
	private String usuario;
	private String password;

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Usuario: " + usuario;
	}

}
