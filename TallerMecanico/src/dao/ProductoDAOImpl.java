package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Producto;
import excepciones.ExistingProductException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingProductException;
import utils.ConnectionManager;

public class ProductoDAOImpl implements ProductoDAO {

	private Connection conn = ConnectionManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;

	@Override
	public Producto selectProducto(int codigoProducto) throws SQLException, NonExistingProductException {
		Producto producto = new Producto();
		try {
			sql = "SELECT * FROM PRODUCTOS WHERE COD_PRODUCTO = " + "'" + codigoProducto + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				producto.setIdProducto(rs.getInt("ID_PRODUCTO"));
				producto.setCodigoProducto(rs.getInt("COD_PRODUCTO"));
				producto.setDescripcion(rs.getString("DESCRIPCION"));
				producto.setCantidad(rs.getInt("CANTIDAD"));
				producto.setPrecioUnitario(rs.getDouble("PRECIO_UNITARIO"));

			} else {
				throw new NonExistingProductException();
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

		return producto;
	}

	@Override
	public void insertProducto(Producto producto) throws SQLException, NoIdObtainedException, ExistingProductException {
		try {
			sql = "SELECT * FROM PRODUCTOS WHERE COD_PRODUCTO = " + "'" + producto.getCodigoProducto() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				throw new ExistingProductException();
			} else {
				try {
					sql = "INSERT INTO PRODUCTOS (COD_PRODUCTO, DESCRIPCION, CANTIDAD, PRECIO_UNITARIO) VALUES (?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

					pstmt.setInt(1, producto.getCodigoProducto());
					pstmt.setString(2, producto.getDescripcion());
					pstmt.setInt(3, producto.getCantidad());
					pstmt.setDouble(4, producto.getPrecioUnitario());

					pstmt.executeUpdate();
					conn.commit();

					try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							producto.setIdProducto(generatedKeys.getInt(1));
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
	public void updateProducto(Producto producto) throws SQLException, NonExistingProductException {
		try {
			sql = "SELECT * FROM PRODUCTOS WHERE COD_PRODUCTO = " + "'" + producto.getCodigoProducto() + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "UPDATE PRODUCTOS SET COD_PRODUCTO = ?, DESCRIPCION = ?, CANTIDAD = ?, PRECIO_UNITARIO = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setInt(1, producto.getCodigoProducto());
					pstmt.setString(2, producto.getDescripcion());
					pstmt.setInt(3, producto.getCantidad());
					pstmt.setDouble(4, producto.getPrecioUnitario());

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
				throw new NonExistingProductException();
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
	public void deleteProducto(int codigoProducto) throws SQLException, NonExistingProductException {
		try {
			sql = "SELECT * FROM PRODUCTOS WHERE COD_PRODUCTO = " + "'" + codigoProducto + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				try {
					sql = "DELETE FROM PRODUCTOS WHERE COD_PRODUCTO = ?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setInt(1, codigoProducto);
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
				}else {
					throw new NonExistingProductException();
				}
			}finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException sqle3) {
					sqle3.printStackTrace();
				}
			}
	}
}