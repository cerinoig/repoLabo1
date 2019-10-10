package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Usuario;
import excepciones.NonExistingUserException;
import handler.Handler;

public class ModificarUsuarioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel tituloLabel, nombreLabel, apellidoLabel, mailLabel, usuarioLabel, passwordLabel;
	private JTextField nombreTextField, apellidoTextField, mailTextField, usuarioTextField;
	private JPasswordField passwordField;
	private JButton guardarBoton;

	public ModificarUsuarioPanel(Handler handler, String nombreUsuario, String contraseña) {
		initUI(handler, nombreUsuario, contraseña);
	}

	public void initUI(Handler handler, String nombreUsuario, String contraseña) {
		setVisible(true);
		setSize(700, 700);
		setLayout(null);

		tituloLabel = new JLabel("Modificar datos - Usuario");
		tituloLabel.setForeground(Color.blue);
		tituloLabel.setFont(new Font("Serif", Font.BOLD, 20));

		nombreLabel = new JLabel("Nombre:");
		apellidoLabel = new JLabel("Apellido:");
		mailLabel = new JLabel("Mail:");
		usuarioLabel = new JLabel("Usuario");
		passwordLabel = new JLabel("Contraseña");

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
		mailTextField.setBounds(300, 150, 200, 30);
		usuarioTextField.setBounds(300, 190, 200, 30);
		passwordField.setBounds(300, 230, 200, 30);

		guardarBoton.setBounds(80, 280, 100, 30);
		
		if(getUsuario(handler, nombreUsuario, contraseña) !=null){
			Usuario usuario = getUsuario(handler, nombreUsuario, contraseña);
			nombreTextField.setText(usuario.getNombre());
			apellidoTextField.setText(usuario.getApellido());
			mailTextField.setText(usuario.getMail());
			usuarioTextField.setText(usuario.getUsuario());
			passwordField.setText(usuario.getPassword());;
		}

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
				usuario.setPassword(String.valueOf(passwordField.getPassword()));

				try {
					handler.modificarUsuario(usuario);
				} catch (SQLException sqle) {
					System.out.println("error generico sql");
					sqle.printStackTrace();
				} catch (NonExistingUserException eue) {
					System.out.println("usuario existe");
					eue.printStackTrace();
				}
			}
		});
	}

	public Usuario getUsuario(Handler handler, String nombreUsuario, String contraseña) {
		try {
			return handler.consultaUsuario(nombreUsuario, contraseña);
		} catch (SQLException sqle) {
			System.out.println("error sql generico");
		} catch (NonExistingUserException neue) {
			System.out.println("usuario inexistente");
		}
		
		return null;
	}

}
