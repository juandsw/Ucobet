package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityNameIsUniqueForStateException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityNameIsUniqueForStateException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final CityNameIsUniqueForStateException create() {
		
		var userMessage = "Ya existe una ciudad con este nombre asociada a el estado";
		return new CityNameIsUniqueForStateException(userMessage, userMessage, new Exception());
		
	}

}
