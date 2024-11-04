package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityNameFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final CityNameFormatIsNotValidException create() {
		
		var userMessage = "El formato del nombre de la ciudad no es válido";
		return new CityNameFormatIsNotValidException(userMessage, userMessage, new Exception());
		
	}
	
	

}
