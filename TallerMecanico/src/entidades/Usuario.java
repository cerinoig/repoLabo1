package entidades;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String usuario;
	private String password;

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String mail, String usuario, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.usuario = usuario;
		this.password = password;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMail() {
		return mail;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
