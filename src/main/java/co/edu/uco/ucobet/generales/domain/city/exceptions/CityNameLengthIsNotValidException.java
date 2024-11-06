package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameLengthIsNotValidException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	public CityNameLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final CityNameLengthIsNotValidException create() {
		
		var userMessage = "La longitud del nombre de la ciudad es inválido";
		return new CityNameLengthIsNotValidException(userMessage, userMessage, new Exception());
		
	}

}
