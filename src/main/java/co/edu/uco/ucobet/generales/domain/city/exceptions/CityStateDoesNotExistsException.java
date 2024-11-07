package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityStateDoesNotExistsException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityStateDoesNotExistsException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityStateDoesNotExistsException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityStateDoesNotExistsException");
		return new CityStateDoesNotExistsException(userMessage, userMessage, new Exception());
	}

}
