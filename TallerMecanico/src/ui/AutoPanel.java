package ui;

import javax.swing.JTextField;

import handler.Handler;

public abstract class AutoPanel extends MiPanel {

	private static final long serialVersionUID = 1L;

	protected JTextField patenteTextField;
	protected JTextField marcaTextField;
	protected JTextField modeloTextField;
	protected JTextField colorTextField;
	protected JTextField puertasTextField;
	protected JTextField kilometrosTextField;
	protected JTextField añoTextField;

	public AutoPanel(Handler handler) {
		super(handler);
	}

	//public abstract void initPanel(Handler handler);

}
