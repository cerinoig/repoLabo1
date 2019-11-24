package ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import handler.Handler;

public abstract class MiPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MiPanel(Handler handler) {
		setLayout(new BorderLayout());
		
		add(getTituloPanel(), BorderLayout.NORTH);
		add(getBody());
		add(crearBotonera(getBotones()));
		
	}

	public Box crearBoxHorizontal(String titulo, JTextField jTextField) {
		Box box = Box.createHorizontalBox();
		box.add(new JLabel(titulo));
		box.add(Box.createHorizontalStrut(10));
		box.add(jTextField);
		return box;
	}

	public void crearBoxVertical(String[] titulosBoxes, JTextField[] textFields) {
		Box vertical = Box.createVerticalBox();
		for (int i = 0; i < titulosBoxes.length; i++) {
			vertical.add(Box.createVerticalStrut(20));
			vertical.add(crearBoxHorizontal(titulosBoxes[i], textFields[i]));
		}
		add(vertical, BorderLayout.CENTER);
	}

	public Box crearBotonera(JButton[] botones) {
		Box horizontal = Box.createHorizontalBox();
		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());

		for (int i = 0; i < botones.length; i++) {
			botonera.add(Box.createHorizontalStrut(10));
			botonera.add(botones[i]);
		}

		horizontal.add(botonera);
		add(horizontal, BorderLayout.SOUTH);
		
		return horizontal;
	}
	
	public abstract void limpiarCampos();
	
	public abstract Object panelToObject();
	
	public abstract void objectToPanel(Object object);
	
	public abstract JLabel getTituloPanel();
	
	public abstract Box getBody();
	
	public abstract JButton[] getBotones();
	
}
