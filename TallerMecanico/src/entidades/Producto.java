package entidades;

public class Producto {

	private int idProducto;
	private int codigoProducto;
	private String descripcion;
	private int cantidad;
	private double precioUnitario;

	public int getIdProducto() {
		return idProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public String toString() {
		return "Codigo de producto: " + codigoProducto + "| Descripción: " + descripcion + "| Cantidad: " + cantidad + "| Precio unitario: " + precioUnitario;
	}

}
