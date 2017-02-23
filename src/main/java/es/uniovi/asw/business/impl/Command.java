package es.uniovi.asw.business.impl;

import es.uniovi.asw.modelos.exception.*;

public interface Command {
	Object execute() throws BusinessException;
}
