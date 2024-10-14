package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final class CityIdDoesNotExistsExcepcion extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private CityIdDoesNotExistsExcepcion(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final CityIdDoesNotExistsExcepcion create() {
		
		var userMessage = "No existe la ciudad con el identificador dado...";
		return new CityIdDoesNotExistsExcepcion(userMessage, userMessage, new Exception());
	
	}






}
