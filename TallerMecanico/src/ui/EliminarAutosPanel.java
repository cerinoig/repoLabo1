package ui;

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
		patenteTextField.setText(((Auto) object).getPatente());
		marcaTextField.setText(((Auto) object).getMarca());
		modeloTextField.setText(((Auto) object).getModelo());
		colorTextField.setText(((Auto) object).getColor());
		puertasTextField.setText(String.valueOf(((Auto) object).getCantidadPuertas()));
		kilometrosTextField.setText(String.valueOf(((Auto) object).getKilometraje()));
		añoTextField.setText(((Auto) object).getAño());
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
	public void initButtons() {
		buscarBoton = new JButton("Buscar");
		confirmarBoton = new JButton("Eliminar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public void accionConfirmar(Handler handler) {
		handler.deleteAuto(patenteTextField.getText().toUpperCase());
		limpiarCampos();
	}

	@Override
	public void accionBuscar(Handler handler) {
		if (handler.consultaAuto(buscarTextfield.getText()) != null) {
			objectToPanel(handler.consultaAuto(buscarTextfield.getText().toUpperCase()));
			confirmarBoton.setEnabled(true);
		}
	}

	@Override
	public void habilitarCampos() {
	}
}
