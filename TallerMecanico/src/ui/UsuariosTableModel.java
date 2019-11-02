package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Usuario;

public class UsuariosTableModel extends AbstractTableModel {

	private List<Usuario> usuarios;
	private final static int NOMBRE_COL = 0, APELLIDO_COL = 1, MAIL_COL = 2, USUARIO_COL = 3;
	private String[] titulos = { "NOMBRE", "APELLIDO", "MAIL", "USUARIO"};

	private static final long serialVersionUID = 1L;

	public UsuariosTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario usuario = usuarios.get(row);
		switch (col) {
		case NOMBRE_COL:
			return usuario.getNombre();
		case APELLIDO_COL:
			return usuario.getApellido();
		case MAIL_COL:
			return usuario.getMail();
		case USUARIO_COL:
			return usuario.getUsuario();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

}
