package dao;

import java.util.List;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;

public interface AutoDAO {

	Auto selectAuto(String patente) throws TallerMecanicoException, NonExistingCarException;

	void insertAuto(Auto auto) throws TallerMecanicoException, NoIdObtainedException, ExistingCarException;

	void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException;

	void deleteAuto(String patente) throws TallerMecanicoException, NonExistingCarException;
	
	List<Auto> selectAll() throws TallerMecanicoException;

}
