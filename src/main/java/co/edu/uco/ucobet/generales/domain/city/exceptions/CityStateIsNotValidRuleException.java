package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final  class CityStateIsNotValidRuleException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityStateIsNotValidRuleException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityStateIsNotValidRuleException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityStateIsNotValidRuleException");
		return new CityStateIsNotValidRuleException(userMessage, userMessage, new Exception());
	}

}
   