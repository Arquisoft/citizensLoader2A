package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.modelos.exception.*;

public interface AdminService {

	void newCitizen(Citizen citizen) throws BusinessException;
}
