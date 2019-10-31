package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import handler.Handler;

public abstract class EliminarDatosPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected Box datos1;
	protected Box botonera;
	protected Box vertical;

	public EliminarDatosPanel(Handler handler, String titulo1) {
		initUI(handler, titulo1);
	}

	public void initUI(Handler handler, String titulo1) {

		setLayout(new BorderLayout());

		datos1 = Box.createHorizontalBox();
		datos1.add(Box.createHorizontalStrut(190));
		JLabel tituloLabel = new JLabel(titulo1);
		datos1.add(tituloLabel);
		datos1.add(Box.createHorizontalStrut(20));
		datos1.add(new JTextField(20));
		datos1.add(Box.createHorizontalStrut(230));

		botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(new JButton("Eliminar"));
		botonera.add(Box.createHorizontalStrut(10));
		botonera.add(new JButton("Cancelar"));

		vertical = Box.createVerticalBox();
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

		((JButton) botonera.getComponent(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				eliminarDatos(handler);
			}

		});

	}

	public void eliminarDatos(Handler handler) {}

}
