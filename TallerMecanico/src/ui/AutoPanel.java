package ui;

import javax.swing.JTextField;

import handler.Handler;

public abstract class AutoPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField patenteTextField = new JTextField();
	protected JTextField marcaTextField = new JTextField();
	protected JTextField modeloTextField = new JTextField();
	protected JTextField colorTextField = new JTextField();
	protected JTextField puertasTextField = new JTextField();
	protected JTextField kilometrosTextField = new JTextField();
	protected JTextField añoTextField = new JTextField();

	public AutoPanel(Handler handler) {
		super(handler);
	}

	public void initPanel(Handler handler) {

	}

}
