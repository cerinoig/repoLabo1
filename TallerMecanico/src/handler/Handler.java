package handler;

import java.util.List;

import javax.swing.JOptionPane;

import dao.AutoDAOImpl;
import dao.UsuarioDAOImpl;
import entidades.Auto;
import entidades.Factura;
import entidades.Usuario;
import excepciones.CamposVaciosException;
import servicios.AutoBusinessObject;
import servicios.AutoBusinessObjectImpl;
import servicios.FacturaBusinessObject;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import ui.AltaAutoPanel;
import ui.AltaFacturaPanel;
import ui.AltaUsuarioPanel;
import ui.BajaFacturaPanel;
import ui.ConsultaAutosPanel;
import ui.ConsultaFacturaPanel;
import ui.ConsultaUsuariosPanel;
import ui.EliminarAutosPanel;
import ui.EliminarUsuariosPanel;
import ui.LoginPanel;
import ui.MiFrame;
import ui.ModificarAutoPanel;
import ui.ModificarFacturaPanel;
import ui.ModificarUsuarioPanel;
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
import static utils.NombrePantallas.ALTA_FACTURA;
import static utils.NombrePantallas.BAJA_FACTURA;
import static utils.NombrePantallas.MODIFICAR_FACTURA;
import static utils.NombrePantallas.CONSULTA_FACTURA;

public class Handler {

	private UsuarioBusinessObject usuarioBusinessObject;
	private AutoBusinessObject autoBusinessObject;
	private FacturaBusinessObject facturaBusinessObject;
	private MiFrame frame;

	public Handler() {
		usuarioBusinessObject = new UsuarioBusinessObjectImpl();
		usuarioBusinessObject.setDAO(new UsuarioDAOImpl());
		autoBusinessObject = new AutoBusinessObjectImpl();
		autoBusinessObject.setDAO(new AutoDAOImpl());
	}

	public void initFrame() {
		frame = new MiFrame(this);
		frame.cambiarPanel(new PanelBienvenida());
		frame.setVisible(true);
	}

	public void altaUsuario(Usuario usuario) {
		try {
			usuarioBusinessObject.insertUsuario(usuario);
			mostrarExito("El usuario fue dado de alta con éxito");
			frame.getJMenuBar().setVisible(true);
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void deleteUsuario(String usuario) {
		try {
			usuarioBusinessObject.deleteUsuario(usuario);
			mostrarExito("El usuario fue eliminado exitosamente");
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void modificarUsuario(Usuario usuario) {
		try {
			usuarioBusinessObject.updateUsuario(usuario);
			mostrarExito("El usuario fue modificado exitosamente");
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public Usuario consultarUsuario(String nombreUsuario) {
		Usuario usuario = null;
		try {
			usuario = usuarioBusinessObject.selectUsuario(nombreUsuario);
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
		return usuario;
	}

	public Usuario login(String nombreUsuario) {
		Usuario usuario = null;
		try {
			usuario = usuarioBusinessObject.selectUsuario(nombreUsuario);
			frame.getJMenuBar().setVisible(true);
			frame.cambiarPanel(new PanelBienvenida());
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
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
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
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
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
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

	public void altaFactura(Factura factura) {
		try {
			facturaBusinessObject.insertFactura(factura);
			mostrarExito("La factura fue creada exitosamente");
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void deleteFactura(int idFactura) {
		try {
			facturaBusinessObject.deleteFactura(idFactura);
			mostrarExito("La factura fue eliminada exitosamente");
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public void modificarFactura(Factura factura) {
		try {
			facturaBusinessObject.updateFactura(factura);
			mostrarExito("La factura" + factura.getIdFactura() + " fue modificada exitosamente");
		} catch (NumberFormatException cve) {
			campoNumericoInvalido();
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
	}

	public Factura consultaFactura(int idFactura) {
		Factura factura = null;
		try {
			factura = facturaBusinessObject.selectFactura(idFactura);
		} catch (CamposVaciosException cve) {
			campoVacioMensaje(cve.getMessage());
		} catch (Exception e) {
			mostrarError(e);
		}
		return factura;
	}

	public List<Factura> selectAllFacturas() {
		List<Factura> facturas = null;
		try {
			facturas = facturaBusinessObject.selectAll();
		} catch (Exception e) {
			mostrarError(e);
		}
		return facturas;
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
			frame.cambiarPanel(new ModificarUsuarioPanel(this));
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
		case ALTA_FACTURA:
			frame.cambiarPanel(new AltaFacturaPanel(this));
			break;
		case BAJA_FACTURA:
			frame.cambiarPanel(new BajaFacturaPanel(this));
			break;
		case MODIFICAR_FACTURA:
			frame.cambiarPanel(new ModificarFacturaPanel(this));
			break;
		case CONSULTA_FACTURA:
			frame.cambiarPanel(new ConsultaFacturaPanel(this));
			break;
		}
	}

	public void irAlInicio() {
		frame.cambiarPanel(new PanelBienvenida());
	}

	private void mostrarExito(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	public void mostrarError(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void campoVacioMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
	}

	private void campoNumericoInvalido() {
		JOptionPane.showMessageDialog(null, "El campo numerico es invalido", "Aviso", JOptionPane.WARNING_MESSAGE);
	}

}
