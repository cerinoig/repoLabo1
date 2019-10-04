package handler;

import java.sql.SQLException;

import entidades.Producto;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;

public class Handler {

	private UsuarioBusinessObject usuarioBusinessObject = new UsuarioBusinessObjectImpl();
	private Producto producto = new Producto();
	private Usuario usuario = new Usuario();

	public void altaUsuario(Usuario usuario) throws SQLException, ExistingUserException, NoIdObtainedException {
		try {

			usuarioBusinessObject.insertUsuario(usuario);

			System.out.println("El usuario fue dado de alta con exito");

		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (ExistingUserException e) {
			throw new ExistingUserException();
		} catch (NoIdObtainedException e) {
			throw new NoIdObtainedException();
			// System.out.println("Error al crear el usuario, no se pudo
			// obntener el ID.");
		}
	}

	public Usuario consultaUsuario(String nombreUsuario, String contraseña)
			throws SQLException, NonExistingUserException {
		try {
			return usuario = usuarioBusinessObject.selectUsuario(nombreUsuario, contraseña);
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

}
