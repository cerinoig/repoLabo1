package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.NonExistingCarException;
import handler.Handler;

public class EliminarDatos extends JPanel {

	private static final long serialVersionUID = 1L;

	public EliminarDatos(Handler handler, String tipo, String titulo1) {
		initUI(handler, tipo, titulo1);
	}

	public void initUI(Handler handler, String tipo, String titulo1) {

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
		botonera.add(new JButton("Eliminar"));
		botonera.add(Box.createHorizontalStrut(10));
		botonera.add(new JButton("Cancelar"));

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

		((JButton) botonera.getComponent(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (tipo) {

				case "auto":
					try {
						handler.deleteAuto(((JTextField) datos1.getComponent(3)).getText().toString());
						MessageDialog.datosCargados();
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						MessageDialog.errorCarga();
					} catch (NonExistingCarException e1) {
						e1.printStackTrace();
						MessageDialog.autoNoExiste();
					}
				default:
					// code block
				}

			}

		});

	}

}
