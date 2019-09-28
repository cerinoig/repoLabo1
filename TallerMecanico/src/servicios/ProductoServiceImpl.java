package servicios;

import java.sql.SQLException;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import entidades.Producto;
import excepciones.ExistingUserException;
import excepciones.NonExistingUserException;

public class ProductoServiceImpl implements ProductoService {

	private Producto producto = new Producto();
	private ProductoDAO productoDAO = new ProductoDAOImpl();

	@Override
	public Producto selectProducto(int codigoProducto) throws SQLException, NonExistingUserException {
		try {
			producto = productoDAO.selectProducto(codigoProducto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		if (producto.getCodigoProducto() != 0) {
			return producto;
		} else {
			throw new NonExistingUserException();
		}
	}

	@Override
	public void insertProducto(Producto producto) throws SQLException, ExistingUserException {
		if (productoDAO.buscarProducto(producto.getCodigoProducto())) {
			throw new ExistingUserException();
		} else {
			productoDAO.insertProducto(producto);
		}
	}

	@Override
	public void updateProducto(Producto producto) throws SQLException, NonExistingUserException {
		if (productoDAO.buscarProducto(producto.getCodigoProducto())) {
			productoDAO.updateProducto(producto);
		} else {
			throw new NonExistingUserException();
		}
	}

	@Override
	public void deleteProducto(int codigoProducto) throws SQLException, NonExistingUserException {
		if (productoDAO.buscarProducto(codigoProducto)) {
			productoDAO.deleteProducto(codigoProducto);
		} else {
			throw new NonExistingUserException();
		}
	}
}
