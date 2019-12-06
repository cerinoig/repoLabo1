package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Auto;
import entidades.Factura;
import handler.Handler;

public class ModificarFacturaPanel extends FacturaPanel {

	private static final long serialVersionUID = 1L;
	private Factura factura = new Factura();

	public ModificarFacturaPanel(Handler handler) {
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

		factura.setPatente(patenteTextField.getText().trim().toUpperCase());
		factura.setArreglo(arregloTextField.getText().trim());

		try {
			factura.setCostoAreglo(Double.valueOf(precioTextField.getText().trim()));
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
			throw new NumberFormatException("El precio no es un numero");
		}

		return factura;
	}

	@Override
	public void objectToPanel(Object object) {

		patenteTextField.setText(((Factura) object).getPatente());
		arregloTextField.setText(((Factura) object).getArreglo());
		precioTextField.setText(String.valueOf(((Factura) object).getCostoAreglo()));
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("MODIFICAR FACTURAS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		deshabilitarCampos();
		String[] labels = { "Buscar factura", "Patente", "Arreglo", "Precio" };
		JTextField[] textFields = { buscarTextfield, patenteTextField, arregloTextField, precioTextField };

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
		buscarBoton = new JButton("Buscar");
		confirmarBoton = new JButton("Modificar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		try {
			handler.modificarFactura((Factura) panelToObject());
			limpiarCampos();
			deshabilitarCampos();
		} catch (NumberFormatException nf) {
			handler.mostrarError(new NumberFormatException("Atencion! El precio debe ser un numero"));
		}

	}

	@Override
	public void accionBuscar(Handler handler) {
		int idFactura = 0;

		try {
			idFactura = Integer.valueOf(buscarTextfield.getText().trim());
			if (handler.consultaFactura(idFactura) != null) {
				objectToPanel(handler.consultaFactura(idFactura));
				habilitarCampos();
				confirmarBoton.setEnabled(true);
			}
		} catch (NumberFormatException nf) {
			handler.mostrarError(new NumberFormatException("Atencion! Debe ser un numero"));
		}
	}

	@Override
	public void habilitarCampos() {
		patenteTextField.setEditable(true);
		patenteTextField.setBackground(Color.WHITE);
		arregloTextField.setEditable(true);
		arregloTextField.setBackground(Color.WHITE);
		precioTextField.setEditable(true);
		precioTextField.setBackground(Color.WHITE);
	}
}
