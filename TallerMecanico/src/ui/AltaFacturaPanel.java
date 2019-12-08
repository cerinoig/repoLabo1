package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Factura;
import excepciones.CamposVaciosException;
import excepciones.NonExistingCarException;
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
				accionConfirmar(handler);
			}
		});

	}

	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		arregloTextField.setText("");
		precioTextField.setText("");
	}

	@Override
	public Object panelToObject() {
		Factura factura = new Factura();
		factura.setArreglo(arregloTextField.getText().trim());
		factura.setPatente(patenteTextField.getText().trim().toUpperCase());

		try {
			Double.parseDouble(precioTextField.getText().trim().replace(".", "").replace(",", "."));
			precioTextField.setBackground(Color.WHITE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			precioTextField.setBackground(Color.RED);
			throw new NumberFormatException("Debe ingresar un importe válido");
		}

		factura.setCostoAreglo(new BigDecimal(precioTextField.getText().trim().replace(".", "").replace(",", "."))
				.setScale(2, RoundingMode.HALF_EVEN));
		return factura;
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
		final String[] labels = { "patente", "Arreglo", "Costo del arreglo" };
		JTextField[] textFields = { patenteTextField, arregloTextField, precioTextField };

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
		try {
			revisarCamposVacios();
			if(handler.consultaAuto(((Factura) panelToObject()).getPatente()) != null) {
				handler.altaFactura(((Factura) panelToObject()));
				limpiarCampos();
			}
		} catch (NumberFormatException nf) {
			handler.mostrarError(new NumberFormatException("Atencion! El precio debe ser un numero"));
		} catch (CamposVaciosException e) {
			handler.campoVacioMensaje("Debe completar todos los campos");
			e.printStackTrace();
		}
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
