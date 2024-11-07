package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class RuleUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public RuleUcobetException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.RULE, rootException);
	}
	
	public static RuleUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new RuleUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static RuleUcobetException create(final String userMessage, final Exception rootException) {
		
		return new RuleUcobetException(userMessage, userMessage, rootException);
	}
	
	public static RuleUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new RuleUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static RuleUcobetException create( final String userMessage) {
		
		return new RuleUcobetException(userMessage, userMessage, new Exception());
	}

}

