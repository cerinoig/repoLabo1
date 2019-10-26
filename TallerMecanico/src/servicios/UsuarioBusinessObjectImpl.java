package servicios;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public class UsuarioBusinessObjectImpl implements UsuarioBusinessObject {

	private UsuarioDAO usuarioDAO;

	@Override
	public void setDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public Usuario selectUsuario(String usuario, String contraseña)
			throws TallerMecanicoException, NonExistingUserException {
		return usuarioDAO.selectUsuario(usuario, contraseña);
	}

	@Override
	public void insertUsuario(Usuario usuario)
			throws TallerMecanicoException, ExistingUserException, NoIdObtainedException {
		usuarioDAO.insertUsuario(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException {
		usuarioDAO.updateUsuario(usuario);
	}

	@Override
	public void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException {
		usuarioDAO.deleteUsuario(usuario);
	}
}