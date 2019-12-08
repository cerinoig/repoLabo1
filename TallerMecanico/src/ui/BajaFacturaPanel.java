package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Factura;
import handler.Handler;

public class BajaFacturaPanel extends FacturaPanel {

	private static final long serialVersionUID = 1L;

	public BajaFacturaPanel(Handler handler) {
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
		return null;
	}

	@Override
	public void objectToPanel(Object object) {
		idFacturaTextField.setText(String.valueOf(((Factura) object).getIdFactura()));
		patenteTextField.setText(((Factura) object).getPatente());
		arregloTextField.setText(((Factura) object).getArreglo());
		precioTextField.setText(String.valueOf(((Factura) object).getCostoAreglo().setScale(2, RoundingMode.HALF_EVEN).toString().replace(".",  ",")));
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("ELIMINAR FACTURAS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		deshabilitarCampos();
		String[] labels = { "Buscar factura", "Cod Factura", "Patente", "Arreglo", "Precio" };
		JTextField[] textFields = { buscarTextfield, idFacturaTextField, patenteTextField, arregloTextField,
				precioTextField };

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
		confirmarBoton = new JButton("Eliminar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		try {
			Integer.valueOf(idFacturaTextField.getText());
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
			new NumberFormatException("El codigo de la factura no es un numero");
		}

		int opcionElegida = JOptionPane.showOptionDialog(null,
				"Esta seguro que desea eliminar la factura n° " + idFacturaTextField.getText().trim(), "Baja de facturas",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (opcionElegida == JOptionPane.OK_OPTION) {
			handler.deleteFactura(Integer.valueOf(Integer.valueOf(idFacturaTextField.getText())));
			limpiarCampos();
		}
	}

	@Override
	public void accionBuscar(Handler handler) {

		try {
			Integer.valueOf(buscarTextfield.getText().trim());
		} catch (NumberFormatException nf) {
			handler.mostrarError(new NumberFormatException("Atencion! Debe ser un numero"));
		}

		if (handler.consultaFactura(Integer.valueOf(buscarTextfield.getText().trim())) != null) {
			objectToPanel(handler.consultaFactura(Integer.valueOf(buscarTextfield.getText().trim())));
			confirmarBoton.setEnabled(true);
		}
	}

	@Override
	public void habilitarCampos() {
	}

	@Override
	public void limpiarCampos() {
		super.limpiarCampos();
		buscarTextfield.setText("");
		idFacturaTextField.setText("");
	}
}
