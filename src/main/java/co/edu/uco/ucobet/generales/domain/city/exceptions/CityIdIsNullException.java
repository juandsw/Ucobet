package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final CityIdIsNullException create() {
		
		var userMessage = "La ciudad tiene un identificador nulo";
		return new CityIdIsNullException(userMessage, userMessage, new Exception());
		
	}

	

}
