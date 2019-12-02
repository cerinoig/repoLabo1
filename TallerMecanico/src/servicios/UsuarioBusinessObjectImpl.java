package servicios;

import java.util.List;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.CamposVaciosException;
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
	public Usuario selectUsuario(String usuario)
			throws TallerMecanicoException, NonExistingUserException, CamposVaciosException {
		if (!usuario.equals("")) {
			if (usuarioDAO.selectUsuario(usuario) == null) {
				throw new NonExistingUserException("Usuario y/o password incorrectos");
			} else {
				return usuarioDAO.selectUsuario(usuario);
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void insertUsuario(Usuario usuario)
			throws TallerMecanicoException, ExistingUserException, NoIdObtainedException, CamposVaciosException {
		if (validarUsuario(usuario)) {
			if (usuarioDAO.selectUsuario(usuario.getUsuario()) == null) {
				usuarioDAO.insertUsuario(usuario);
			} else {
				throw new ExistingUserException("El usuario que intenta dar de alta ya existe");
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void updateUsuario(Usuario usuario)
			throws TallerMecanicoException, NonExistingUserException, CamposVaciosException {
		if (validarUsuario(usuario)) {
			usuarioDAO.updateUsuario(usuario);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void deleteUsuario(String usuario)
			throws TallerMecanicoException, NonExistingUserException, CamposVaciosException {
		if (!usuario.equals("")) {
			if (usuarioDAO.selectUsuario(usuario) == null) {
				throw new NonExistingUserException("El usuario que intenta eliminar no existe");
			} else {
				usuarioDAO.deleteUsuario(usuario);
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public List<Usuario> selectAll() throws TallerMecanicoException {
		return usuarioDAO.selectAll();
	}

	private boolean validarUsuario(Usuario usuario) {
		if (!usuario.getNombre().equals("") && !usuario.getApellido().equals("") && !usuario.getMail().equals("")
				&& !usuario.getUsuario().equals("") && !usuario.getPassword().equals("")) {
			return true;
		} else {
			return false;
		}
	}
}