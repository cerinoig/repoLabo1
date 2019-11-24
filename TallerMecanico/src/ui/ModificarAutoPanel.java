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

	private JTextField buscarTextfield = new JTextField();

	private JButton buscarBoton = new JButton("Buscar");
	private JButton modificarBoton = new JButton("Modificar");
	private JButton cancelarBoton = new JButton("Cancelar");

	private Auto auto = new Auto();

	public ModificarAutoPanel(Handler handler) {
		super(handler);
		initPanel(handler);
	}

	public void initPanel(Handler handler) {
		deshabilitarCampos();

		String[] labels = { "Buscar auto", "Patente", "Marca", "Modelo", "Color", "Cantidad de Puertas", "Kilometros",
				"A�o" };
		JButton[] botones = { buscarBoton, modificarBoton, cancelarBoton };
		JTextField[] textFields = { buscarTextfield, patenteTextField, marcaTextField, modeloTextField, colorTextField,
				puertasTextField, kilometrosTextField, a�oTextField };

		crearBoxVertical(labels, textFields);

		modificarBoton.setEnabled(false);

		crearBotonera(botones);

		buscarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultarDatos(handler);
				modificarBoton.setEnabled(true);
			}

		});

		modificarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
					handler.mostrarError(new NumberFormatException("La cantidad de puertas no es un numero"));
				}

				auto.setCantidadPuertas(Integer.valueOf(puertasTextField.getText()));

				try {
					Integer.valueOf(kilometrosTextField.getText());
					kilometrosTextField.setBackground(Color.WHITE);
				} catch (Exception e3) {
					e3.printStackTrace();
					kilometrosTextField.setBackground(Color.RED);
					handler.mostrarError(new NumberFormatException("La cantidad de KM no es un numero"));
				}

				auto.setKilometraje(Integer.valueOf(kilometrosTextField.getText()));

				auto.setA�o(a�oTextField.getText());
				handler.modificarAuto(auto);
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
		a�oTextField.setEditable(false);
		a�oTextField.setBackground(Color.LIGHT_GRAY);
	}

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

	private void consultarDatos(Handler handler) {
		if (handler.consultaAuto(buscarTextfield.getText()) != null) {
			auto = handler.consultaAuto(buscarTextfield.getText().toUpperCase());
			patenteTextField.setText(auto.getPatente());
			marcaTextField.setText(auto.getMarca());
			modeloTextField.setText(auto.getModelo());
			colorTextField.setText(auto.getColor());
			puertasTextField.setText(String.valueOf(auto.getCantidadPuertas()));
			kilometrosTextField.setText(String.valueOf(auto.getKilometraje()));
			a�oTextField.setText(auto.getA�o());

			habilitarCampos();
		}
	}

	@Override
	public Object panelToObject() {
		// TODO Auto-generated method stub
		return null;
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
		return new JLabel("MODIFICAR AUTOS");
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
