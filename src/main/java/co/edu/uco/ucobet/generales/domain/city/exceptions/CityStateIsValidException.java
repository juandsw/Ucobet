package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityStateIsValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityStateIsValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityStateIsValidException create() {
		
		var userMessage = "La ciudad del estado no es valida";
		return new CityStateIsValidException(userMessage, userMessage, new Exception());
		
		
	}

}
