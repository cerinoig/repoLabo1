package servicios;

import java.sql.SQLException;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NonExistingUserException;

public interface UsuarioService {

	public Usuario selectUsuario(String usuario) throws SQLException;

	public void insertUsuario(Usuario usuario) throws SQLException, ExistingUserException;

	public void updateUsuario(Usuario usuario) throws SQLException, NonExistingUserException;

	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException;

}
