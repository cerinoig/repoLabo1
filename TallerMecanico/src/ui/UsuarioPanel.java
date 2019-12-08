package ui;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import excepciones.CamposVaciosException;
import handler.Handler;

public abstract class UsuarioPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField nombreTextField, apellidoTextField, mailTextField, usuarioTextField;
	protected JPasswordField passwordField;

	public UsuarioPanel(Handler handler) {
		super(handler);
	}

	public Box crearBoxVertical(String[] titulosBoxes, JTextField[] textFields, JPasswordField passwordField) {
		Box vertical = Box.createVerticalBox();
		for (int i = 0; i < titulosBoxes.length; i++) {
			vertical.add(Box.createVerticalStrut(20));
			vertical.add(crearBoxHorizontal(titulosBoxes[i], textFields[i]));
		}
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(crearBoxHorizontal("Contraseña", passwordField));

		return vertical;
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
	public void deshabilitarCampos() {
		nombreTextField.setEditable(false);
		nombreTextField.setBackground(Color.LIGHT_GRAY);
		apellidoTextField.setEditable(false);
		apellidoTextField.setBackground(Color.LIGHT_GRAY);
		mailTextField.setEditable(false);
		mailTextField.setBackground(Color.LIGHT_GRAY);
		usuarioTextField.setEditable(false);
		usuarioTextField.setBackground(Color.LIGHT_GRAY);
		passwordField.setEditable(false);
		passwordField.setBackground(Color.LIGHT_GRAY);
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
	public void revisarCamposVacios() throws CamposVaciosException {

		if (nombreTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (apellidoTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (mailTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (usuarioTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (String.valueOf(passwordField.getPassword()).equals(""))
			throw new CamposVaciosException();
	}

}
