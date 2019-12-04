
package entidades;

public class Factura {

	private int idFactura;
	private String patente;
	private String arreglo;
	private Double costoAreglo;
	private boolean cobrado;

	public int getIdFactura() {
		return idFactura;
	}

	public String getPatente() {
		return patente;
	}

	public String getArreglo() {
		return arreglo;
	}

	public Double getCostoAreglo() {
		return costoAreglo;
	}

	public boolean isCobrado() {
		return cobrado;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setArreglo(String arreglo) {
		this.arreglo = arreglo;
	}

	public void setCostoAreglo(Double costoAreglo) {
		this.costoAreglo = costoAreglo;
	}

	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
	
}
