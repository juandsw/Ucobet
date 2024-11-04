package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityNameIsNullException create() {
		
		var userMessage = "El nombre de la ciudad llegó nulo";
		return new CityNameIsNullException(userMessage, userMessage, new Exception());
	
	}
	
	

}
