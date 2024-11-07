package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityIdIsNullException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityIdIsNullException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityIdIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdIsNullException");
		return new CityIdIsNullException(userMessage, userMessage, new Exception());
	}

}
