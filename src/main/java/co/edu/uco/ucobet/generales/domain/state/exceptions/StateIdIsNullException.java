package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	public StateIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final StateIdIsNullException create() {
		
		var userMessage = "El id de la ciudad es nulo";
		return new StateIdIsNullException(userMessage, userMessage, new Exception());
		
	}

}
