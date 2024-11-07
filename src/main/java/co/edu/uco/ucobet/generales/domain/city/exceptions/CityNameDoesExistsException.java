package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityNameDoesExistsException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameDoesExistsException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameDoesExistsException create(MessageCatalogService messageCatalogService) {
		var userMessage = "...";
		return new CityNameDoesExistsException(userMessage, userMessage, new Exception());
	}

}
