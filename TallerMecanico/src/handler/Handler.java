package handler;

import java.sql.SQLException;

import entidades.Auto;
import entidades.Usuario;
import excepciones.ExistingCarException;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.NonExistingUserException;
import servicios.AutoBusinessObject;
import servicios.AutoBusinessObjectImpl;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;

public class Handler {

	private UsuarioBusinessObject usuarioBusinessObject = new UsuarioBusinessObjectImpl();
	private AutoBusinessObject autoBusinessObject = new AutoBusinessObjectImpl();

	public void altaUsuario(Usuario usuario) throws SQLException, ExistingUserException, NoIdObtainedException {
		try {
			usuarioBusinessObject.insertUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (ExistingUserException e) {
			throw new ExistingUserException();
		} catch (NoIdObtainedException e) {
			throw new NoIdObtainedException();
		}
	}

	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException {
		try {
			usuarioBusinessObject.deleteUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException e) {
			throw new NonExistingUserException();
		}
	}

	public void modificarUsuario(Usuario usuario) throws SQLException, NonExistingUserException {
		try {
			usuarioBusinessObject.updateUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException e) {
			throw new NonExistingUserException();
		}
	}

	public Usuario consultaUsuario(String nombreUsuario, String contraseña)
			throws SQLException, NonExistingUserException {
		try {
			return usuarioBusinessObject.selectUsuario(nombreUsuario, contraseña);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException e) {
			throw new NonExistingUserException();
		}
	}

	public void altaAuto(Auto auto) throws SQLException, ExistingCarException, NoIdObtainedException {
		try {
			autoBusinessObject.insertAuto(auto);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (ExistingCarException e) {
			throw new ExistingCarException();
		} catch (NoIdObtainedException e) {
			throw new NoIdObtainedException();
		}
	}

	public void deleteAuto(String patente) throws SQLException, NonExistingCarException {
		try {
			autoBusinessObject.deleteAuto(patente);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException e) {
			throw new NonExistingCarException();
		}
	}

	public void modificarAuto(Auto auto) throws SQLException, NonExistingCarException {
		try {
			autoBusinessObject.updateAuto(auto);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException e) {
			throw new NonExistingCarException();
		}
	}

	public Auto consultaAuto(String patente) throws SQLException, NonExistingCarException {
		try {
			return autoBusinessObject.selectAuto(patente);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException e) {
			throw new NonExistingCarException();
		}
	}
}
