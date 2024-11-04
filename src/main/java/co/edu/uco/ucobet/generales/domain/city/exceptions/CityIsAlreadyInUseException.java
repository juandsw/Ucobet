package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIsAlreadyInUseException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIsAlreadyInUseException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityIsAlreadyInUseException create() {
		
		var userMessage = "La ciudad ingresada ya está siendo usada para este estado";
		return new CityIsAlreadyInUseException(userMessage, userMessage, new Exception());
		
	}
	
	

}
