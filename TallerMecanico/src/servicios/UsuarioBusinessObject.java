package servicios;

import java.util.List;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioBusinessObject {

	void setDAO(UsuarioDAO usuarioDAO);

	Usuario selectUsuario(String usuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	void insertUsuario(Usuario usuario) throws TallerMecanicoException, ExistingUserException, NoIdObtainedException;

	void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException;

	void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException;

	boolean login(String usuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	List<Usuario> selectAll() throws TallerMecanicoException;

}
