package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Usuario;
import handler.Handler;

public class ModificarUsuarioPanel extends UsuarioPanel {

	private static final long serialVersionUID = 1L;

	public ModificarUsuarioPanel(Handler handler) {
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
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreTextField.getText().trim().toLowerCase());
		usuario.setApellido(apellidoTextField.getText().trim().toLowerCase());
		usuario.setMail(mailTextField.getText().trim().toLowerCase());
		usuario.setUsuario(usuarioTextField.getText().trim().toLowerCase());
		usuario.setPassword(String.valueOf(passwordField.getPassword()));

		return usuario;
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
	public void habilitarCampos() {
		nombreTextField.setEditable(true);
		nombreTextField.setBackground(Color.WHITE);
		apellidoTextField.setEditable(true);
		apellidoTextField.setBackground(Color.WHITE);
		mailTextField.setEditable(true);
		mailTextField.setBackground(Color.WHITE);
		usuarioTextField.setEditable(true);
		usuarioTextField.setBackground(Color.WHITE);
		passwordField.setEditable(true);
		passwordField.setBackground(Color.WHITE);
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("MODIFICAR USUARIOS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		deshabilitarCampos();
		String[] labels = { "Buscar usuario", "Nombre", "Apellido", "Mail", "Usuario" };
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
		buscarBoton = new JButton("Buscar");
		confirmarBoton = new JButton("Modificar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		handler.modificarUsuario((Usuario) panelToObject());
		limpiarCampos();
		deshabilitarCampos();
	}

	@Override
	public void accionBuscar(Handler handler) {
		if (handler.consultarUsuario(buscarTextfield.getText()) != null) {
			objectToPanel(handler.consultarUsuario(buscarTextfield.getText().trim().toLowerCase()));
			habilitarCampos();
			confirmarBoton.setEnabled(true);
		}
	}

}
