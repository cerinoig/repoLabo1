package handler;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.UsuarioDAOImpl;
import entidades.Auto;
import entidades.Usuario;
import servicios.AutoBusinessObject;
import servicios.AutoBusinessObjectImpl;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import ui.EliminarAutosPanel;
import ui.LoginPanel;
import ui.MiFrame;

public class Handler {

	private UsuarioBusinessObject usuarioBusinessObject;
	private AutoBusinessObject autoBusinessObject;
	private MiFrame frame;

	public Handler() {
		usuarioBusinessObject = new UsuarioBusinessObjectImpl();
		usuarioBusinessObject.setDAO(new UsuarioDAOImpl());
		autoBusinessObject = new AutoBusinessObjectImpl();
	}

	public void initFrame() {
		frame = new MiFrame();
		frame.cambiarPanel(new LoginPanel(this));
		frame.setVisible(true);

	}

	public void altaUsuario(Usuario usuario) {
		try {
			usuarioBusinessObject.insertUsuario(usuario);
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void deleteUsuario(String usuario) {
		try {
			usuarioBusinessObject.deleteUsuario(usuario);
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void modificarUsuario(Usuario usuario) {
		try {
			usuarioBusinessObject.updateUsuario(usuario);
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void login(String nombreUsuario, String contraseña) {
		try {
			usuarioBusinessObject.selectUsuario(nombreUsuario, contraseña);
			frame.cambiarPanel(new JPanel()); // decidir si 2 frames (login y
												// app) o editamos el existente
												// (agregar menubar, tamaño,
												// etc)
		} catch (Exception e) {
			mostrarError(new Exception("Usuario y/o password incorrectos"));
		}
	}

	public Usuario consultaUsuario(String nombreUsuario, String contraseña) {
		Usuario usuario = null;
		try {
			usuario = usuarioBusinessObject.selectUsuario(nombreUsuario, contraseña);
			mostrarExito("Se encontro el usuario");
		} catch (Exception e) {
			mostrarError(e);
		}

		return usuario;
	}

	public void altaAuto(Auto auto) {
		try {
			autoBusinessObject.insertAuto(auto);
			mostrarExito("El auto fue dado de alta exitosamente");
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void deleteAuto(String patente) {
		try {
			autoBusinessObject.deleteAuto(patente);
			mostrarExito("El auto fue eliminado exitosamente");
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void modificarAuto(Auto auto) {
		try {
			autoBusinessObject.updateAuto(auto);
			mostrarExito("El auto fue modificado exitosamente");
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public Auto consultaAuto(String patente) {
		Auto auto = null;
		try {
			auto = autoBusinessObject.selectAuto(patente);
		} catch (Exception e) {
			mostrarError(e);
		}
		return auto;
	}

	private void mostrarExito(String string) {
		JOptionPane.showMessageDialog(null, string);

	}

	private void mostrarError(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
}
