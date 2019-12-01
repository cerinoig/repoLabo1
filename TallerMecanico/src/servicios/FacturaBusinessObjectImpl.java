package servicios;

import java.util.List;

import dao.FacturaDAO;
import entidades.Factura;
import excepciones.CamposVaciosException;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;

public class FacturaBusinessObjectImpl implements FacturaBusinessObject {

	public FacturaBusinessObjectImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setDAO(FacturaDAO facturaDAO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factura selectFactura(int idFactura) throws TallerMecanicoException, CamposVaciosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFactura(Factura factura)
			throws TallerMecanicoException, NoIdObtainedException, CamposVaciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFactura(Factura factura) throws TallerMecanicoException, CamposVaciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFactura(int idFactura) throws TallerMecanicoException, CamposVaciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> selectAll() throws TallerMecanicoException {
		// TODO Auto-generated method stub
		return null;
	}

}
