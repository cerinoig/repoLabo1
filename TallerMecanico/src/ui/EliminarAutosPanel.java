package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import handler.Handler;

public class EliminarAutosPanel extends AutoPanel {

	private static final long serialVersionUID = 1L;

	private JButton eliminarBoton = new JButton("Eliminar");
	private JButton cancelarBoton = new JButton("Cancelar");

	public EliminarAutosPanel(Handler handler) {
		super(handler);
	}
	
	@Override
	public void initPanel(Handler handler) {

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

	@Override
	public Object panelToObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void objectToPanel(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarCampos() {
		patenteTextField.setText("");
		marcaTextField.setText("");
		modeloTextField.setText("");
		colorTextField.setText("");
		puertasTextField.setText("");
		kilometrosTextField.setText("");
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("ELIMINAR AUTOS");
	}

	@Override
	public Box getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton[] getBotones() {
		// TODO Auto-generated method stub
		return null;
	}
}
