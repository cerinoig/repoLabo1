package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Factura;
import handler.Handler;

public class AltaFacturaPanel extends FacturaPanel {

	private static final long serialVersionUID = 1L;

	public AltaFacturaPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initPanel(Handler handler) {

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.altaFactura(((Factura) panelToObject()));
				;
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

	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		arregloTextField.setText("");
	}

	@Override
	public Object panelToObject() {
		Factura factura = new Factura();

		factura.setArreglo(arregloTextField.getText());
		factura.setPatente(arregloTextField.getText().toUpperCase());

		return null;
	}

	@Override
	public void objectToPanel(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("Cargar factura");
	}

	@Override
	public Box getBody() {

		initTextFields();
		final String[] labels = { "patente", "Arreglo" };
		JTextField[] textFields = { patenteTextField, arregloTextField };

		return crearBoxVertical(labels, textFields);
	}

	@Override
	public JButton[] getBotones() {
		initButtons();
		JButton[] botones = { confirmarBoton, cancelarBoton };
		return botones;
	}

	@Override
	public void initButtons() {
		confirmarBoton = new JButton("Crear");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accionBuscar(Handler handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deshabilitarCampos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitarCampos() {
		// TODO Auto-generated method stub

	}

}
