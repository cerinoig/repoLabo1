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

public class EliminarAutosPanel extends AutoPanel {

	private static final long serialVersionUID = 1L;

	public EliminarAutosPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initPanel(Handler handler) {

		buscarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (handler.consultaAuto(buscarTextfield.getText()) != null) {
					objectToPanel(handler.consultaAuto(buscarTextfield.getText().toUpperCase()));
					confirmarBoton.setEnabled(true);
				}
			}
		});

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.deleteAuto(patenteTextField.getText().toUpperCase());
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

	public void deshabilitarCampos() {
		patenteTextField.setEditable(false);
		patenteTextField.setBackground(Color.LIGHT_GRAY);
		marcaTextField.setEditable(false);
		marcaTextField.setBackground(Color.LIGHT_GRAY);
		modeloTextField.setEditable(false);
		modeloTextField.setBackground(Color.LIGHT_GRAY);
		colorTextField.setEditable(false);
		colorTextField.setBackground(Color.LIGHT_GRAY);
		puertasTextField.setEditable(false);
		puertasTextField.setBackground(Color.LIGHT_GRAY);
		kilometrosTextField.setEditable(false);
		kilometrosTextField.setBackground(Color.LIGHT_GRAY);
		añoTextField.setEditable(false);
		añoTextField.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public Object panelToObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void objectToPanel(Object object) {

		patenteTextField.setText(((Auto) object).getPatente());
		marcaTextField.setText(((Auto) object).getMarca());
		modeloTextField.setText(((Auto) object).getModelo());
		colorTextField.setText(((Auto) object).getColor());
		puertasTextField.setText(String.valueOf(((Auto) object).getCantidadPuertas()));
		kilometrosTextField.setText(String.valueOf(((Auto) object).getKilometraje()));
		añoTextField.setText(((Auto) object).getAño());

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
		return new JLabel("ELIMINAR AUTOS");
	}

	@Override
	public Box getBody() {

		initTextFields();
		deshabilitarCampos();
		String[] labels = { "Buscar auto", "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros",
				"Año" };
		JTextField[] textFields = { buscarTextfield, patenteTextField, marcaTextField, modeloTextField, colorTextField,
				puertasTextField, kilometrosTextField, añoTextField };

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
	public void initTextFields() {

		buscarTextfield = new JTextField();
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

		buscarBoton = new JButton("Eliminar");
		confirmarBoton = new JButton("Confirmar");
		cancelarBoton = new JButton("Cancelar");

	}
}
