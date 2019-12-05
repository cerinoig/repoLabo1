package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Factura;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;
import utils.ConnectionManager;

public class FacturaDAOImpl implements FacturaDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Factura selectFactura(int codigoFactura) throws TallerMecanicoException {
		Factura factura = null;
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM FACTURAS WHERE ID_FACTURA = " + "'" + codigoFactura + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				factura = new Factura();
				factura.setIdFactura(rs.getInt("ID_FACTURA"));
				factura.setArreglo(rs.getString("ARREGLO"));
				factura.setCobrado(rs.getBoolean("COBRADO"));
				factura.setCostoAreglo(rs.getDouble("COSTO_ARREGLO"));
				factura.setPatente(rs.getString("PATENTE"));
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error en la busqueda de la factura", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}

		return factura;
	}

	@Override
	public void insertFactura(Factura factura) throws TallerMecanicoException, NoIdObtainedException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "INSERT INTO FACTURAS (PATENTE, ARREGLO, COSTO_ARREGLO, COBRADO) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, factura.getPatente());
			pstmt.setString(2, factura.getArreglo());
			pstmt.setDouble(3, factura.getCostoAreglo());
			pstmt.setBoolean(4, factura.isCobrado());

			pstmt.executeUpdate();
			conn.commit();

			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					factura.setIdFactura(generatedKeys.getInt(1));
				} else {
					throw new NoIdObtainedException(
							"Se produjo un error al dar de alta la factura, no se obtuvo el ID.");
				}
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error en el alta de la factura", sqle);
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
	public void cobrarArreglo(List<Factura> facturas) throws TallerMecanicoException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "UPDATE FACTURAS SET COBRADO = ? WHERE ID_FACTURA = ?";
			pstmt = conn.prepareStatement(sql);

			for (Factura factura : facturas) {
				pstmt.setBoolean(1, factura.isCobrado());
				pstmt.setInt(2, factura.getIdFactura());

				pstmt.executeUpdate();
				conn.commit();
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error al cobrar el arreglo", sqle);
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
	public void deleteFactura(int idFactura) throws TallerMecanicoException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "DELETE FROM FACTURAS WHERE ID_FACTURA = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idFactura);
			pstmt.execute();
			conn.commit();

		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error al eliminar la factura", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		}
	}

	@Override
	public List<Factura> selectAll() throws TallerMecanicoException {
		List<Factura> facturas = new ArrayList<>();
		try {
			conn = ConnectionManager.getConnection();
			sql = "SELECT * FROM FACTURAS WHERE COBRADO = 0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Factura factura = new Factura();
				factura.setIdFactura(rs.getInt("ID_FACTURA"));
				factura.setPatente(rs.getString("PATENTE"));
				factura.setArreglo(rs.getString("ARREGLO"));
				factura.setCostoAreglo(rs.getDouble("COSTO_ARREGLO"));
				factura.setCobrado(rs.getBoolean("COBRADO"));
				facturas.add(factura);
			}
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error en la busqueda de las facturas", sqle);
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle3) {
				sqle3.printStackTrace();
			}
		}

		return facturas;
	}

	@Override
	public void updateFactura(Factura factura) throws TallerMecanicoException {
		try {
			conn = ConnectionManager.getConnection();
			sql = "UPDATE FACTURAS SET ARREGLO = ?,  PATENTE = ?, COSTO_ARREGLO = ?  WHERE ID_FACTURA = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, factura.getArreglo());
			pstmt.setString(2, factura.getPatente());
			pstmt.setDouble(3, factura.getCostoAreglo());
			pstmt.setInt(4, factura.getIdFactura());

			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				sqle.printStackTrace();
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
			throw new TallerMecanicoException("Ocurrio un error al modificar la factura", sqle);
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
