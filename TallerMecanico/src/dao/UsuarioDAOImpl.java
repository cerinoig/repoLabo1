package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingUserException;
import utils.ConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection conn = ConnectionManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Usuario selectUsuario(String nombreUsuario) throws SQLException, NonExistingUserException {
		Usuario usuario = new Usuario();
		try {
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + nombreUsuario + "'";
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
				throw new NonExistingUserException();
			}
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

		return usuario;
	}

	@Override
	public void insertUsuario(Usuario usuario) throws SQLException, NoIdObtainedException, ExistingUserException {
		try {
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + usuario.getUsuario() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				throw new ExistingUserException();
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
							throw new NoIdObtainedException();
						}
					}

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

			}
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
	public void updateUsuario(Usuario usuario) throws SQLException, NonExistingUserException {
		try {
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
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException sqle3) {
						sqle3.printStackTrace();
					}
				}
			} else {
				throw new NonExistingUserException();
			}
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
	public void deleteUsuario(String usuario) throws SQLException, NonExistingUserException {
		try {
			sql = "SELECT * FROM USUARIOS WHERE USUARIO = " + "'" + usuario + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "DELETE FROM USUARIOS WHERE USUARIO = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, usuario);
					pstmt.executeUpdate();

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
				throw new NonExistingUserException();
			}
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}
	}
}
