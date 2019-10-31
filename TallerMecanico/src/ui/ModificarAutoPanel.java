package ui;

import java.awt.Color;

import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class ModificarAutoPanel extends ModificarDatosPanel {

	public ModificarAutoPanel(Handler handler) {

		super(handler, "Patente", "Cantidad Puertas", "Color", "KM", "Marca", "Modelo", "Año");

	}
	
	
	@Override
	public void modificarDatos(Handler handler, String textF1, String textF2, String textF3, String textF4, String textF5,
			String textF6, String textF7){
		
		Auto auto = new Auto();
		auto.setAño(textF1);

		try {
			auto.setCantidadPuertas(Integer.valueOf(textF2));
		} catch (Exception e3) {
			System.out.println("no es un numero las puertas");
			e3.printStackTrace();
			((JTextField) datos2.getComponent(2)).setBackground(Color.RED);

		}

		auto.setColor(textF3);

		try {
			auto.setKilometraje(Integer.valueOf(textF4));

		} catch (Exception e1) {
			System.out.println("no es un numero de KM");
			e1.printStackTrace();
			((JTextField) datos4.getComponent(2)).setBackground(Color.RED);

		}

		auto.setMarca(textF5);
		auto.setModelo(textF6);
		auto.setPatente(textF7);

		handler.modificarAuto(auto);

	}

}
