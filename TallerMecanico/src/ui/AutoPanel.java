package ui;

import java.awt.Color;

import javax.swing.JTextField;

import handler.Handler;

public abstract class AutoPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField patenteTextField;
	protected JTextField marcaTextField;
	protected JTextField modeloTextField;
	protected JTextField colorTextField;
	protected JTextField puertasTextField;
	protected JTextField kilometrosTextField;
	protected JTextField a�oTextField;

	public AutoPanel(Handler handler) {
		super(handler);
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
		a�oTextField.setEditable(false);
		a�oTextField.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		marcaTextField.setText("");
		modeloTextField.setText("");
		colorTextField.setText("");
		puertasTextField.setText("");
		kilometrosTextField.setText("");
		a�oTextField.setText("");
		buscarTextfield.setText("");
	}

}
