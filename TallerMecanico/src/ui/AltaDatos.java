package ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import handler.Handler;

public class AltaDatos extends JPanel {

	public AltaDatos(Handler handler, String titulo1, String titulo2, String titulo3, String titulo4, String titulo5,
			String titulo6, String titulo7) {
		initUI(handler, titulo1, titulo2, titulo3, titulo4, titulo5, titulo6, titulo7);
	}

	public void initUI(Handler handler, String titulo1, String titulo2, String titulo3, String titulo4, String titulo5,
			String titulo6, String titulo7) {

		setLayout(new BorderLayout());

		Box datos1 = Box.createHorizontalBox();
		JLabel tituloLabel = new JLabel(titulo1);
		datos1.add(tituloLabel);
		datos1.add(Box.createHorizontalStrut(10));
		datos1.add(new JTextField(30));

		Box datos2 = Box.createHorizontalBox();
		JLabel tituloLabel2 = new JLabel(titulo2);
		datos2.add(tituloLabel2);
		datos2.add(Box.createHorizontalStrut(10));
		datos2.add(new JTextField(30));

		Box datos3 = Box.createHorizontalBox();
		JLabel tituloLabel3 = new JLabel(titulo3);
		datos3.add(tituloLabel3);
		datos3.add(Box.createHorizontalStrut(10));
		datos3.add(new JTextField(30));

		Box datos4 = Box.createHorizontalBox();
		JLabel tituloLabel4 = new JLabel(titulo4);
		datos4.add(tituloLabel4);
		datos4.add(Box.createHorizontalStrut(10));
		datos4.add(new JTextField(30));

		Box datos5 = Box.createHorizontalBox();
		JLabel tituloLabel5 = new JLabel(titulo5);
		datos5.add(tituloLabel5);
		datos5.add(Box.createHorizontalStrut(10));
		datos5.add(new JTextField(30));

		Box datos6 = Box.createHorizontalBox();
		JLabel tituloLabel6 = new JLabel(titulo6);
		datos6.add(tituloLabel6);
		datos6.add(Box.createHorizontalStrut(10));
		datos6.add(new JTextField(30));

		Box datos7 = Box.createHorizontalBox();
		JLabel tituloLabel7 = new JLabel(titulo7);
		datos7.add(tituloLabel7);
		datos7.add(Box.createHorizontalStrut(10));
		datos7.add(new JTextField(30));

		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(new JButton("Ok"));
		botonera.add(Box.createHorizontalStrut(10));
		botonera.add(new JButton("Cancel"));

		Box vertical = Box.createVerticalBox();
		vertical.add(datos1);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos2);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos3);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos4);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos5);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos6);
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos7);
		vertical.add(Box.createVerticalStrut(30));
		vertical.add(botonera);

		add(vertical, BorderLayout.CENTER);

		JLabel tituloTitulo = new JLabel(
				"--------------------------------------------------------         CARGA DE DATOS         ---------------------------------------------------------------------");
		add(tituloTitulo, BorderLayout.NORTH);

		JLabel space = new JLabel("__________________________________________");
		add(space, BorderLayout.EAST);

	}

}
