package dao;

import java.util.List;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioDAO {

	Usuario selectUsuario(String usuario) throws TallerMecanicoException;

	void insertUsuario(Usuario usuario) throws TallerMecanicoException, NoIdObtainedException, ExistingUserException;

	void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException;

	void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException;

	List<Usuario> selectAll() throws TallerMecanicoException;
}
