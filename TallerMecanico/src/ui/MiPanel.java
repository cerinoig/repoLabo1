package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.CamposVaciosException;
import handler.Handler;

public abstract class MiPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField buscarTextfield;

	protected JButton confirmarBoton;
	protected JButton cancelarBoton;
	protected JButton buscarBoton;

	public MiPanel(Handler handler) {

		setLayout(new BorderLayout());

		add(getTituloPanel(), BorderLayout.NORTH);
		add(getBody(), BorderLayout.CENTER);
		add(crearBotonera(getBotones()), BorderLayout.SOUTH);
		initPanel(handler);

		cancelarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
	}

	public Box crearBoxHorizontal(String titulo, JTextField jTextField) {
		Box box = Box.createHorizontalBox();
		box.add(new JLabel(titulo));
		box.add(Box.createHorizontalStrut(10));
		box.add(jTextField);
		return box;
	}

	public Box crearBoxVertical(String[] titulosBoxes, JTextField[] textFields) {
		Box vertical = Box.createVerticalBox();
		for (int i = 0; i < titulosBoxes.length; i++) {
			vertical.add(Box.createVerticalStrut(20));
			vertical.add(crearBoxHorizontal(titulosBoxes[i], textFields[i]));
		}
		return vertical;
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

	public abstract void initPanel(Handler handler);

	public abstract void initTextFields();

	public abstract void initButtons();

	public abstract void accionConfirmar(Handler handler);

	public abstract void accionBuscar(Handler handler);

	public abstract void deshabilitarCampos();

	public abstract void habilitarCampos();
	
	public abstract void revisarCamposVacios() throws CamposVaciosException;

}
