package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdDoesExistException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdDoesExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	
	}
	
	public static final CityIdDoesExistException create() {
		
		var userMessage = "Ya existe la ciudad con el identificador dado...";
		return new CityIdDoesExistException(userMessage, userMessage, new Exception());
		
	}
	
	

}
