package ui;

import javax.swing.JTextField;

import handler.Handler;

public class EliminarUsuariosPanel extends EliminarDatosPanel {

	private static final long serialVersionUID = 1L;

	public EliminarUsuariosPanel(Handler handler) {
		super(handler, "Nombre de usuario");
	}

	@Override
	public void eliminarDatos(Handler handler) {
		handler.deleteUsuario(((JTextField) datos1.getComponent(3)).getText().toString());
	}

}
