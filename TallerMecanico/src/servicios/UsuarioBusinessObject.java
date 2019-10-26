package servicios;

import java.sql.SQLException;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioBusinessObject {
	
	void setDAO(UsuarioDAO usuarioDAO);

	Usuario selectUsuario(String usuario, String contraseña) throws TallerMecanicoException, NonExistingUserException;

	void insertUsuario(Usuario usuario) throws TallerMecanicoException, ExistingUserException, NoIdObtainedException ;

	void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException;

	void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException;

}
