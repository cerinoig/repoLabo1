package servicios;

import java.util.List;

import dao.FacturaDAO;
import entidades.Factura;
import excepciones.CamposVaciosException;
import excepciones.FacturaExistenteException;
import excepciones.FacturaNoExistenteException;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;

public interface FacturaBusinessObject {

	void setDAO(FacturaDAO facturaDAO);

	Factura selectFactura(int idFactura)
			throws TallerMecanicoException, CamposVaciosException, FacturaNoExistenteException;

	void insertFactura(Factura factura)
			throws TallerMecanicoException, NoIdObtainedException, CamposVaciosException, FacturaExistenteException;

	void updateFactura(Factura factura)
			throws TallerMecanicoException, CamposVaciosException, FacturaNoExistenteException;

	void deleteFactura(int idFactura)
			throws TallerMecanicoException, CamposVaciosException, FacturaNoExistenteException;

	void cobrarArreglo(List<Factura> facturas) throws TallerMecanicoException;

	List<Factura> selectAll() throws TallerMecanicoException;

}
