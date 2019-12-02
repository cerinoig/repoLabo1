package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
				if (handler.consultarUsuario(buscarTextfield.getText()) != null) {
					objectToPanel(handler.consultarUsuario(buscarTextfield.getText()));
					habilitarCampos();
					confirmarBoton.setEnabled(true);
				}
			}
		});

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.modificarUsuario((Usuario) panelToObject());
			}
		});

		cancelarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
	}

	@Override
	public void limpiarCampos() {
		nombreTextField.setText("");
		apellidoTextField.setText("");
		mailTextField.setText("");
		usuarioTextField.setText("");
		passwordField.setText("");
	}

	@Override
	public Object panelToObject() {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreTextField.getText());
		usuario.setApellido(apellidoTextField.getText());
		usuario.setMail(mailTextField.getText());
		usuario.setUsuario(usuarioTextField.getText());
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

	public void deshabilitarCampos() {
		nombreTextField.setEditable(false);
		nombreTextField.setBackground(Color.LIGHT_GRAY);
		apellidoTextField.setEditable(false);
		apellidoTextField.setBackground(Color.LIGHT_GRAY);
		mailTextField.setEditable(false);
		mailTextField.setBackground(Color.LIGHT_GRAY);
		usuarioTextField.setEditable(false);
		usuarioTextField.setBackground(Color.LIGHT_GRAY);
		passwordField.setVisible(false);
	}

	private void habilitarCampos() {
		nombreTextField.setEditable(true);
		nombreTextField.setBackground(Color.WHITE);
		apellidoTextField.setEditable(true);
		apellidoTextField.setBackground(Color.WHITE);
		mailTextField.setEditable(true);
		mailTextField.setBackground(Color.WHITE);
		usuarioTextField.setEditable(true);
		usuarioTextField.setBackground(Color.WHITE);
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

		return crearBoxVertical(labels, textFields);
	}

	@Override
	public JButton[] getBotones() {
		initButtons();
		confirmarBoton.setEnabled(false);
		JButton[] botones = { buscarBoton, confirmarBoton, cancelarBoton };

		return botones;
	}

	@Override
	public void initTextFields() {
		buscarTextfield = new JTextField();
		nombreTextField = new JTextField();
		apellidoTextField = new JTextField();
		mailTextField = new JTextField();
		usuarioTextField = new JTextField();
		passwordField = new JPasswordField();
	}

	@Override
	public void initButtons() {
		buscarBoton = new JButton("Buscar");
		confirmarBoton = new JButton("Modificar");
		cancelarBoton = new JButton("Cancelar");
	}

}
