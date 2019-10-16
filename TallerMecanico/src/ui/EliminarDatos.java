package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import handler.Handler;

public class EliminarDatos extends JPanel {

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
/* ACA todo el asunto de elminiar auto una vez que mati haga el de elimnar jaja
					try {
						handler.eliminarAuto(((JTextField) datos1.getComponent(2)).getText().toString());
						MessageDialog.datosCargados();
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						MessageDialog.errorCarga();
					} catch (NoIdObtainedException nio) {
						System.out.println("error generico id");
						nio.printStackTrace();
						MessageDialog.errorCarga();
					} catch (ExistingCarException e1) {
						System.out.println("Auto ya existe");
						e1.printStackTrace();
						MessageDialog.autoExiste();
					
					}*/
				default:
					// code block
				}
				
			}
			
		});

	}

}
