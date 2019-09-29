package dao;

import java.sql.SQLException;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;

public interface UsuarioDAO {

	public Usuario selectUsuario(String usuario) throws SQLException, NonExistingUserException;

	public void insertUsuario(Usuario usuario) throws SQLException, NoIdObtainedException, ExistingUserException;

	public void updateUsuario(Usuario usuario) throws SQLException, NonExistingUserException;

	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException;

}
