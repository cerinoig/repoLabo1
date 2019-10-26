package dao;

import java.sql.SQLException;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioDAO {

	public Usuario selectUsuario(String usuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	public void insertUsuario(Usuario usuario) throws TallerMecanicoException, NoIdObtainedException, ExistingUserException;

	public void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException;

	public void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException;

}
