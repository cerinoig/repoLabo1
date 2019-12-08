package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class AltaAutoPanel extends AutoPanel {

	private static final long serialVersionUID = 1L;

	public AltaAutoPanel(Handler handler) {
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
	public Object panelToObject() {
		Auto auto = new Auto();
		auto.setPatente(patenteTextField.getText().trim().toUpperCase());
		auto.setMarca(marcaTextField.getText().trim());
		auto.setModelo(modeloTextField.getText().trim());
		auto.setColor(colorTextField.getText().trim());

		try {
			Integer.valueOf(puertasTextField.getText().trim());
			puertasTextField.setBackground(Color.WHITE);
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
			puertasTextField.setBackground(Color.RED);
			throw new NumberFormatException("La cantidad de puertas no es un numero");
		}

		auto.setCantidadPuertas(Integer.valueOf(puertasTextField.getText()));

		try {
			Integer.valueOf(kilometrosTextField.getText().trim());
			kilometrosTextField.setBackground(Color.WHITE);
		} catch (Exception e3) {
			e3.printStackTrace();
			kilometrosTextField.setBackground(Color.RED);
			throw new NumberFormatException("La cantidad de KM no es un numero");
		}

		auto.setKilometraje(Integer.valueOf(kilometrosTextField.getText().trim()));

		auto.setAño(añoTextField.getText().trim());
		return auto;
	}

	@Override
	public void objectToPanel(Object object) {

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
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("ALTA AUTOS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		final String[] labels = { "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros", "Año" };
		JTextField[] textFields = { patenteTextField, marcaTextField, modeloTextField, colorTextField, puertasTextField,
				kilometrosTextField, añoTextField };

		return crearBoxVertical(labels, textFields);
	}

	@Override
	public JButton[] getBotones() {

		initButtons();
		JButton[] botones = { confirmarBoton, cancelarBoton };
		return botones;
	}

	@Override
	public void initTextFields() {
		patenteTextField = new JTextField();
		marcaTextField = new JTextField();
		modeloTextField = new JTextField();
		colorTextField = new JTextField();
		puertasTextField = new JTextField();
		kilometrosTextField = new JTextField();
		añoTextField = new JTextField();
	}

	@Override
	public void initButtons() {
		confirmarBoton = new JButton("Guardar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
	try{
		handler.altaAuto((Auto) panelToObject());
		limpiarCampos();
	} catch (NumberFormatException nf) {
		handler.mostrarError(new NumberFormatException("Atencion! Debe ser un numero"));
	}
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
}
