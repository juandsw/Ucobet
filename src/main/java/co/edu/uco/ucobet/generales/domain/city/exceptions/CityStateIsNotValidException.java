package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityStateIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityStateIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityStateIsNotValidException create() {
		
		var userMessage = "La ciudad del estado no es valida";
		return new CityStateIsNotValidException(userMessage, userMessage, new Exception());
		
		
	}

}
