
package entidades;

import java.math.BigDecimal;

public class Factura {

	private int idFactura;
	private String patente;
	private String arreglo;
	private BigDecimal costoAreglo;
	private boolean cobrado;

	public Factura() {

	}

	public Factura(int idFactura, String patente, String arreglo, BigDecimal costoAreglo, boolean cobrado) {
		this.idFactura = idFactura;
		this.patente = patente;
		this.arreglo = arreglo;
		this.costoAreglo = costoAreglo;
		this.cobrado = cobrado;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public String getPatente() {
		return patente;
	}

	public String getArreglo() {
		return arreglo;
	}

	public BigDecimal getCostoAreglo() {
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

	public void setCostoAreglo(BigDecimal costoAreglo) {
		this.costoAreglo = costoAreglo;
	}

	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}

}
