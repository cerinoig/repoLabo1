package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import utils.ConnectionManager;

public class AutoDAOImpl implements AutoDAO {

	private Connection conn = ConnectionManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Auto selectAuto(int patente) throws SQLException, NonExistingCarException {
		Auto auto = new Auto();
		try {
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + patente + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				auto.setIdUsuario(rs.getInt("ID_AUTO"));
				auto.setPatente(rs.getString("PATENTE"));
				auto.setMarca(rs.getString("MARCA"));
				auto.setModelo(rs.getString("MODELO"));
				auto.setColor(rs.getString("COLOR"));
				auto.setCantidadPuertas(rs.getInt("CANT_PUERTAS"));
				auto.setAño(rs.getString("AÑO"));
				auto.setKilometraje(rs.getInt("KILOMETRAJE"));
			} else {
				throw new NonExistingCarException();
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

		return auto;
	}

	@Override
	public void insertAuto(Auto auto) throws SQLException, NoIdObtainedException, ExistingCarException {
		try {
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + auto.getPatente() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				throw new ExistingCarException();
			} else {
				try {
					sql = "INSERT INTO AUTOS (PATENTE, MARCA, MODELO, COLOR, CANT_PUERTAS, AÑO, KILOMETRAJE) VALUES (?, ?, ?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

					pstmt.setString(1, auto.getPatente());
					pstmt.setString(2, auto.getMarca());
					pstmt.setString(3, auto.getModelo());
					pstmt.setString(4, auto.getColor());
					pstmt.setInt(5, auto.getCantidadPuertas());
					pstmt.setString(6, auto.getAño());
					pstmt.setInt(7, auto.getKilometraje());

					pstmt.executeUpdate();
					conn.commit();

					try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							auto.setIdUsuario(generatedKeys.getInt(1));
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
	public void updateAuto(Auto auto) throws SQLException, NonExistingCarException {
		try {
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + auto.getPatente() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "UPDATE AUTOS SET PATENTE = ?, MARCA = ?, MODELO = ?, COLOR = ?, CANT_PUERTAS = ?, AÑO = ?, KILOMETRAJE = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, auto.getPatente());
					pstmt.setString(2, auto.getMarca());
					pstmt.setString(3, auto.getModelo());
					pstmt.setString(4, auto.getColor());
					pstmt.setInt(5, auto.getCantidadPuertas());
					pstmt.setString(5, auto.getAño());
					pstmt.setInt(5, auto.getKilometraje());

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
				throw new NonExistingCarException();
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
	public void deleteAuto(int patente) throws SQLException, NonExistingCarException {
		try {
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + patente + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "DELETE FROM AUTOS WHERE USUARIO = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setInt(1, patente);
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
				throw new NonExistingCarException();
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
