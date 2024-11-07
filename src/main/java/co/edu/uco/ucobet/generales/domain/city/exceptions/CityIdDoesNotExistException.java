package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityIdDoesNotExistException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityIdDoesNotExistException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	
	public static final CityIdDoesNotExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdDoesNotExistException");
		return new CityIdDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
