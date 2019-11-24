
package entidades;

public class Factura {

	private int idFactura;
	private String patente;
	private String arreglo;
	private boolean cobrado;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	public String getArreglo() {
		return arreglo;
	}

	public void setArreglo(String arreglo) {
		this.arreglo = arreglo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isCobrado() {
		return cobrado;
	}

	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
	
}
