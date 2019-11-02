package dao;

import java.sql.SQLException;
import java.util.List;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioDAO {

	Usuario selectUsuario(String usuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	void insertUsuario(Usuario usuario) throws TallerMecanicoException, NoIdObtainedException, ExistingUserException;

	void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException;

	void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException;

	void login(String nombreUsuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	List<Usuario> selectAll() throws TallerMecanicoException;

}
