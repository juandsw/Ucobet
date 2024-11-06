package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityIdIsNullException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityIdIsNullException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityIdIsNullException create() {
		var userMessage = " ";
		return new CityIdIsNullException(userMessage, userMessage, new Exception());
	}

}
