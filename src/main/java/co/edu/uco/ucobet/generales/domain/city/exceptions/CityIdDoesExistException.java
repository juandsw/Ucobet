package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class CityIdDoesExistException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdDoesExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityIdDoesExistException create(MessageCatalogService messageCatalogService) {
		
		var userMessage = messageCatalogService.getMessage("CityIdDoesExistException");
		return new CityIdDoesExistException(userMessage, userMessage, new Exception());
		
	}
	
	

}
