package ui;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import handler.Handler;

public abstract class UsuarioPanel extends MiPanel{

	private static final long serialVersionUID = 1L;
	
	protected JTextField nombreTextField, apellidoTextField, mailTextField, usuarioTextField;
	protected JPasswordField passwordField;

	public UsuarioPanel(Handler handler) {
		super(handler);
	}

}
