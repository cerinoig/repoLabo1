package servicios;

import java.sql.SQLException;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;

public class UsuarioBusinessObjectImpl implements UsuarioBusinessObject {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	@Override
	public Usuario selectUsuario(String usuario) throws SQLException, NonExistingUserException {
		try {
			return usuarioDAO.selectUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException nonExistingUserException) {
			throw new NonExistingUserException();
		}
	}

	@Override
	public void insertUsuario(Usuario usuario) throws SQLException, ExistingUserException, NoIdObtainedException {
		try {
			usuarioDAO.insertUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (ExistingUserException existingUserException) {
			throw new ExistingUserException();
		} catch (NoIdObtainedException noIdObtainedException) {
			throw new NoIdObtainedException();
		}
	}

	@Override
	public void updateUsuario(Usuario usuario) throws SQLException, NonExistingUserException {
		try {
			usuarioDAO.updateUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException nonExistingUserException) {
			throw new NonExistingUserException();
		}
	}

	@Override
	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException {
		try {
			usuarioDAO.deleteUsuario(usuario);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingUserException nonExistingUserException) {
			throw new NonExistingUserException();
		}
	}
}