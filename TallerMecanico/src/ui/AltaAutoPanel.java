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

	private JButton guardarBoton = new JButton("Guardar");
	private JButton cancelarBoton = new JButton("Cancelar");

	public AltaAutoPanel(Handler handler) {
		super(handler);
		initPanel(handler);
	}

	public void initPanel(Handler handler) {

		final String[] labels = { "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros", "Año" };
		JButton[] botones = { guardarBoton, cancelarBoton };

		JTextField[] textFields = { patenteTextField, marcaTextField, modeloTextField, colorTextField, puertasTextField,
				kilometrosTextField, añoTextField };

		crearBoxVertical(labels, textFields);
		crearBotonera(botones);

		guardarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.altaAuto((Auto) panelToObject());
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
		auto.setMarca(marcaTextField.getText().toString());
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
		// TODO Auto-generated method stub

	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("ALTA AUTOS");
	}

	@Override
	public Box getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton[] getBotones() {
		// TODO Auto-generated method stub
		return null;
	}
}
