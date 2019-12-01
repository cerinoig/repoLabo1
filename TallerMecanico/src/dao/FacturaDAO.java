package dao;

import java.util.List;

import entidades.Auto;
import entidades.Factura;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;

public interface FacturaDAO {

	Factura selectFactura(int codigoFactura) throws TallerMecanicoException;

	void insertFactura(Factura factura) throws TallerMecanicoException, NoIdObtainedException;

	void cobrarArreglo(Factura factura) throws TallerMecanicoException;

	void updateFactura(Factura factura) throws TallerMecanicoException;

	void deleteFactura(int codigoFactura) throws TallerMecanicoException;

	List<Factura> selectAll() throws TallerMecanicoException;

}
