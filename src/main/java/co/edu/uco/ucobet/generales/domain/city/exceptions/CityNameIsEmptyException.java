package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityNameIsEmptyException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameIsEmptyException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameIsEmptyException");
		return new CityNameIsEmptyException(userMessage, userMessage, new Exception());
	}

}
