package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import handler.Handler;

public class MiFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Toolkit miPantalla;
	private Dimension tamanoPantalla;
	private int alturaPantalla;
	private int anchoPantalla;

	private JMenuBar menuBar;
	private JMenu menuOpciones, usuario, auto;
	private JMenuItem altaUsuario, bajaUsuario, modificarUsuario, cosultaUsuarios, cerrarSesion, altaAuto, bajaAuto,
			modificacionAuto, consultaAutos;

	public MiFrame() {
		miPantalla = Toolkit.getDefaultToolkit();
		tamanoPantalla = miPantalla.getScreenSize();
		alturaPantalla = tamanoPantalla.height;
		anchoPantalla = tamanoPantalla.width;

		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);
		setTitle("Taller Mecanico");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mostrarOpciones();

	}

	public void cambiarPanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}

	public void mostrarOpciones() {
		setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		usuario = new JMenu("ABM Usuarios");
		menuOpciones.add(usuario);
		auto = new JMenu("ABM Autos");
		menuOpciones.add(auto);

		altaUsuario = new JMenuItem("Alta usuarios");
		usuario.add(altaUsuario);
		altaUsuario.addActionListener(this);
		bajaUsuario = new JMenuItem("Baja usuarios");
		usuario.add(bajaUsuario);
		bajaUsuario.addActionListener(this);
		modificarUsuario = new JMenuItem("Modificar usuarios");
		usuario.add(modificarUsuario);
		modificarUsuario.addActionListener(this);
		cosultaUsuarios = new JMenuItem("Consulta usuarios");
		usuario.add(cosultaUsuarios);
		cosultaUsuarios.addActionListener(this);

		cerrarSesion = new JMenuItem("Cerrar Sesión");
		usuario.add(cerrarSesion);
		cerrarSesion.addActionListener(this);

		altaAuto = new JMenuItem("Alta autos");
		auto.add(altaAuto);
		altaAuto.addActionListener(this);
		bajaAuto = new JMenuItem("Baja autos");
		auto.add(bajaAuto);
		bajaAuto.addActionListener(this);
		modificacionAuto = new JMenuItem("Modificar autos");
		auto.add(modificacionAuto);
		modificacionAuto.addActionListener(this);
		consultaAutos = new JMenuItem("Consulta autos");
		auto.add(consultaAutos);
		consultaAutos.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == altaUsuario) {
			cambiarPanel(new AltaUsuarioPanel(new Handler()));
		}

		if (event.getSource() == bajaUsuario) {
			cambiarPanel(new EliminarUsuariosPanel(new Handler()));
		}

		if (event.getSource() == modificarUsuario) {

		}

		if (event.getSource() == cosultaUsuarios) {
			cambiarPanel(new ConsultaUsuariosPanel(new Handler()));
		}

		if (event.getSource() == cerrarSesion) {
			cambiarPanel(new LoginPanel(new Handler()));
		}

		if (event.getSource() == altaAuto) {
			cambiarPanel(new AltaAutoPanel(new Handler()));
		}
		if (event.getSource() == bajaAuto) {
			cambiarPanel(new EliminarAutosPanel(new Handler()));
		}
		if (event.getSource() == modificacionAuto) {
			cambiarPanel(new ModificarAutoPanel(new Handler()));
		}
		if (event.getSource() == consultaAutos) {
			cambiarPanel(new ConsultaAutosPanel(new Handler()));
		}
	}

}
