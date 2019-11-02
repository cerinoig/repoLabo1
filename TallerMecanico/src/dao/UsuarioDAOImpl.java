package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import excepciones.TallerMecanicoException;
import utils.ConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection conn;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Usuario selectUsuario(String nombreUsuario, String contraseña)
			throws TallerMecanicoException, NonExistingUserException {
		Usuario usuario = new Usuario();
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + nombreUsuario + "' AND PASSWORD = " + "'"
					+ contraseña + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellido(rs.getString("APELLIDO"));
				usuario.setMail(rs.getString("MAIL"));
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setPassword(rs.getString("PASSWORD"));
			} else {
				throw new NonExistingUserException("El usuario que esta buscando no existe");
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Hubo un error en la consulta del usuario", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}

		return usuario;
	}

	@Override
	public void insertUsuario(Usuario usuario)
			throws TallerMecanicoException, NoIdObtainedException, ExistingUserException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + usuario.getUsuario() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				throw new ExistingUserException("El usuario ingresado ya existe");
			} else {
				try {
					sql = "INSERT INTO USUARIOS (NOMBRE, APELLIDO, MAIL, USUARIO, PASSWORD) VALUES (?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

					pstmt.setString(1, usuario.getNombre());
					pstmt.setString(2, usuario.getApellido());
					pstmt.setString(3, usuario.getMail());
					pstmt.setString(4, usuario.getUsuario());
					pstmt.setString(5, usuario.getPassword());

					pstmt.executeUpdate();
					conn.commit();

					try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							usuario.setIdUsuario(generatedKeys.getInt(1));
						} else {
							throw new NoIdObtainedException("Se produjo un error al crear el usuario, no se obtuvo el ID.");
						}
					}

				} catch (SQLException sqle) {
					try {
						conn.rollback();
						sqle.printStackTrace();
					} catch (SQLException sqle2) {
						sqle2.printStackTrace();
					}
					throw new TallerMecanicoException("Hubo un error al insertar el usuario", sqle);
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException sqle3) {
						sqle3.printStackTrace();
					}
				}

			}
		} catch (SQLException sqle) {
			throw new TallerMecanicoException("Hubo un error en la consulta del usuario", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}

	}

	@Override
	public void updateUsuario(Usuario usuario) throws TallerMecanicoException, NonExistingUserException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + usuario.getUsuario() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "UPDATE USUARIOS SET NOMBRE = ?, APELLIDO = ?, MAIL = ?, USUARIO = ?, PASSWORD = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, usuario.getNombre());
					pstmt.setString(2, usuario.getApellido());
					pstmt.setString(3, usuario.getMail());
					pstmt.setString(4, usuario.getUsuario());
					pstmt.setString(5, usuario.getPassword());

					pstmt.executeUpdate();

				} catch (SQLException sqle) {
					try {
						conn.rollback();
						sqle.printStackTrace();
					} catch (SQLException sqle2) {
						sqle2.printStackTrace();
					}
					throw new TallerMecanicoException("Hubo un error al modificar los datos", sqle);
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException sqle3) {
						sqle3.printStackTrace();
					}
				}
			} else {
				throw new NonExistingUserException("El usuario que quiere modificar no existe");
			}
		} catch (SQLException sqle) {
			throw new TallerMecanicoException("Hubo un error en la consulta del usuario", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUsuario(String usuario) throws TallerMecanicoException, NonExistingUserException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + usuario + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "DELETE FROM USUARIOS WHERE USUARIO = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, usuario);
					pstmt.executeUpdate();
					conn.commit();

				} catch (SQLException sqle) {
					try {
						conn.rollback();
						sqle.printStackTrace();
					} catch (SQLException sqle2) {
						sqle2.printStackTrace();
					}
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException sqle3) {
						sqle3.printStackTrace();
					}
				}
			} else {
				throw new NonExistingUserException("El usuario que intenta eliminar no existe");
			}
		} catch (SQLException sqle) {
			throw new TallerMecanicoException("Hubo un error al eliminar el usuario", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}
	}

	public void login(String nombreUsuario, String contraseña)
			throws TallerMecanicoException, NonExistingUserException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + nombreUsuario + "' AND PASSWORD = " + "'"
					+ contraseña + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				throw new TallerMecanicoException("Usuario y/o password incorrectos");
			}

		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Hubo un error en la busqueda del usuario", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}
	}

	@Override
	public List<Usuario> selectAll() throws TallerMecanicoException {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM USUARIOS";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellido(rs.getString("APELLIDO"));
				usuario.setMail(rs.getString("MAIL"));
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setPassword(rs.getString("PASSWORD"));

				usuarios.add(usuario);
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error en la busqueda de los usuarios", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}
		return usuarios;
	}
}
