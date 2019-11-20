package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import handler.Handler;

public class EliminarAutosPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	private JButton eliminarBoton = new JButton("Eliminar");
	private JButton cancelarBoton = new JButton("Cancelar");

	public EliminarAutosPanel(Handler handler) {
		super(handler);

		initPanel(handler);
	}

	public void initPanel(Handler handler) {
		crearTituloPantalla("ELIMINAR AUTOS");

		JTextField patenteTextField = new JTextField();

		String[] labels = { "Patente" };
		JButton[] botones = { eliminarBoton, cancelarBoton };
		JTextField[] textFields = { patenteTextField };

		crearBoxVertical(labels, textFields);
		crearBotonera(botones);

		eliminarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.deleteAuto(patenteTextField.getText().toUpperCase());
			}
		});

		cancelarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
	}
}
