package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdIsNotEmptyException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsNotEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityIdIsNotEmptyException create() {
		
		var userMessage = "La ciudad no tiene un identificador vacío...";
		throw new CityIdIsEmptyException(userMessage, userMessage, new Exception());
		
	}

}
