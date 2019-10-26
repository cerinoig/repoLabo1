package dao;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;

public interface AutoDAO {

	public Auto selectAuto(String patente) throws TallerMecanicoException, NonExistingCarException;

	public void insertAuto(Auto auto) throws TallerMecanicoException, NoIdObtainedException, ExistingCarException;

	public void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException;

	public void deleteAuto(String patente) throws TallerMecanicoException, NonExistingCarException;

}
