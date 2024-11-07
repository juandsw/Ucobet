package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class CityNameLengthIsNotValidException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	public CityNameLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameLengthIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameLengthIsNotValidException");
		return new CityNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
