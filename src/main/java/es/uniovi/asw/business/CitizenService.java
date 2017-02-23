package es.uniovi.asw.business;

import es.uniovi.asw.modelos.Citizen;
import es.uniovi.asw.modelos.exception.*;

public interface CitizenService {

	void newCitizen(Citizen citizen) throws BusinessException;
}
