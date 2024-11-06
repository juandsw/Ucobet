package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdIsEmptyException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsEmptyException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);

	}

	public static final CityIdIsEmptyException create() {
		var userMessage = " ";
		return new CityIdIsEmptyException(userMessage, userMessage, new Exception());
	}
}
