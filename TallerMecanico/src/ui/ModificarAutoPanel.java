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

public class ModificarAutoPanel extends AutoPanel {

	private static final long serialVersionUID = 1L;
	private Auto auto = new Auto();

	public ModificarAutoPanel(Handler handler) {
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
	public void habilitarCampos() {
		marcaTextField.setEditable(true);
		marcaTextField.setBackground(Color.WHITE);
		modeloTextField.setEditable(true);
		modeloTextField.setBackground(Color.WHITE);
		colorTextField.setEditable(true);
		colorTextField.setBackground(Color.WHITE);
		puertasTextField.setEditable(true);
		puertasTextField.setBackground(Color.WHITE);
		kilometrosTextField.setEditable(true);
		kilometrosTextField.setBackground(Color.WHITE);
		a�oTextField.setEditable(true);
		a�oTextField.setBackground(Color.WHITE);
	}

	@Override
	public Object panelToObject() {
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
			new NumberFormatException("La cantidad de puertas no es un numero");
		}

		auto.setCantidadPuertas(Integer.valueOf(puertasTextField.getText()));

		try {
			Integer.valueOf(kilometrosTextField.getText());
			kilometrosTextField.setBackground(Color.WHITE);
		} catch (Exception e3) {
			e3.printStackTrace();
			kilometrosTextField.setBackground(Color.RED);
			new NumberFormatException("La cantidad de KM no es un numero");
		}

		auto.setKilometraje(Integer.valueOf(kilometrosTextField.getText()));
		auto.setA�o(a�oTextField.getText());
		return auto;
	}

	@Override
	public void objectToPanel(Object object) {
		patenteTextField.setText(((Auto) object).getPatente());
		marcaTextField.setText(((Auto) object).getMarca());
		modeloTextField.setText(((Auto) object).getModelo());
		colorTextField.setText(((Auto) object).getColor());
		puertasTextField.setText(String.valueOf(((Auto) object).getCantidadPuertas()));
		kilometrosTextField.setText(String.valueOf(((Auto) object).getKilometraje()));
		a�oTextField.setText(((Auto) object).getA�o());
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("MODIFICAR AUTOS");
	}

	@Override
	public Box getBody() {
		initTextFields();
		deshabilitarCampos();
		String[] labels = { "Buscar auto", "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros",
				"A�o" };
		JTextField[] textFields = { buscarTextfield, patenteTextField, marcaTextField, modeloTextField, colorTextField,
				puertasTextField, kilometrosTextField, a�oTextField };

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
		a�oTextField = new JTextField();
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
			handler.modificarAuto((Auto) panelToObject());
			limpiarCampos();
			deshabilitarCampos();
		} catch (NumberFormatException nf) {
			handler.mostrarError(new NumberFormatException("Atencion! Debe ser un numero"));
		}
	}

	@Override
	public void accionBuscar(Handler handler) {
		if (handler.consultaAuto(buscarTextfield.getText()) != null) {
			objectToPanel(handler.consultaAuto(buscarTextfield.getText().toUpperCase()));
			habilitarCampos();
			confirmarBoton.setEnabled(true);
		}
	}
}
