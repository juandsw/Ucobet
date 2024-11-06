package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityIsBeingUsedException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityIsBeingUsedException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityIsBeingUsedException create() {
		var userMessage = " ";
		return new CityIsBeingUsedException(userMessage, userMessage, new Exception());
	}

}
