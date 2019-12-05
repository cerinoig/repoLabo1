package dao;

import java.util.List;

import entidades.Factura;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;

public interface FacturaDAO {

	Factura selectFactura(int codigoFactura) throws TallerMecanicoException;

	void insertFactura(Factura factura) throws TallerMecanicoException, NoIdObtainedException;

	void cobrarArreglo(List<Factura> facturas) throws TallerMecanicoException;

	void updateFactura(Factura facturas) throws TallerMecanicoException;

	void deleteFactura(int codigoFactura) throws TallerMecanicoException;

	List<Factura> selectAll() throws TallerMecanicoException;

}
