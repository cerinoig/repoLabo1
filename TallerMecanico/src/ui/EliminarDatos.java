package ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import handler.Handler;

public class EliminarDatos extends JPanel {

	public EliminarDatos(Handler handler, String titulo1) {
		initUI(handler, titulo1);
	}

	public void initUI(Handler handler, String titulo1) {

		setLayout(new BorderLayout());

		Box datos1 = Box.createHorizontalBox();
		datos1.add(Box.createHorizontalStrut(190));
		JLabel tituloLabel = new JLabel(titulo1);
		datos1.add(tituloLabel);
		datos1.add(Box.createHorizontalStrut(20));
		datos1.add(new JTextField(20));
		datos1.add(Box.createHorizontalStrut(230));

		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(new JButton("Ok"));
		botonera.add(Box.createHorizontalStrut(10));
		botonera.add(new JButton("Cancel"));

		Box vertical = Box.createVerticalBox();
		vertical.add(Box.createVerticalStrut(100));
		vertical.add(datos1);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(Box.createVerticalStrut(50));
		vertical.add(botonera);

		add(vertical, BorderLayout.CENTER);

		JLabel tituloTitulo = new JLabel(
				"--------------------------------------------------------         ELIMINAR DATOS         ---------------------------------------------------------------------");
		add(tituloTitulo, BorderLayout.NORTH);

	}

}
