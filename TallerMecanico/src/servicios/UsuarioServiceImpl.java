package servicios;

import java.sql.SQLException;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NonExistingUserException;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	@Override
	public Usuario selectUsuario(String usuario) throws SQLException {
		return usuarioDAO.selectUsuario(usuario);
	}

	@Override
	public void insertUsuario(Usuario usuario) throws SQLException, ExistingUserException {
		if (usuarioDAO.buscarUsuario(usuario.getUsuario())) {
			throw new ExistingUserException();
		} else {
			usuarioDAO.insertUsuario(usuario);
		}
	}

	@Override
	public void updateUsuario(Usuario usuario) throws SQLException, NonExistingUserException {
		if (usuarioDAO.buscarUsuario(usuario.getUsuario())) {
			usuarioDAO.updateUsuario(usuario);
		} else {
			throw new NonExistingUserException();
		}
	}

	@Override
	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException {
		if (usuarioDAO.buscarUsuario(usuario)) {
			usuarioDAO.deleteUsuario(usuario);
		} else {
			throw new NonExistingUserException();
		}
	}
}