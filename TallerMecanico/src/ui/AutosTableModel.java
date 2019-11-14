package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Auto;

public class AutosTableModel extends AbstractTableModel {

	private List<Auto> autos;
	private final static int PATENTE_COL = 0, MARCA_COL = 1, MODELO_COL = 2, COLOR_COL = 3, CANT_PUERTAS_COL = 4,
			AÑO_COL = 5, KILOMETRAJE_COL = 6;
	private final static String[] titulos = { "PATENTE", "MARCA", "MODELO", "COLOR", "CANTIDAD DE PUERTAS", "AÑO", "KILOMETROS" };

	private static final long serialVersionUID = 1L;

	public AutosTableModel(List<Auto> autos) {
		this.autos = autos;
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public int getRowCount() {
		return autos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Auto auto = autos.get(row);
		switch (col) {
		case PATENTE_COL:
			return auto.getPatente();
		case MARCA_COL:
			return auto.getMarca();
		case MODELO_COL:
			return auto.getModelo();
		case COLOR_COL:
			return auto.getColor();
		case CANT_PUERTAS_COL:
			return auto.getCantidadPuertas();
		case AÑO_COL:
			return auto.getAño();
		case KILOMETRAJE_COL:
			return auto.getKilometraje();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

}
