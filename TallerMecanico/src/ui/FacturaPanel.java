package ui;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import handler.Handler;

public abstract class FacturaPanel extends MiPanel {

	private static final long serialVersionUID = 1L;
	
	protected JTextField idFacturaTextField;
	protected JTextField patenteTextField;
	protected JTextField arregloTextField;
	protected JTextField precioTextField;
	protected JCheckBox cobradoCheckBox;

	public FacturaPanel(Handler handler) {
		super(handler);
		
	}
	
	@Override
	public void initTextFields() {
		idFacturaTextField = new JTextField();
		patenteTextField = new JTextField();
		arregloTextField = new JTextField();
		precioTextField = new JTextField();
	}
	
	
	@Override
	public void deshabilitarCampos() {
		patenteTextField.setEditable(false);
		patenteTextField.setBackground(Color.LIGHT_GRAY);
		arregloTextField.setEditable(false);
		arregloTextField.setBackground(Color.LIGHT_GRAY);
		precioTextField.setEditable(false);
		precioTextField.setBackground(Color.LIGHT_GRAY);
	}

	
	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		arregloTextField.setText("");
		precioTextField.setText("");
	}
}
