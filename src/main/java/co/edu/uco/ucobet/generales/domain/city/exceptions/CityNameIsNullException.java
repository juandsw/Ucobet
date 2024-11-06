package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityNameIsNullException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameIsNullException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameIsNullException create() {
		var userMessage = " El nombre de la ciudad es nulo";
		return new CityNameIsNullException(userMessage, userMessage, new Exception());
	}

}
