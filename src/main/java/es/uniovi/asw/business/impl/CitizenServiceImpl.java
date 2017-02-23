package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.impl.citizen.AddCitizen;
import es.uniovi.asw.business.impl.citizen.IsCitizenInDatabase;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.*;

public class CitizenServiceImpl implements CitizenService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void newCitizen(Citizen citizen) throws BusinessException {
		executor.execute(new AddCitizen( citizen ));
	}
	
	@Override
	public boolean isCitizenInDatabase(Citizen citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsCitizenInDatabase( citizen ));
	}
}
