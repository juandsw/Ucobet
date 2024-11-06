package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcobetException;

public class StateDoesNotExistException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	public StateDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final StateDoesNotExistException create() {
		var userMessage = "El estadod no existe";
		return new StateDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
