package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public final  class CityStateIsNotValidRuleException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;

	private CityStateIsNotValidRuleException(String technicalMessage, String userMessager, Exception rootException) {
		super(technicalMessage, userMessager, rootException);
	}
	
	public static final CityStateIsNotValidRuleException create() {
		var userMessage = "El estado no es valido";
		return new CityStateIsNotValidRuleException(userMessage, userMessage, new Exception());
	}

}
   