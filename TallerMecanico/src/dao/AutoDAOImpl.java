package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;
import utils.ConnectionManager;

public class AutoDAOImpl implements AutoDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Auto selectAuto(String patente) throws TallerMecanicoException, NonExistingCarException {
		Auto auto = new Auto();
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + patente + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				auto.setIdAuto(rs.getInt("ID_AUTO"));
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
			throw new TallerMecanicoException("Ocurrio un error en la busqueda del auto", sqle);
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
	public void insertAuto(Auto auto) throws TallerMecanicoException, NoIdObtainedException, ExistingCarException {
		try {
			conn = ConnectionManager.getConnection();
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
							auto.setIdAuto(generatedKeys.getInt(1));
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
					throw new TallerMecanicoException("Ocurrio un error en el alta del auto", sqle);
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
			throw new TallerMecanicoException("Ocurrio un error en la busqueda del auto", sqle);
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
	public void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM AUTOS WHERE PATENTE = " + "'" + auto.getPatente() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "UPDATE AUTOS SET MARCA = ?, MODELO = ?, COLOR = ?, CANT_PUERTAS = ?, AÑO = ?, KILOMETRAJE = ? WHERE PATENTE = "
							+ "'" + auto.getPatente() + "'";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, auto.getMarca());
					pstmt.setString(2, auto.getModelo());
					pstmt.setString(3, auto.getColor());
					pstmt.setInt(4, auto.getCantidadPuertas());
					pstmt.setString(5, auto.getAño());
					pstmt.setInt(6, auto.getKilometraje());

					pstmt.executeUpdate();
					conn.commit();
				} catch (SQLException sqle) {
					try {
						conn.rollback();
						sqle.printStackTrace();
					} catch (SQLException sqle2) {
						sqle2.printStackTrace();
					}
					throw new TallerMecanicoException("Ocurrio un error al modificar el auto", sqle);
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
		} catch (SQLException sqle) {
			throw new TallerMecanicoException("Ocurrio un error en la busqueda del auto", sqle);
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
	public void deleteAuto(String patente) throws TallerMecanicoException, NonExistingCarException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "DELETE FROM AUTOS WHERE PATENTE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patente);
			pstmt.execute();
			conn.commit();
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
				throw new SQLException();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
				throw new TallerMecanicoException("Ocurrio un error al eliminar el auto", sqle);
			}
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
				throw new TallerMecanicoException("Ocurrio un error al eliminar el usuario", sqle2);
			}
		}
	}

	@Override
	public List<Auto> selectAll() throws TallerMecanicoException {
		List<Auto> autos = new ArrayList<>();
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM AUTOS";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Auto auto = new Auto();
				auto.setIdAuto(rs.getInt("ID_AUTO"));
				auto.setPatente(rs.getString("PATENTE"));
				auto.setMarca(rs.getString("MARCA"));
				auto.setModelo(rs.getString("MODELO"));
				auto.setColor(rs.getString("COLOR"));
				auto.setCantidadPuertas(rs.getInt("CANT_PUERTAS"));
				auto.setAño(rs.getString("AÑO"));
				auto.setKilometraje(rs.getInt("KILOMETRAJE"));

				autos.add(auto);
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error en la busqueda de los autos", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}

		return autos;
	}
}
