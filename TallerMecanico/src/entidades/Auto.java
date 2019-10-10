
package entidades;

public class Auto {

	private int idUsuario;
	private String patente;
	private String marca;
	private String modelo;
	private String color;
	private int cantidadPuertas;
	private String año;
	private int kilometraje;

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getPatente() {
		return patente;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public int getCantidadPuertas() {
		return cantidadPuertas;
	}

	public String getAño() {
		return año;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

}
