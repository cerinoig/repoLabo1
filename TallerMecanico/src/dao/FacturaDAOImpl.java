//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import entidades.Auto;
//import entidades.Factura;
//import excepciones.ExistingCarException;
//import excepciones.NoIdObtainedException;
//import excepciones.NonExistingCarException;
//import excepciones.TallerMecanicoException;
//import utils.ConnectionManager;
//
//public class FacturaDAOImpl implements FacturaDAO {
//
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	private String sql;
//
//	@Override
//	public Factura selectFactura(int codigoFactura) throws TallerMecanicoException {
//		Factura factura = null;
//		try {
//			conn = ConnectionManager.getConnection();
//			sql = "SELECT * FROM AUTOS WHERE id = " + "'" + codigoFactura + "'";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				factura = new Factura();
//				factura.setIdFactura(rs.getInt("ID_FACTURA"));
//				factura.setArreglo(rs.getString("ARREGLO"));
//				factura.setCostoTotal(rs.getInt("COSTO_TOTAL"));
//				factura.setAuto(new Auto());
//				// ACA QUE HAGO??
//				factura.getAuto().setPatente(rs.getString("PATENTE"));
//			}
//		} catch (SQLException sqle) {
//			try {
//				conn.rollback();
//				sqle.printStackTrace();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//			throw new TallerMecanicoException("Ocurrio un error en la busqueda de la factura", sqle);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException sqle3) {
//				sqle3.printStackTrace();
//			}
//		}
//
//		return factura;
//	}
//
//	@Override
//	public void insertFactura(Factura factura) throws TallerMecanicoException, NoIdObtainedException {
//		try {
//			conn = ConnectionManager.getConnection();
//			sql = "INSERT INTO FACTURAS (PATENTE, ARREGLO, COSTO_TOTAL) VALUES (?, ?, ?)";
//			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//			pstmt.setString(1, factura.getAuto().getPatente());
//			pstmt.setString(2, factura.getArreglo());
//			pstmt.setInt(3, factura.getCostoTotal());
//
//			pstmt.executeUpdate();
//			conn.commit();
//
//			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
//				if (generatedKeys.next()) {
//					factura.setIdFactura(generatedKeys.getInt(1));
//				} else {
//					throw new NoIdObtainedException("Se produjo un error al dar de alta la factura, no se obtuvo el ID.");
//				}
//			}
//		} catch (SQLException sqle) {
//			try {
//				conn.rollback();
//				sqle.printStackTrace();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//			throw new TallerMecanicoException("Ocurrio un error en el alta de la factura", sqle);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException sqle3) {
//				sqle3.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public void updateFactura(Factura factura) throws TallerMecanicoException {
//		try {
//			conn = ConnectionManager.getConnection();
//			sql = "UPDATE AUTOS SET MARCA = ?, MODELO = ?, COLOR = ?, CANT_PUERTAS = ?, AÑO = ?, KILOMETRAJE = ? WHERE PATENTE = ?";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, auto.getMarca());
//			pstmt.setString(2, auto.getModelo());
//			pstmt.setString(3, auto.getColor());
//			pstmt.setInt(4, auto.getCantidadPuertas());
//			pstmt.setString(5, auto.getAño());
//			pstmt.setInt(6, auto.getKilometraje());
//			pstmt.setString(7, auto.getPatente());
//
//			pstmt.executeUpdate();
//			conn.commit();
//		} catch (SQLException sqle) {
//			try {
//				conn.rollback();
//				sqle.printStackTrace();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//			throw new TallerMecanicoException("Ocurrio un error al modificar el auto", sqle);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException sqle3) {
//				sqle3.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public void deleteFactura(String patente) throws TallerMecanicoException {
//		try {
//			conn = ConnectionManager.getConnection();
//			sql = "DELETE FROM AUTOS WHERE PATENTE = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, patente);
//			pstmt.execute();
//			conn.commit();
//
//		} catch (SQLException sqle) {
//			try {
//				conn.rollback();
//				sqle.printStackTrace();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//			throw new TallerMecanicoException("Ocurrio un error al eliminar el auto", sqle);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public List<Factura> selectAll() throws TallerMecanicoException {
//		List<Auto> autos = new ArrayList<>();
//		try {
//			conn = ConnectionManager.getConnection();
//			sql = "SELECT * FROM AUTOS";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				Auto auto = new Auto();
//				auto.setIdAuto(rs.getInt("ID_AUTO"));
//				auto.setPatente(rs.getString("PATENTE"));
//				auto.setMarca(rs.getString("MARCA"));
//				auto.setModelo(rs.getString("MODELO"));
//				auto.setColor(rs.getString("COLOR"));
//				auto.setCantidadPuertas(rs.getInt("CANT_PUERTAS"));
//				auto.setAño(rs.getString("AÑO"));
//				auto.setKilometraje(rs.getInt("KILOMETRAJE"));
//
//				autos.add(auto);
//			}
//		} catch (SQLException sqle) {
//			try {
//				conn.rollback();
//				sqle.printStackTrace();
//			} catch (SQLException sqle2) {
//				sqle2.printStackTrace();
//			}
//			throw new TallerMecanicoException("Ocurrio un error en la busqueda de los autos", sqle);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException sqle3) {
//				sqle3.printStackTrace();
//			}
//		}
//
//		return autos;
//	}
//}
