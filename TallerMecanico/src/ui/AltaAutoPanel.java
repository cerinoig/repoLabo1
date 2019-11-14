package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class AltaAutoPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	private JButton guardarBoton = new JButton("Guardar");
	private JButton cancelarBoton = new JButton("Cancelar");

	public AltaAutoPanel(Handler handler) {
		super(handler);

		initPanel(handler);
	}

	public void initPanel(Handler handler) {
		crearTituloPantalla("ALTA AUTOS");

		String[] labels = { "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros", "Año" };
		JButton[] botones = { guardarBoton, cancelarBoton };

		JTextField patenteTextField = new JTextField();
		JTextField marcaTextField = new JTextField();
		JTextField modeloTextField = new JTextField();
		JTextField colorTextField = new JTextField();
		JTextField puertasTextField = new JTextField();
		JTextField kilometrosTextField = new JTextField();
		JTextField añoTextField = new JTextField();

		JTextField[] textFields = { patenteTextField, marcaTextField, modeloTextField, colorTextField, puertasTextField,
				kilometrosTextField, añoTextField };

		crearBoxVertical(labels, textFields);
		crearBotonera(botones);

		guardarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Auto auto = new Auto();
				auto.setPatente(patenteTextField.getText());
				auto.setMarca(marcaTextField.getText().toString());
				auto.setModelo(modeloTextField.getText());
				auto.setColor(colorTextField.getText());

				try {
					auto.setCantidadPuertas(Integer.valueOf(puertasTextField.getText()));
				} catch (Exception e3) {
					throw new NumberFormatException("No es un numero");
				}

				try {
					auto.setKilometraje(Integer.valueOf(kilometrosTextField.getText()));
				} catch (Exception e3) {
					throw new NumberFormatException("No es un numero");
				}

				auto.setAño(añoTextField.getText());

				handler.altaAuto(auto);
			}
		});

		cancelarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
	}
}
