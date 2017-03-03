package es.uniovi.asw.business;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.*;

public interface CitizenService {

	void insertCitizen(Citizen citizen) throws BusinessException;

	boolean isCitizenInDatabase(Citizen citizen) throws BusinessException;
	
}
