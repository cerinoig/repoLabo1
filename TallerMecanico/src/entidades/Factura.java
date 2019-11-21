
package entidades;

public class Factura {

	private int idFactura;
	private Auto auto;
	private String arreglo;
	private int costoTotal;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getArreglo() {
		return arreglo;
	}

	public void setArreglo(String arreglo) {
		this.arreglo = arreglo;
	}

}
