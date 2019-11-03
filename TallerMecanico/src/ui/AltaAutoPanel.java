package ui;

import java.awt.Color;

import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class AltaAutoPanel extends AltaDatosPanel {

	private static final long serialVersionUID = 1L;

	public AltaAutoPanel(Handler handler) {
		super(handler, "auto", "Año", "Cantidad Puertas", "Color", "KM", "Marca", "Modelo", "Patente");
	}

	@Override
	public void cargaDatos(Handler handler, String textF1, String textF2, String textF3, String textF4, String textF5,
			String textF6, String textF7) {

		Auto auto = new Auto();

		if (!textF1.equals("")) {
			auto.setAño(textF1);
			((JTextField) super.datos1.getComponent(2)).setBackground(Color.WHITE);
		} else {
			((JTextField) super.datos1.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF2.equals("")) {
			try {
				auto.setCantidadPuertas(Integer.valueOf(textF2));
				((JTextField) super.datos2.getComponent(2)).setBackground(Color.WHITE);
			} catch (Exception e3) {
				System.out.println("no es un numero las puertas");
				e3.printStackTrace();
				((JTextField) super.datos2.getComponent(2)).setBackground(Color.RED);
			}
		} else {
			((JTextField) super.datos2.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF3.equals("")) {
			auto.setColor(textF3);
			((JTextField) super.datos3.getComponent(2)).setBackground(Color.WHITE);
		} else {
			((JTextField) super.datos3.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF4.equals("")) {
			try {
				auto.setKilometraje(Integer.valueOf(textF4));
				((JTextField) datos4.getComponent(2)).setBackground(Color.WHITE);
			} catch (Exception e1) {
				System.out.println("no es un numero de KM");
				e1.printStackTrace();
				((JTextField) datos4.getComponent(2)).setBackground(Color.RED);
			}
		} else {
			((JTextField) datos4.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF5.equals("")) {
			auto.setMarca(textF5);
			((JTextField) datos5.getComponent(2)).setBackground(Color.WHITE);
		} else {
			((JTextField) datos5.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF6.equals("")) {
			auto.setModelo(textF6);
			((JTextField) datos6.getComponent(2)).setBackground(Color.WHITE);
		} else {
			((JTextField) datos6.getComponent(2)).setBackground(Color.RED);
		}

		if (!textF7.equals("")) {
			auto.setPatente(textF7);
			((JTextField) datos7.getComponent(2)).setBackground(Color.WHITE);
		} else {
			((JTextField) datos7.getComponent(2)).setBackground(Color.RED);
		}

		handler.altaAuto(auto);
	}
}
