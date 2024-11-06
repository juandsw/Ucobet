package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class CityIdFormatIsNotValidException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public CityIdFormatIsNotValidException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);

	}

	public static final CityIdFormatIsNotValidException create() {
		var userMessage = "";
		return new CityIdFormatIsNotValidException(userMessage, userMessage, new Exception());
	}
}
