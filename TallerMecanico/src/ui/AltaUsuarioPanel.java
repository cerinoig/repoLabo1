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

import entidades.Usuario;

public class AltaUsuarioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel tituloLabel, nombreLabel, apellidoLabel, mailLabel, usuarioLabel, passwordLabel;
	private JTextField nombreTextField, apellidoTextField, mailTextField, usuarioTextField;
	private JPasswordField passwordField;
	private JButton guardarBoton;

	public AltaUsuarioPanel() {
		initUI();
	}

	public void initUI() {
		setVisible(true);
		setSize(700, 700);
		setLayout(null);

		tituloLabel = new JLabel("Registro de usuario");
		tituloLabel.setForeground(Color.blue);
		tituloLabel.setFont(new Font("Serif", Font.BOLD, 20));

		nombreLabel = new JLabel("Nombre:");
		apellidoLabel = new JLabel("Apellido:");
		mailLabel = new JLabel("Mail:");
		usuarioLabel = new JLabel("Usuario");
		passwordLabel = new JLabel("Contraseņa");

		nombreTextField = new JTextField();
		apellidoTextField = new JTextField();
		mailTextField = new JTextField();
		usuarioTextField = new JTextField();
		passwordField = new JPasswordField();

		guardarBoton = new JButton("Guardar");

		tituloLabel.setBounds(100, 30, 400, 30);
		nombreLabel.setBounds(80, 70, 200, 30);
		apellidoLabel.setBounds(80, 110, 200, 30);
		mailLabel.setBounds(80, 150, 200, 30);
		usuarioLabel.setBounds(80, 190, 200, 30);
		passwordLabel.setBounds(80, 230, 200, 30);

		nombreTextField.setBounds(300, 70, 200, 30);
		apellidoTextField.setBounds(300, 110, 200, 30);
		mailTextField.setBounds(300, 230, 200, 30);
		usuarioTextField.setBounds(300, 270, 200, 30);
		passwordField.setBounds(300, 150, 200, 30);

		guardarBoton.setBounds(50, 350, 100, 30);

		add(tituloLabel);

		add(nombreLabel);
		add(nombreTextField);

		add(apellidoLabel);
		add(apellidoTextField);

		add(mailLabel);
		add(mailTextField);

		add(usuarioLabel);
		add(usuarioTextField);

		add(passwordLabel);
		add(passwordField);

		add(guardarBoton);

		guardarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setNombre(nombreTextField.getText().toString());
				usuario.setApellido(apellidoTextField.getText().toString());
				usuario.setMail(mailTextField.getText().toString());
				usuario.setUsuario(usuarioTextField.getText().toString());
				usuario.setPassword(passwordField.getPassword().toString());
			}
		});
	}

}
