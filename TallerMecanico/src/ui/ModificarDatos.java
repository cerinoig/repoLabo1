package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Auto;
import handler.Handler;

public class ModificarDatos extends JPanel {

	private static final long serialVersionUID = 1L;

	public ModificarDatos(Handler handler, String tipoBuscar, String titulo1, String titulo2, String titulo3,
			String titulo4, String titulo5, String titulo6, String titulo7) {
		initUI(handler, tipoBuscar, titulo1, titulo2, titulo3, titulo4, titulo5, titulo6, titulo7);
	}

	public void initUI(Handler handler, String tipoBuscar, String titulo1, String titulo2, String titulo3,
			String titulo4, String titulo5, String titulo6, String titulo7) {

		setLayout(new BorderLayout());

		Box datos1 = Box.createHorizontalBox();
		JLabel tituloLabel = new JLabel(titulo1);
		datos1.add(tituloLabel);
		datos1.add(Box.createHorizontalStrut(10));
		datos1.add(new JTextField(30));

		Box botoneraBuscar = Box.createHorizontalBox();
		botoneraBuscar.add(Box.createHorizontalGlue());
		botoneraBuscar.add(new JButton("Buscar"));
		botoneraBuscar.add(Box.createHorizontalStrut(10));

		Box datos2 = Box.createHorizontalBox();
		JLabel tituloLabel2 = new JLabel(titulo2);
		datos2.add(tituloLabel2);
		datos2.add(Box.createHorizontalStrut(10));
		if (!titulo2.isEmpty()) {
			JTextField tf2 = new JTextField(30);
			tf2.setEditable(false);
			tf2.setBackground(Color.LIGHT_GRAY);
			datos2.add(tf2);
		}

		Box datos3 = Box.createHorizontalBox();
		JLabel tituloLabel3 = new JLabel(titulo3);
		datos3.add(tituloLabel3);
		datos3.add(Box.createHorizontalStrut(10));
		if (!titulo3.isEmpty()) {
			JTextField tf3 = new JTextField(30);
			tf3.setBackground(Color.LIGHT_GRAY);
			tf3.setEditable(false);
			datos3.add(tf3);
		}
		Box datos4 = Box.createHorizontalBox();
		JLabel tituloLabel4 = new JLabel(titulo4);
		datos4.add(tituloLabel4);
		datos4.add(Box.createHorizontalStrut(10));
		if (!titulo4.isEmpty()) {
			JTextField tf4 = new JTextField(30);
			tf4.setEditable(false);
			tf4.setBackground(Color.LIGHT_GRAY);
			datos4.add(tf4);
		}

		Box datos5 = Box.createHorizontalBox();
		JLabel tituloLabel5 = new JLabel(titulo5);
		datos5.add(tituloLabel5);
		datos5.add(Box.createHorizontalStrut(10));
		if (!titulo5.isEmpty()) {
			JTextField tf5 = new JTextField(30);
			tf5.setEditable(false);
			tf5.setBackground(Color.LIGHT_GRAY);
			datos5.add(tf5);
		}

		Box datos6 = Box.createHorizontalBox();
		JLabel tituloLabel6 = new JLabel(titulo6);
		datos6.add(tituloLabel6);
		datos6.add(Box.createHorizontalStrut(10));
		if (!titulo6.isEmpty()) {
			JTextField tf6 = new JTextField(30);
			tf6.setEditable(false);
			tf6.setBackground(Color.LIGHT_GRAY);
			datos6.add(tf6);
		}

		Box datos7 = Box.createHorizontalBox();
		JLabel tituloLabel7 = new JLabel(titulo7);
		datos7.add(tituloLabel7);
		datos7.add(Box.createHorizontalStrut(10));
		if (!titulo7.isEmpty()) {
			JTextField tf7 = new JTextField(30);
			tf7.setEditable(false);
			tf7.setBackground(Color.LIGHT_GRAY);
			datos7.add(tf7);
		}

		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(new JButton("Modificar"));
		((JButton) botonera.getComponent(1)).setVisible(false);
		botonera.add(Box.createHorizontalStrut(10));
		botonera.add(new JButton("Cancelar"));

		Box vertical = Box.createVerticalBox();
		vertical.add(Box.createVerticalStrut(20));
		vertical.add(datos1);
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(botoneraBuscar);
		vertical.add(Box.createVerticalStrut(10));
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
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(botonera);

		add(vertical, BorderLayout.CENTER);

		JLabel tituloTitulo = new JLabel(
				"--------------------------------------------------------         MODIFICACION DE DATOS         ---------------------------------------------------------------------");
		add(tituloTitulo, BorderLayout.NORTH);

		JLabel space = new JLabel("__________________________________________");
		add(space, BorderLayout.EAST);

		// Boton Buscar
		((JButton) botoneraBuscar.getComponent(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!((JButton) botonera.getComponent(1)).isVisible())
					((JButton) botonera.getComponent(1)).setVisible(true);

				switch (tipoBuscar) {

				case "auto":
					/*
					 * ACA todo el asunto de buscar el auto try {
					 * handler.buscarAuto(((JTextField)
					 * datos1.getComponent(2)).getText().toString()); } catch
					 * (SQLException sqle) { sqle.printStackTrace();
					 * MessageDialog.errorCarga(); } catch
					 * (NoIdObtainedException nio) { System.out.println(
					 * "error generico id"); nio.printStackTrace();
					 * MessageDialog.errorCarga(); } catch (ExistingCarException
					 * e1) { System.out.println("Auto ya existe");
					 * e1.printStackTrace(); MessageDialog.autoExiste();
					 * 
					 * }
					 */
				default:
					// code block
				}

				if (datos2.getComponentCount() > 2) {
					((JTextField) datos2.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos2.getComponent(2)).setText(auto.get());
				}

				if (datos3.getComponentCount() > 2) {
					((JTextField) datos3.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos3.getComponent(2)).setText(auto.get());
				}

				if (datos4.getComponentCount() > 2) {
					((JTextField) datos4.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos4.getComponent(2)).setText(auto.get());
				}

				if (datos5.getComponentCount() > 2) {
					((JTextField) datos5.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos5.getComponent(2)).setText(auto.get());
				}

				if (datos6.getComponentCount() > 2) {
					((JTextField) datos6.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos6.getComponent(2)).setText(auto.get());
				}

				if (datos7.getComponentCount() > 2) {
					((JTextField) datos7.getComponent(2)).setEditable(true);
					// ((JTextField)
					// datos7.getComponent(2)).setText(auto.get());
				}
			}

		});

		// Boton editar
		((JButton) botonera.getComponent(1)).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String textF1 = "";
				String textF2 = "";
				String textF3 = "";
				String textF4 = "";
				String textF5 = "";
				String textF6 = "";
				String textF7 = "";

				if (datos1.getComponentCount() > 2)
					textF1 = ((JTextField) datos1.getComponent(2)).getText().toString();
				if (datos2.getComponentCount() > 2)
					textF2 = ((JTextField) datos2.getComponent(2)).getText().toString();
				if (datos3.getComponentCount() > 2)
					textF3 = ((JTextField) datos3.getComponent(2)).getText().toString();
				if (datos4.getComponentCount() > 2)
					textF4 = ((JTextField) datos4.getComponent(2)).getText().toString();
				if (datos5.getComponentCount() > 2)
					textF5 = ((JTextField) datos5.getComponent(2)).getText().toString();
				if (datos6.getComponentCount() > 2)
					textF6 = ((JTextField) datos6.getComponent(2)).getText().toString();
				if (datos7.getComponentCount() > 2)
					textF7 = ((JTextField) datos7.getComponent(2)).getText().toString();

				switch (tipoBuscar) {

				case "auto":

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

				default:
					// code block
				}

			}
		});

	}

}
