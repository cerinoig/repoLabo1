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

	public MiFrame(Handler handler) {
		miPantalla = Toolkit.getDefaultToolkit();
		tamanoPantalla = miPantalla.getScreenSize();
		alturaPantalla = tamanoPantalla.height;
		anchoPantalla = tamanoPantalla.width;

		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);
		setTitle("Taller Mecanico");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mostrarOpciones(handler);

	}

	public void cambiarPanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}

	public void mostrarOpciones(Handler handler) {
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

		altaUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("altaUsuario");
			}

		});

		bajaUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("bajaUsuario");
			}

		});

		modificarUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("modificarUsuario");
			}

		});

		cosultaUsuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("cosultaUsuarios");
			}

		});

		cerrarSesion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getJMenuBar().setVisible(false);
				handler.menuUsage("cerrarSesion");
			}

		});

		altaAuto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("altaAuto");
			}

		});

		bajaAuto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("bajaAuto");
			}

		});

		modificacionAuto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("modificacionAuto");
			}

		});
		
		consultaAutos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				handler.menuUsage("consultaAutos");
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
