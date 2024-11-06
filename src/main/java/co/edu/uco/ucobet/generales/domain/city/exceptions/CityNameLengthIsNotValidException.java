package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityNameLengthIsNotValidException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameLengthIsNotValidException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameLengthIsNotValidException create() {
		var userMessage = " La longitud del nombre no es valida";
		return new CityNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
