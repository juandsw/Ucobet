package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class ControllerUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public ControllerUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.CONTROLLER, rootException);
	}
	
	public static final ControllerUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new ControllerUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final ControllerUcobetException create(final String userMessage, final Exception rootException) {
		
		return new ControllerUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final ControllerUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new ControllerUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final ControllerUcobetException create( final String userMessage) {
		
		return new ControllerUcobetException(userMessage, userMessage, new Exception());
	}

}
