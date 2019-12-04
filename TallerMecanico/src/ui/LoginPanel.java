package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import handler.Handler;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel tituloLabel, usuarioLabel, passwordLabel, mensaje;
	private JTextField usuarioTextField;
	private JPasswordField passwordField;
	private JButton login, registro;

	public LoginPanel(Handler handler) {
		initUI(handler);
	}

	public void initUI(Handler handler) {
		setVisible(true);
		setSize(700, 700);
		setLayout(null);

		tituloLabel = new JLabel("Login");
		tituloLabel.setForeground(Color.blue);
		tituloLabel.setFont(new Font("Serif", Font.BOLD, 20));

		usuarioLabel = new JLabel("Usuario");
		usuarioTextField = new JTextField();

		passwordLabel = new JLabel("Contraseña");
		passwordField = new JPasswordField();

		login = new JButton("LOGIN");
		registro = new JButton("REGISTRARSE");

		tituloLabel.setBounds(200, 80, 400, 30);

		usuarioLabel.setBounds(200, 140, 200, 30);
		passwordLabel.setBounds(200, 210, 200, 30);

		usuarioTextField.setBounds(200, 170, 280, 30);
		passwordField.setBounds(200, 240, 280, 30);

		login.setBounds(200, 290, 100, 30);
		registro.setBounds(320, 290, 150, 30);

		add(tituloLabel);

		add(usuarioLabel);
		add(usuarioTextField);
		add(passwordLabel);
		add(passwordField);

		mensaje = new JLabel();
		add(mensaje);
		add(login);
		add(registro);

		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.consultarUsuario(usuarioTextField.getText().toString().trim());
			}
		});

		registro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				handler.altaUsuario(usuario);
			}
		});
	}

}
