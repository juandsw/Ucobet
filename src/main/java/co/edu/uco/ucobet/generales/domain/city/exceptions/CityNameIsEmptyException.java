package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityNameIsEmptyException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityNameIsEmptyException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityNameIsEmptyException create() {
		var userMessage = " El nombre de la ciudad se encuentra vacío";
		return new CityNameIsEmptyException(userMessage, userMessage, new Exception());
	}

}
