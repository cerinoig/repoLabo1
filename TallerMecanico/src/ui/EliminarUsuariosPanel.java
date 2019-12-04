package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Usuario;
import handler.Handler;

public class EliminarUsuariosPanel extends UsuarioPanel {

	private static final long serialVersionUID = 1L;

	public EliminarUsuariosPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initPanel(Handler handler) {
		buscarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBuscar(handler);
			}
		});

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionConfirmar(handler);
			}
		});
	}

	@Override
	public Object panelToObject() {
		return null;
	}

	@Override
	public void objectToPanel(Object object) {
		nombreTextField.setText(((Usuario) object).getNombre());
		apellidoTextField.setText(((Usuario) object).getApellido());
		mailTextField.setText(((Usuario) object).getMail());
		usuarioTextField.setText(((Usuario) object).getUsuario());
		passwordField.setText(((Usuario) object).getPassword());
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("ELIMINAR USUARIOS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		deshabilitarCampos();
		final String[] labels = { "Buscar usuario", "Nombre", "Apellido", "Mail", "Usuario" };
		JTextField[] textFields = { buscarTextfield, nombreTextField, apellidoTextField, mailTextField,
				usuarioTextField };

		return crearBoxVertical(labels, textFields, passwordField);
	}

	@Override
	public JButton[] getBotones() {
		initButtons();
		confirmarBoton.setEnabled(false);
		JButton[] botones = { buscarBoton, confirmarBoton, cancelarBoton };

		return botones;
	}

	@Override
	public void initButtons() {
		buscarBoton = new JButton("Eliminar");
		confirmarBoton = new JButton("Confirmar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		handler.deleteUsuario(usuarioTextField.getText().trim().toLowerCase());
		limpiarCampos();
	}

	@Override
	public void accionBuscar(Handler handler) {
		if (handler.consultarUsuario(buscarTextfield.getText()) != null) {
			objectToPanel(handler.consultarUsuario(buscarTextfield.getText()));
			confirmarBoton.setEnabled(true);
		}
	}

	@Override
	public void habilitarCampos() {
		// TODO Auto-generated method stub
	}

}
