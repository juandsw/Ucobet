package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityNameFormatIsNotValidException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameFormatIsNotValidException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameFormatIsNotValidException");
		return new CityNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
