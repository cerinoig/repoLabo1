package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class ModificarAutoPanel extends ModificarDatosPanel {

	private static final long serialVersionUID = 1L;
	private Auto auto;

	public ModificarAutoPanel(Handler handler) {
		super(handler, "Patente", "Cantidad Puertas", "Color", "KM", "Marca", "Modelo", "Año");
		auto = new Auto();
	}

	@Override
	public void traerDatos(Handler handler, String textF1, String textF2, String textF3, String textF4, String textF5,
			String textF6, String textF7) {

		auto = handler.consultaAuto(((JTextField) datos1.getComponent(2)).getText().toString());

		if (!((JButton) botonera.getComponent(1)).isVisible())
			((JButton) botonera.getComponent(1)).setVisible(true);

		if (datos2.getComponentCount() > 2) {
			((JTextField) datos2.getComponent(2)).setEditable(true);
			((JTextField) datos2.getComponent(2)).setText(String.valueOf(auto.getCantidadPuertas()));
		}

		if (datos3.getComponentCount() > 2) {
			((JTextField) datos3.getComponent(2)).setEditable(true);
			((JTextField) datos3.getComponent(2)).setText(auto.getColor());
		}

		if (datos4.getComponentCount() > 2) {
			((JTextField) datos4.getComponent(2)).setEditable(true);
			((JTextField) datos4.getComponent(2)).setText(String.valueOf(auto.getKilometraje()));
		}

		if (datos5.getComponentCount() > 2) {
			((JTextField) datos5.getComponent(2)).setEditable(true);
			((JTextField) datos5.getComponent(2)).setText(auto.getMarca());
		}

		if (datos6.getComponentCount() > 2) {
			((JTextField) datos6.getComponent(2)).setEditable(true);
			((JTextField) datos6.getComponent(2)).setText(auto.getModelo());
		}

		if (datos7.getComponentCount() > 2) {
			((JTextField) datos7.getComponent(2)).setEditable(true);
			((JTextField) datos7.getComponent(2)).setText(auto.getAño());
		}

	}

	@Override
	public void modificarDatos(Handler handler) {

		String textF1 = "";
		String textF2 = "";
		String colorText = "";
		String textF4 = "";
		String textF5 = "";
		String textF6 = "";
		String textF7 = "";

		if (datos1.getComponentCount() > 2)
			textF1 = ((JTextField) datos1.getComponent(2)).getText().toString();
		if (datos2.getComponentCount() > 2)
			textF2 = ((JTextField) datos2.getComponent(2)).getText().toString();
		if (datos3.getComponentCount() > 2)
			colorText = ((JTextField) datos3.getComponent(2)).getText().toString();
		if (datos4.getComponentCount() > 2)
			textF4 = ((JTextField) datos4.getComponent(2)).getText().toString();
		if (datos5.getComponentCount() > 2)
			textF5 = ((JTextField) datos5.getComponent(2)).getText().toString();
		if (datos6.getComponentCount() > 2)
			textF6 = ((JTextField) datos6.getComponent(2)).getText().toString();
		if (datos7.getComponentCount() > 2)
			textF7 = ((JTextField) datos7.getComponent(2)).getText().toString();

		auto.setColor(colorText);

		try {
			auto.setCantidadPuertas(Integer.valueOf(textF2));
		} catch (Exception e3) {
			System.out.println("no es un numero las puertas");
			e3.printStackTrace();
			((JTextField) datos2.getComponent(2)).setBackground(Color.RED);
		}

		try {
			auto.setKilometraje(Integer.valueOf(textF4));

		} catch (Exception e1) {
			System.out.println("no es un numero de KM");
			e1.printStackTrace();
			((JTextField) datos4.getComponent(2)).setBackground(Color.RED);
		}

		auto.setMarca(textF5);
		auto.setModelo(textF6);
		auto.setPatente(textF1);

		handler.modificarAuto(auto);

	}

}
