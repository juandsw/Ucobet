package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class ApplicationUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public ApplicationUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.APPLICATION, rootException);
	}
	
	public static final ApplicationUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new ApplicationUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final ApplicationUcobetException create(final String userMessage, final Exception rootException) {
		
		return new ApplicationUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final ApplicationUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new ApplicationUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final ApplicationUcobetException create( final String userMessage) {
		
		return new ApplicationUcobetException(userMessage, userMessage, new Exception());
	}

}
