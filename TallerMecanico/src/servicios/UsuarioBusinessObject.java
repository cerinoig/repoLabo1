package servicios;

import java.util.List;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.CamposVaciosException;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;

public interface UsuarioBusinessObject {

	void setDAO(UsuarioDAO usuarioDAO);

	Usuario selectUsuario(String usuario)
			throws TallerMecanicoException, NonExistingUserException, CamposVaciosException;

	void insertUsuario(Usuario usuario)
			throws TallerMecanicoException, ExistingUserException, NoIdObtainedException, CamposVaciosException;

	void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException, CamposVaciosException;

	void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException, CamposVaciosException;
	
	Usuario login(String usuario, String contraseña)
			throws TallerMecanicoException, NonExistingUserException, CamposVaciosException;

	List<Usuario> selectAll() throws TallerMecanicoException;

}
