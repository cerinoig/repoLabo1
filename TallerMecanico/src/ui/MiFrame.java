package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import handler.Handler;
import static utils.NombrePantallas.ALTA_AUTO;
import static utils.NombrePantallas.BAJA_AUTO;
import static utils.NombrePantallas.MODIFICAR_AUTO;
import static utils.NombrePantallas.CONSULTA_AUTO;
import static utils.NombrePantallas.ALTA_USUARIO;
import static utils.NombrePantallas.BAJA_USUARIO;
import static utils.NombrePantallas.MODIFICAR_USUARIO;
import static utils.NombrePantallas.CONSULTA_USUARIOS;
import static utils.NombrePantallas.ALTA_FACTURA;
import static utils.NombrePantallas.BAJA_FACTURA;
import static utils.NombrePantallas.MODIFICAR_FACTURA;
import static utils.NombrePantallas.CONSULTA_FACTURA;

import static utils.NombrePantallas.CERRAR_SESION;

public class MiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuOpciones, usuario, auto, factura;
	private JMenuItem altaUsuario, bajaUsuario, modificarUsuario, cosultaUsuarios, cerrarSesion, altaAuto, bajaAuto,
			modificacionAuto, consultaAutos, altaFactura, bajaFactura, consultaFacturas, modificarFactura;

	public MiFrame(Handler handler) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
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
		
		usuario = new JMenu("Usuarios");
		menuOpciones.add(usuario);
		
		auto = new JMenu("Autos");
		menuOpciones.add(auto);
		
		factura = new JMenu("Facturas");
		menuOpciones.add(factura);

		altaUsuario = new JMenuItem("Alta usuarios");
		usuario.add(altaUsuario);
		bajaUsuario = new JMenuItem("Baja usuarios");
		usuario.add(bajaUsuario);
		modificarUsuario = new JMenuItem("Modificar usuarios");
		usuario.add(modificarUsuario);
		cosultaUsuarios = new JMenuItem("Consulta usuarios");
		usuario.add(cosultaUsuarios);

		altaFactura = new JMenuItem("Generar factura");
		factura.add(altaFactura);
		bajaFactura = new JMenuItem("Eliminar factura");
		factura.add(bajaFactura);
		modificarFactura = new JMenuItem("Modificar factura");
		factura.add(modificarFactura);
		consultaFacturas = new JMenuItem("Consultar facturas");
		factura.add(consultaFacturas);

		cerrarSesion = new JMenuItem("Cerrar Sesión");
		usuario.add(cerrarSesion);

		altaAuto = new JMenuItem("Alta autos");
		auto.add(altaAuto);
		bajaAuto = new JMenuItem("Baja autos");
		auto.add(bajaAuto);
		modificacionAuto = new JMenuItem("Modificar autos");
		auto.add(modificacionAuto);
		consultaAutos = new JMenuItem("Consulta autos");
		auto.add(consultaAutos);

		altaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(ALTA_USUARIO);
			}
		});

		bajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(BAJA_USUARIO);
			}
		});

		modificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(MODIFICAR_USUARIO);
			}
		});

		cosultaUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(CONSULTA_USUARIOS);
			}
		});

		cerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJMenuBar().setVisible(false);
				handler.menuUsage(CERRAR_SESION);
			}
		});

		altaAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(ALTA_AUTO);
			}
		});

		bajaAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(BAJA_AUTO);
			}
		});

		modificacionAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(MODIFICAR_AUTO);
			}
		});

		consultaAutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(CONSULTA_AUTO);
			}
		});

		altaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(ALTA_FACTURA);
			}
		});

		bajaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(BAJA_FACTURA);
			}
		});

		modificarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(MODIFICAR_FACTURA);
			}
		});

		consultaFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.menuUsage(CONSULTA_FACTURA);
			}
		});
	}
}
