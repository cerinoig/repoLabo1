package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Toolkit miPantalla;
	private Dimension tamanoPantalla;
	private int alturaPantalla;
	private int anchoPantalla;

	public MiFrame() {
		miPantalla = Toolkit.getDefaultToolkit();
		tamanoPantalla = miPantalla.getScreenSize();
		alturaPantalla = tamanoPantalla.height;
		anchoPantalla = tamanoPantalla.width;

		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);
		setTitle("Taller Mecanico");

		cambiarPanel(new LoginPanel());
	}

	public void cambiarPanel(JPanel panel) {

		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}

}
