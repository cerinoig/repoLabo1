package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Factura;

public class FacturasTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Factura> facturas;
	private final static int COD_FACTURA = 0, PATENTE_COL = 1, ARREGLO_COL = 2, COSTO_ARREGLO_COL = 3, PAGAR_COL = 4;
	private final static String[] titulos = { "COD_FACTURA", "PATENTE", "ARREGLO", "COSTO DEL ARREGLO", "PAGAR" };

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
		case COSTO_ARREGLO_COL:
			return factura.getCostoAreglo();
		case PAGAR_COL:
			return factura.isCobrado();
		default:
			return "";
		}
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case COD_FACTURA:
			return Integer.class;
		case PATENTE_COL:
			return String.class;
		case ARREGLO_COL:
			return String.class;
		case COSTO_ARREGLO_COL:
			return Double.class;
		case PAGAR_COL:
			return Boolean.class;
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == PAGAR_COL) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Factura factura = facturas.get(rowIndex);
		if (columnIndex == PAGAR_COL) {
			factura.setCobrado((Boolean) aValue);
		}
	}

}
