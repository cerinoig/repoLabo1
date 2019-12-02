package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Factura;

public class FacturasTableModel extends AbstractTableModel  {

	private static final long serialVersionUID = 1L;
	private List<Factura> facturas;
	private final static int COD_FACTURA = 0, PATENTE_COL = 1, ARREGLO_COL = 2, COBRAR_COL = 3;
	private final static String[] titulos = { "COD_FACTURA", "PATENTE", "ARREGLO", "COBRADO"};
	
	public FacturasTableModel(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public int getRowCount() {
		return facturas.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Factura factura = facturas.get(row);
		
		switch (col) {
		case COD_FACTURA:
			return factura.getIdFactura();
		case PATENTE_COL:
			return factura.getPatente();
		case ARREGLO_COL:
			return factura.getArreglo();
		case COBRAR_COL:
			return factura.isCobrado();
		default:
			return "";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

}
