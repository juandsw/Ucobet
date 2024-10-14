package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class CrosscuttingUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public CrosscuttingUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.CROSSCUTTING, rootException);
	}
	
	public static final CrosscuttingUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new CrosscuttingUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final CrosscuttingUcobetException create(final String userMessage, final Exception rootException) {
		
		return new CrosscuttingUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final CrosscuttingUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new CrosscuttingUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final CrosscuttingUcobetException create( final String userMessage) {
		
		return new CrosscuttingUcobetException(userMessage, userMessage, new Exception());
	}

}
