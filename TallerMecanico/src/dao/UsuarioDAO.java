package dao;

import java.sql.SQLException;

import entidades.Usuario;

public interface UsuarioDAO {

	public Usuario selectUsuario(String usuario) throws SQLException;

	public void insertUsuario(Usuario usuario) throws SQLException;

	public void updateUsuario(Usuario usuario) throws SQLException;

	public void deleteUsuario(String usuario) throws SQLException;
	
	public boolean buscarUsuario(String usuario) throws SQLException;

}
