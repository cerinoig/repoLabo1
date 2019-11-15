package handler;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.UsuarioDAOImpl;
import entidades.Auto;
import entidades.Usuario;
import excepciones.CamposVaciosException;
import servicios.AutoBusinessObject;
import servicios.AutoBusinessObjectImpl;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import ui.AltaAutoPanel;
import ui.AltaUsuarioPanel;
import ui.ConsultaAutosPanel;
import ui.ConsultaUsuariosPanel;
import ui.EliminarAutosPanel;
import ui.EliminarUsuariosPanel;
import ui.LoginPanel;
import ui.MiFrame;
import ui.ModificarAutoPanel;
import ui.PanelBienvenida;

import static utils.NombrePantallas.ALTA_AUTO;
import static utils.NombrePantallas.BAJA_AUTO;
import static utils.NombrePantallas.MODIFICAR_AUTO;
import static utils.NombrePantallas.CONSULTA_AUTO;
import static utils.NombrePantallas.ALTA_USUARIO;
import static utils.NombrePantallas.BAJA_USUARIO;
import static utils.NombrePantallas.MODIFICAR_USUARIO;
import static utils.NombrePantallas.CONSULTA_USUARIOS;
import static utils.NombrePantallas.CERRAR_SESION;

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
		frame = new MiFrame(this);
		frame.cambiarPanel(new PanelBienvenida());
		frame.setVisible(true);
	}

	public void altaUsuario(Usuario usuario) {
		if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getMail() != null
				&& usuario.getUsuario() != null && usuario.getPassword() != null) {
			try {
				usuarioBusinessObject.insertUsuario(usuario);
				mostrarExito("El usuario fue dado de alta con éxito");
				frame.getJMenuBar().setVisible(true);
			} catch (Exception e) {
				mostrarError(e);
			}
		} else {
//			camposVaciosMensaje();
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
				frame.getJMenuBar().setVisible(true);
				frame.cambiarPanel(new JPanel());
			} catch (Exception e) {
				mostrarError(new Exception("Usuario y/o password incorrectos"));
			}
		} else {
//			camposVaciosMensaje();
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
		try {
			autoBusinessObject.insertAuto(auto);
			mostrarExito("El auto fue dado de alta exitosamente");
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void deleteAuto(String patente) {
		try {
			autoBusinessObject.deleteAuto(patente);
			mostrarExito("El auto fue eliminado exitosamente");
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void modificarAuto(Auto auto) {
		try {
			autoBusinessObject.updateAuto(auto);
			mostrarExito("El auto fue modificado exitosamente");
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public Auto consultaAuto(String patente) {
		Auto auto = null;
		try {
			auto = autoBusinessObject.selectAuto(patente);
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
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

	public void menuUsage(String menuActionType) {
		switch (menuActionType) {
		case ALTA_USUARIO:
			frame.cambiarPanel(new AltaUsuarioPanel(this));
			break;
		case BAJA_USUARIO:
			frame.cambiarPanel(new EliminarUsuariosPanel(this));
			break;
		case MODIFICAR_USUARIO:
			// frame.cambiarPanel(new ModificarUsuarioPanel(this));
			break;
		case CONSULTA_USUARIOS:
			frame.cambiarPanel(new ConsultaUsuariosPanel(this));
			break;
		case CERRAR_SESION:
			frame.getJMenuBar().setVisible(false);
			frame.cambiarPanel(new LoginPanel(this));
			break;
		case ALTA_AUTO:
			frame.cambiarPanel(new AltaAutoPanel(this));
			break;
		case BAJA_AUTO:
			frame.cambiarPanel(new EliminarAutosPanel(this));
			break;
		case MODIFICAR_AUTO:
			frame.cambiarPanel(new ModificarAutoPanel(this));
			break;
		case CONSULTA_AUTO:
			frame.cambiarPanel(new ConsultaAutosPanel(this));
			break;
		}
	}

	public void irAlInicio() {
		frame.cambiarPanel(new PanelBienvenida());
	}

	private void mostrarExito(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	private void mostrarError(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void campoVacioMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
	}

}
