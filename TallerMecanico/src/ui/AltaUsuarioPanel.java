package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Usuario;
import handler.Handler;

public class AltaUsuarioPanel extends UsuarioPanel {

	private static final long serialVersionUID = 1L;

	private JPasswordField passwordField;
	private JButton guardarBoton;

	public AltaUsuarioPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initPanel(Handler handler) {
		guardarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionConfirmar(handler);
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
		usuario.setNombre(nombreTextField.getText().trim().toLowerCase());
		usuario.setApellido(apellidoTextField.getText().trim().toLowerCase());
		usuario.setMail(mailTextField.getText().trim());
		usuario.setUsuario(usuarioTextField.getText().trim().toLowerCase());
		usuario.setPassword(String.valueOf(passwordField.getPassword()));

		return usuario;
	}

	@Override
	public void objectToPanel(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("REGISTRO DE USUARIOS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		final String[] labels = { "Nombre", "Apellido", "Mail", "Usuario" };
		JTextField[] textFields = { nombreTextField, apellidoTextField, mailTextField, usuarioTextField };

		return crearBoxVertical(labels, textFields, passwordField);
	}

	@Override
	public JButton[] getBotones() {
		initButtons();
		JButton[] botones = { guardarBoton, cancelarBoton };
		return botones;
	}

	@Override
	public void initTextFields() {
		nombreTextField = new JTextField();
		apellidoTextField = new JTextField();
		mailTextField = new JTextField();
		usuarioTextField = new JTextField();
		passwordField = new JPasswordField();
	}

	@Override
	public void initButtons() {
		guardarBoton = new JButton("Guardar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		handler.altaUsuario((Usuario) panelToObject());
		limpiarCampos();
	}

	@Override
	public void accionBuscar(Handler handler) {
	}

	@Override
	public void deshabilitarCampos() {
	}

	@Override
	public void habilitarCampos() {
	}

	@Override
	public boolean validarCamposVacios() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void marcarCamposVacios() {
		// TODO Auto-generated method stub
		
	}

}
