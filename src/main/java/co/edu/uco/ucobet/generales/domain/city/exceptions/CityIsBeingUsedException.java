package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityIsBeingUsedException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityIsBeingUsedException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityIsBeingUsedException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIsBeingUsedException");
		return new CityIsBeingUsedException(userMessage, userMessage, new Exception());
	}

}
