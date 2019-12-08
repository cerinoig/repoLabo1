package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import handler.Handler;

public abstract class ConsultaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JButton confirmarBoton;
	protected JButton cancelarBoton;

	public ConsultaPanel(Handler handler) {
	
		setLayout(new BorderLayout());
		add(getTituloPanel(), BorderLayout.NORTH);
		add(getBody(handler), BorderLayout.CENTER);
		add(crearBotonera(getBotones()), BorderLayout.SOUTH);
		initUI(handler);
		
		cancelarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});
	}

	public abstract void initUI(Handler handler);

	public void setTitle(String title) {

		add(new JLabel(title), BorderLayout.NORTH);

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
	
	public JButton[] getBotones() {
		initButtons();
		JButton[] botones = { cancelarBoton };
		return botones;
	}
	
	public void initButtons() {
		cancelarBoton = new JButton("Volver");
	}

	public abstract JLabel getTituloPanel();

	public abstract JScrollPane getBody(Handler handler);
	
	public abstract void initTableModel(Handler handler);
	
}
