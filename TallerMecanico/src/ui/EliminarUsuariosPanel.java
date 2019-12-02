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
				if (handler.consultarUsuario(buscarTextfield.getText()) != null) {
					objectToPanel(handler.consultarUsuario(buscarTextfield.getText()));
					confirmarBoton.setEnabled(true);
				}
			}
		});

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.deleteUsuario(usuarioTextField.getText());
				limpiarCampos();
			}
		});

		cancelarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
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
	public void limpiarCampos() {
		nombreTextField.setText("");
		apellidoTextField.setText("");
		mailTextField.setText("");
		usuarioTextField.setText("");
		passwordField.setText("");
		buscarTextfield.setText("");
	}

	@Override
	public Object panelToObject() {
		// TODO Auto-generated method stub
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
		JTextField[] textFields = { buscarTextfield, nombreTextField, apellidoTextField, mailTextField, usuarioTextField };

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
	public void initButtons() {
		buscarBoton = new JButton("Eliminar");
		confirmarBoton = new JButton("Confirmar");
		cancelarBoton = new JButton("Cancelar");
	}

}
