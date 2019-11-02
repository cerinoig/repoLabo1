package servicios;

import java.util.List;

import dao.AutoDAO;
import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;

public interface AutoBusinessObject {

	void setDAO(AutoDAO autoDAO);

	Auto selectAuto(String patente) throws TallerMecanicoException, NonExistingCarException;

	void insertAuto(Auto auto) throws TallerMecanicoException, ExistingCarException, NoIdObtainedException;

	void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException;

	void deleteAuto(String patente) throws TallerMecanicoException, NonExistingCarException;
	
	List<Auto> selectAll() throws TallerMecanicoException;

}
