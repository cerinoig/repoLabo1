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
				handler.altaAuto((Auto) panelToObject());
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
	public Object panelToObject() {
		Auto auto = new Auto();
		auto.setPatente(patenteTextField.getText().toUpperCase());
		auto.setMarca(marcaTextField.getText());
		auto.setModelo(modeloTextField.getText());
		auto.setColor(colorTextField.getText());

		try {
			Integer.valueOf(puertasTextField.getText());
			puertasTextField.setBackground(Color.WHITE);
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
			puertasTextField.setBackground(Color.RED);
			throw new NumberFormatException("La cantidad de puertas no es un numero");
		}

		auto.setCantidadPuertas(Integer.valueOf(puertasTextField.getText()));

		try {
			Integer.valueOf(kilometrosTextField.getText());
			kilometrosTextField.setBackground(Color.WHITE);
		} catch (Exception e3) {
			e3.printStackTrace();
			kilometrosTextField.setBackground(Color.RED);
			throw new NumberFormatException("La cantidad de KM no es un numero");
		}

		auto.setKilometraje(Integer.valueOf(kilometrosTextField.getText()));

		auto.setAño(añoTextField.getText());
		return auto;
	}

	@Override
	public void objectToPanel(Object object) {
		// TODO Auto-generated method stub

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
}
