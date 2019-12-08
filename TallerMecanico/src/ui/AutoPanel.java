package ui;

import java.awt.Color;

import javax.swing.JTextField;

import excepciones.CamposVaciosException;
import handler.Handler;

public abstract class AutoPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField patenteTextField;
	protected JTextField marcaTextField;
	protected JTextField modeloTextField;
	protected JTextField colorTextField;
	protected JTextField puertasTextField;
	protected JTextField kilometrosTextField;
	protected JTextField añoTextField;

	public AutoPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initTextFields() {
		buscarTextfield = new JTextField();
		patenteTextField = new JTextField();
		marcaTextField = new JTextField();
		modeloTextField = new JTextField();
		colorTextField = new JTextField();
		puertasTextField = new JTextField();
		kilometrosTextField = new JTextField();
		añoTextField = new JTextField();
	}

	@Override
	public void deshabilitarCampos() {
		patenteTextField.setEditable(false);
		patenteTextField.setBackground(Color.LIGHT_GRAY);
		marcaTextField.setEditable(false);
		marcaTextField.setBackground(Color.LIGHT_GRAY);
		modeloTextField.setEditable(false);
		modeloTextField.setBackground(Color.LIGHT_GRAY);
		colorTextField.setEditable(false);
		colorTextField.setBackground(Color.LIGHT_GRAY);
		puertasTextField.setEditable(false);
		puertasTextField.setBackground(Color.LIGHT_GRAY);
		kilometrosTextField.setEditable(false);
		kilometrosTextField.setBackground(Color.LIGHT_GRAY);
		añoTextField.setEditable(false);
		añoTextField.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		marcaTextField.setText("");
		modeloTextField.setText("");
		colorTextField.setText("");
		puertasTextField.setText("");
		kilometrosTextField.setText("");
		añoTextField.setText("");
		buscarTextfield.setText("");
	}
	
	
	public void revisarCamposVacios() throws CamposVaciosException {

		if (patenteTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (marcaTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (modeloTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (colorTextField.getText().trim().equals(""))	
			throw new CamposVaciosException();

		if (puertasTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (kilometrosTextField.getText().trim().equals(""))
			throw new CamposVaciosException();

		if (añoTextField.getText().trim().equals(""))
			throw new CamposVaciosException();
	}
	

}
