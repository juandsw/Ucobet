package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class CityIdFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdFormatIsNotValidException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);

	}

	public static final CityIdFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdFormatIsNotValidException");
		return new CityIdFormatIsNotValidException(userMessage, userMessage, new Exception());
	}
}
