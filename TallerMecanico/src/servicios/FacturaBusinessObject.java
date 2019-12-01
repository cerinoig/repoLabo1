package servicios;

import java.util.List;

import dao.FacturaDAO;
import entidades.Factura;
import excepciones.CamposVaciosException;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;

public interface FacturaBusinessObject {

	void setDAO(FacturaDAO facturaDAO);

	Factura selectFactura(int idFactura) throws TallerMecanicoException, CamposVaciosException;

	void insertFactura(Factura factura)
			throws TallerMecanicoException, NoIdObtainedException, CamposVaciosException;

	void updateFactura(Factura factura) throws TallerMecanicoException, CamposVaciosException;

	void deleteFactura(int idFactura) throws TallerMecanicoException, CamposVaciosException;

	List<Factura> selectAll() throws TallerMecanicoException;

}
