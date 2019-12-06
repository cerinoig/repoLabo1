package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

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
				accionConfirmar(handler);
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
		precioTextField.setText("");
	}

	@Override
	public Object panelToObject() {
		Factura factura = new Factura();
		factura.setArreglo(arregloTextField.getText().trim());
		factura.setPatente(patenteTextField.getText().trim().toUpperCase());
		try {
			factura.setCostoAreglo(
					//Double.parseDouble(precioTextField.getText().replace("$", "").replace(".", "").replace(",", ".")));
					Double.parseDouble(truncateDecimal(Double.parseDouble(String.valueOf(precioTextField.getText().trim().replace("$", ""))),2).toString()));
			System.out.println(truncateDecimal(Double.parseDouble(String.valueOf(precioTextField.getText().trim().replace("$", ""))),2).toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new NumberFormatException("Debe ingresar un importe v�lido");
		}

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
			handler.altaFactura(((Factura) panelToObject()));
			limpiarCampos();
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

	
	
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
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
