package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdFormatIsValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdFormatIsValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityIdFormatIsValidException create() {
		
		var userMessage = "La ciudad tiene un identificador con formato válido correspondiente al valor por defecto...";
		return new CityIdFormatIsValidException(userMessage, userMessage, new Exception());
		
		
	}

}
