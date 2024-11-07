package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class CityIdIsEmptyException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsEmptyException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);

	}

	public static final CityIdIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdIsEmptyException");
		return new CityIdIsEmptyException(userMessage, userMessage, new Exception());
	}
}
