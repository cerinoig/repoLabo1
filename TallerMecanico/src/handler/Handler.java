package handler;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.UsuarioDAOImpl;
import entidades.Auto;
import entidades.Usuario;
import servicios.AutoBusinessObject;
import servicios.AutoBusinessObjectImpl;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import ui.AltaUsuarioPanel;
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
		if (!usuario.getNombre().equals("") && !usuario.getApellido().equals("") && !usuario.getMail().equals("")
				&& !usuario.getUsuario().equals("") && !usuario.getPassword().equals("")) {
			try {
				usuarioBusinessObject.insertUsuario(usuario);
				mostrarExito("El usuario fue dado de alta con éxito");
			} catch (Exception e) {
				mostrarError(e);
			}
		} else {
			camposVaciosMensaje();
		}

	}

	public void deleteUsuario(String usuario) {
		if (!usuario.equals("")) {
			try {
				usuarioBusinessObject.deleteUsuario(usuario);
				mostrarExito("El usuario fue eliminado exitosamente");
			} catch (Exception e) {
				mostrarError(e);
			}
		} else {
			campoVacioMensaje("Debe ingresar el nombre de usuario");
		}

	}

	public void modificarUsuario(Usuario usuario) {
		try {
			usuarioBusinessObject.updateUsuario(usuario);
			mostrarExito("El usuario fue modificado exitosamente");
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void login(String nombreUsuario, String contraseña) {
		if (!nombreUsuario.equals("") && !contraseña.equals("")) {
			try {
				usuarioBusinessObject.login(nombreUsuario, contraseña);
				frame.cambiarPanel(new JPanel()); // decidir si 2 frames (login y
													// app) o editamos el existente
													// (agregar menubar, tamaño,
													// etc)
			} catch (Exception e) {
				mostrarError(new Exception("Usuario y/o password incorrectos"));
			}
		} else {
			camposVaciosMensaje();
		}
	}

	public void registro() {
		frame.cambiarPanel(new AltaUsuarioPanel(this));
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

	public List<Usuario> selectAllUsuarios() {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioBusinessObject.selectAll();
		} catch (Exception e) {
			mostrarError(e);
		}
		return usuarios;
	}

	public void altaAuto(Auto auto) {
		if (!auto.getPatente().equals("") && auto.getMarca().equals("") && auto.getModelo().equals("")
				&& auto.getColor().equals("") && auto.getCantidadPuertas() != 0 && auto.getAño().equals("")
				&& auto.getKilometraje() != 0) {
			try {
				autoBusinessObject.insertAuto(auto);
				mostrarExito("El auto fue dado de alta exitosamente");
			} catch (Exception e) {
				mostrarError(e);
			}
		} else {
			camposVaciosMensaje();
		}

	}

	public void deleteAuto(String patente) {
		if (!patente.equals("")) {
			try {
				autoBusinessObject.deleteAuto(patente);
				mostrarExito("El auto fue eliminado exitosamente");
			} catch (Exception e) {
				mostrarError(e);
			}
		} else {
			campoVacioMensaje("Debe ingresar la patente del auto");
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

	public List<Auto> selectAllAutos() {
		List<Auto> autos = null;
		try {
			autos = autoBusinessObject.selectAll();
		} catch (Exception e) {
			mostrarError(e);
		}
		return autos;
	}

	private void mostrarExito(String string) {
		JOptionPane.showMessageDialog(null, string);

	}

	private void mostrarError(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void camposVaciosMensaje() {
		JOptionPane.showMessageDialog(null, "No puede haber espacios sin completar");
	}

	private void campoVacioMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
